package com.snb.automation.base;

import java.io.File;

import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.NetworkMode;

public class ExtentManager {
	
	//public static ExtentReports instance(String reportPath) 
	public static ExtentReports instance(String reportType){
	    
		ExtentReports extent;
		//extent = new ExtentReports(reportPath,true,NetworkMode.ONLINE);
		extent = new ExtentReports(reportType,true,NetworkMode.ONLINE);
		extent.loadConfig(new File(Constants.reprotConfigFilePath));
		return extent;

	}

	public static String CaptureScreen(WebDriver driver, String ImagesPath) {
		TakesScreenshot oScn = (TakesScreenshot) driver;
		File oScnShot = oScn.getScreenshotAs(OutputType.FILE);
		File oDest = new File(ImagesPath + ".jpg");
		try {
			FileUtils.copyFile(oScnShot, oDest);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return ImagesPath + ".jpg";
	}


}
