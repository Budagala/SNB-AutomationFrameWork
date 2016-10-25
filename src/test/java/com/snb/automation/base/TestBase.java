package com.snb.automation.base;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.snb.automation.utilities.Log;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestBase {

	// protected
	protected WebDriver driver;
	protected ExtentReports snbreports;
	protected ExtentTest snbTestCases;
	protected WebDriverWait wait;

	@Parameters({ "projectURL", "reportType", "browser" })
	@BeforeClass
	public void globalSetUP(String projectURL, String reportType, String browser) {
		DOMConfigurator.configure(Constants.logConfigxmlPath);
		snbreports = ExtentManager.instance(reportType);
		driver = BrowserFactory.openBrowser(browser, projectURL);
		wait = new WebDriverWait(driver, Constants.wait_time);

	}

	/*@Parameters({ "username", "password", "site" })
	@BeforeMethod
	public void beforeTestCase(String username, String password, String site) {
		if (site.equalsIgnoreCase("CSR")) {
			driver.findElement(By.id("")).sendKeys(username);
			driver.findElement(By.id("")).sendKeys(password);

		}

		else {
			driver.findElement(By.id("")).sendKeys(username);
			driver.findElement(By.id("")).sendKeys(password);
		}
	}*/

	@AfterMethod
	public void afterTestCompletes(ITestResult result) {
		
		if(!result.isSuccess())
		{
			snbTestCases.log(LogStatus.ERROR, snbTestCases.addScreenCapture(ExtentManager.CaptureScreen(driver, Constants.OAPscreenShot_Path+result.getName())),result.getThrowable());
			Log.endTestCase(result.getName());
		}
		 
		snbreports.endTest(snbTestCases);
		Log.endTestCase(result.getName());

	}

	@AfterClass
	public void closeBrowser() {
		snbreports.flush();
		snbreports.close();
		//driver.quit();

	}

	public void csrlogin() {

	}

}
