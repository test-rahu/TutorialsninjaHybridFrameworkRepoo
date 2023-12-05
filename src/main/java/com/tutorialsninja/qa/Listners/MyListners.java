package com.tutorialsninja.qa.Listners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.Titorialasninja.qa.utils.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class MyListners implements ITestListener{
	ExtentReports extentReport;
	ExtentTest extentTest;

	
	@Override
	public void onStart(ITestContext context) {
	
//	System.out.println("Execution of Project Tests started");
		 extentReport = ExtentReporter.GenerateExtentReport();
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		String testName=result.getName();
		extentTest = extentReport.createTest(testName);
		extentTest.log(Status.INFO,testName+"started Executing");
		//System.out.println(testName+" started Executing");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testName=result.getName();
		extentTest.log(Status.PASS, testName+"got successfully executed");
		//System.out.println(testName+"got successfully executed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName=result.getName();
		System.out.println("ScreenShot Taken");
		//below code is to get driver as an object here
		WebDriver driver= null;
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			
			e.printStackTrace();
		}
		
		
		
		File srcScreenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String destinationScreenshotpath="C:\\Users\\Rahul Rathore\\eclipse-workspace\\TutorialNinjaProj\\ScreenShot\\"+testName+".png";
		try {
			FileHandler.copy(srcScreenshot, new File(destinationScreenshotpath));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		//from above code we have taken the screenshot successfully
		//for attach the scrrenshot taken to extent report below is the code
		extentTest.addScreenCaptureFromPath(destinationScreenshotpath);
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.FAIL, testName+"got failed");
		
//		System.out.println(result.getThrowable());  //will print all exection details
//		System.out.println(testName+"got failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testName=result.getName();
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.SKIP, testName+"got skipped");
		
//		System.out.println(testName+"got skipped");
//		System.out.println(result.getThrowable());
	
	}

	

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Finish executing all project test");
		extentReport.flush();   //if we did not flush all added log are not added
		
		//below code is for to open the test report automatically after the running the test
		String pathofExtentReport= "C:\\Users\\Rahul Rathore\\eclipse-workspace\\TutorialNinjaProj\\test-output\\report\\testreport.html";
		File extentreport =new File(pathofExtentReport);
		try {
			Desktop.getDesktop().browse(extentreport.toURI());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	
	

}
