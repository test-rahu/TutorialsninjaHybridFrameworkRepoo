package com.tutorialsninja.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.Titorialasninja.qa.utils.Utilities;

public class Base {
	
	WebDriver driver;
	public Properties prop;
	public Properties dataProp;
	
	public Base() {
		
		String path="C:\\Users\\Rahul Rathore\\eclipse-workspace\\TutorialNinjaProj\\src\\main\\java\\com\\tutorialsninja\\qa\\config\\config.properties";
		String path1="C:\\Users\\Rahul Rathore\\eclipse-workspace\\TutorialNinjaProj\\src\\main\\java\\com\\tutorialsninja\\qa\\testdata\\testdata.properties";
		
		dataProp=new Properties();
		File dataPropFile=new File(path1);
		
		try {
		FileInputStream datafis=new FileInputStream(dataPropFile);
		dataProp.load(datafis);
		
		}catch(Throwable e) {
			e.printStackTrace();
		}
		
		
		
		
		
		prop=new Properties();
		File porpFile=new File(path);
		try {
	
				FileInputStream fis=new FileInputStream(porpFile);
		
		prop.load(fis);
		}catch(Throwable e) {
			e.printStackTrace();			
		}
		
	}
	
	
	
	public WebDriver InitializebrowserOpenApplication(String browersname) {
		
		
		
		if(browersname.equals("chrome")) {
			
			driver=new ChromeDriver();
			
		}else if (browersname.equals("firefox")) {
			 driver=new FirefoxDriver();
		
		}else if (browersname.equals("edge")) {
			
			driver=new EdgeDriver();
		}
		

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_LOAD_TIME));
//			driver.get("https://tutorialsninja.com/demo/");
			driver.get(prop.getProperty("url"));
			return driver;
	}

}
