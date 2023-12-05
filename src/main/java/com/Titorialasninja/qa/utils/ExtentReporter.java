package com.Titorialasninja.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;import org.apache.commons.collections4.bag.SynchronizedSortedBag;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {
	
	public static ExtentReports GenerateExtentReport() {
		
		
		ExtentReports extentReport=new ExtentReports();  //user define method from aventstak
		String path="C:\\Users\\Rahul Rathore\\eclipse-workspace\\TutorialNinjaProj\\test-output\\report\\testreport.html";
		ExtentSparkReporter sparkReporter=new ExtentSparkReporter(path);
		
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("TutorialsninjaReport");
		sparkReporter.config().setDocumentTitle("TN Automation Report");
		sparkReporter.config().setTimeStampFormat("dd/MM/YYYY hh:mm:ss");
		
		extentReport.attachReporter(sparkReporter);
		
		Properties prop=new Properties();
		String configpath="C:\\Users\\Rahul Rathore\\eclipse-workspace\\TutorialNinjaProj\\src\\main\\java\\com\\tutorialsninja\\qa\\config\\config.properties";
		File fisconfigprop=new File(configpath);
		
		try {
		FileInputStream fis=new FileInputStream(fisconfigprop);
		prop.load(fis);
		}catch(Throwable e) {
			e.printStackTrace();
		}
		extentReport.setSystemInfo("Applocation URL", prop.getProperty("url"));
		extentReport.setSystemInfo("BrowserName", prop.getProperty("browers"));
		extentReport.setSystemInfo("Email", prop.getProperty("validemail"));
		extentReport.setSystemInfo("Password", prop.getProperty("validpassword"));
		extentReport.setSystemInfo("Operating Info", System.getProperty("os.name"));
		extentReport.setSystemInfo("Username", System.getProperty("user.name"));
		extentReport.setSystemInfo("java version", System.getProperty("java.version"));
		
		return extentReport;
		
		
	}

}
