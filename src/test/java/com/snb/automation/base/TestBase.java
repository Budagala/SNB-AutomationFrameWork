package com.snb.automation.base;

import java.net.URL;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.snb.automation.utilities.Log;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class TestBase {
	
	//protected 
	protected WebDriver driver;
	protected ExtentReports snbreports;
	protected ExtentTest snbTestCases;
	protected WebDriverWait wait;
	
	@Parameters({"projectURL","reportType","browser"})
	@BeforeClass
	//public void globalSetUP(String projectURL, String reportType,String browser)
	public void globalSetUP(String projectURL, String reportType,String browser)
	{
		DOMConfigurator.configure(Constants.logConfigxmlPath);
		snbreports = ExtentManager.instance(reportType);	
		driver = BrowserFactory.openBrowser(browser,projectURL);
		wait= new WebDriverWait(driver, Constants.wait_time);

	}

	@AfterMethod
	public void afterTestCompletes(ITestResult result)
	{
		//snbTestCases.log(LogStatus.INFO,snbTestCases.addScreenCapture(Constants.screenShot_Path+result.getName()));
		snbreports.endTest(snbTestCases);
		Log.endTestCase(result.getName());

	}
	
	@AfterClass
	public void closeBrowser() {
		snbreports.flush();
		snbreports.close();
		driver.quit();

	}

}
