package com.snb.automation.testcases;

import org.openqa.selenium.By;

import org.testng.Assert;
//import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.snb.automation.base.BrowserFactory;
import com.snb.automation.base.Constants;
import com.snb.automation.base.ExtentManager;
import com.snb.automation.base.TestBase;
import com.snb.automation.objectrepository.OR;
import com.snb.automation.utilities.Log;

public class CSRLandingPageTestCases extends TestBase {

	@Test
	public void CSRverifyLoginandLogOut(){
		try {
			Log.startTestCase("CSRverifyLoginandLogOut");
			snbTestCases = snbreports.startTest("SNBUSA-41: CSR User Login");
			Assert.assertEquals(driver.getCurrentUrl(), "http://localhost:7777/portalserver/snb-csr/index");
			Thread.sleep(3000);
			snbTestCases.log(LogStatus.PASS, "Home Page is displayed", snbTestCases.addScreenCapture(
					ExtentManager.CaptureScreen(driver, Constants.CSRscreenShot_Path + "CSR Login Expected Status")));

			Thread.sleep(3000);
			driver.findElement(By.name(OR.CSRuserNameTxtField)).sendKeys("tstark");
			driver.findElement(By.name(OR.CSRpasswordTxtField)).sendKeys("Password1!");
			snbTestCases.log(LogStatus.INFO, "Clicking on CSR Login Button");
			
			snbTestCases.log(LogStatus.PASS, "CSR User Login", snbTestCases.addScreenCapture(
					ExtentManager.CaptureScreen(driver, Constants.CSRscreenShot_Path + "CSR Login Completed Status")));
			
			driver.findElement(By.id(OR.CSRloginBtn)).click();
			Thread.sleep(5000);
			Assert.assertEquals(driver.getCurrentUrl(), "http://localhost:7777/portalserver/home");
			
			snbTestCases.log(LogStatus.PASS, "Opens an Account Page with CSR Users", snbTestCases.addScreenCapture(
					ExtentManager.CaptureScreen(driver, Constants.CSRscreenShot_Path + "CSR Accounts Page")));

			snbTestCases.log(LogStatus.INFO, "Clicking on CSR Log Out Button");
			driver.findElement(By.xpath(OR.CSRLogout)).click();
			Thread.sleep(5000);
			Assert.assertEquals(driver.getCurrentUrl(), "http://localhost:7777/portalserver/snb-csr/index");
			snbTestCases.log(LogStatus.PASS, "Successful LogOut", snbTestCases.addScreenCapture(
					ExtentManager.CaptureScreen(driver, Constants.CSRscreenShot_Path + "CSR Logout return Page")));

		} catch (Exception e) {
			Assert.fail(e.toString());
			snbTestCases.addScreenCapture(ExtentManager.CaptureScreen(driver, Constants.CSRscreenShot_Path + "CSRError"));
			Log.error("Expection occured while executing test case:" + "CSRverifyLoginandLogOut" + " :" + e.toString());
			snbTestCases.log(LogStatus.ERROR, e.toString());

		}
	}
}
