package com.snb.CSR.automation.testcases;

import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.snb.automation.base.BrowserFactory;
import com.snb.automation.base.Constants;
import com.snb.automation.base.ExtentManager;
import com.snb.automation.base.TestBase;
import com.snb.automation.objectrepository.OR;
import com.snb.automation.utilities.Log;

public class SNBUSA370CSRUserLogout extends TestBase {

	@Test
	public void verifyCSRLogOut(){
		try {
			Log.startTestCase("verifyCSRLogOut");
			snbTestCases = snbreports.startTest("SNBUSA-370: CSR User LogOut");
			Assert.assertEquals(driver.getCurrentUrl(), "http://localhost:7777/portalserver/snb-csr/index");
			Thread.sleep(3000);
			snbTestCases.log(LogStatus.INFO, "Home Page is displayed", snbTestCases.addScreenCapture(
					ExtentManager.CaptureScreen(driver, Constants.CSRscreenShot_Path + "CSR Login Expected Status")));

			Thread.sleep(3000);
			driver.findElement(By.name(OR.CSRuserNameTxtField)).sendKeys("tstark");
			driver.findElement(By.name(OR.CSRpasswordTxtField)).sendKeys("Password1!");
			snbTestCases.log(LogStatus.INFO, "Clicking on CSR Login Button");
			
			snbTestCases.log(LogStatus.INFO, "CSR User Login", snbTestCases.addScreenCapture(
					ExtentManager.CaptureScreen(driver, Constants.CSRscreenShot_Path + "CSR Login Completed Status")));
			
			driver.findElement(By.id(OR.CSRloginBtn)).click();
			Thread.sleep(5000);
			Assert.assertEquals(driver.getCurrentUrl(), "http://localhost:7777/portalserver/home");
			
			snbTestCases.log(LogStatus.INFO, "Opens an Account Page with CSR Users", snbTestCases.addScreenCapture(
					ExtentManager.CaptureScreen(driver, Constants.CSRscreenShot_Path + "CSR Accounts Page")));

			snbTestCases.log(LogStatus.INFO, "Clicking on CSR Log Out Button");
			driver.findElement(By.xpath(OR.CSRLogout)).click();
			Thread.sleep(5000);
			Assert.assertEquals(driver.getCurrentUrl(), "http://localhost:7777/portalserver/snb-csr/index");
			snbTestCases.log(LogStatus.PASS, "Successful LogOut: Returns to CSR Home Page", snbTestCases.addScreenCapture(
					ExtentManager.CaptureScreen(driver, Constants.CSRscreenShot_Path + "CSR Logout return Page")));

		} catch (Exception e) {
			Assert.fail(e.toString());
			snbTestCases.addScreenCapture(ExtentManager.CaptureScreen(driver, Constants.CSRscreenShot_Path + "CSRErrorLogOut"));
			Log.error("Expection occured while executing test case:" + "CSRverifyLogOut" + " :" + e.toString());
			snbTestCases.log(LogStatus.ERROR, e.toString());

		}
	}
}
