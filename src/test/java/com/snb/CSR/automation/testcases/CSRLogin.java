package com.snb.CSR.automation.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.snb.automation.base.Constants;
import com.snb.automation.base.ExtentManager;
import com.snb.automation.base.TestBase;
import com.snb.automation.base.TestData;
import com.snb.automation.objectrepository.OR;
import com.snb.automation.utilities.Log;

public class CSRLogin extends TestBase {

	@Test 
	public void CSRverifyLogin(){
		try {
			Log.startTestCase("CSRverifyLogin");
			snbTestCases = snbreports.startTest("SNBUSA-41: CSR User Login with Authenticated User");
			Assert.assertEquals(driver.getCurrentUrl(), Constants.CSRLogin_url);
			Thread.sleep(3000);
			snbTestCases.log(LogStatus.PASS, "Home Page is displayed", snbTestCases.addScreenCapture(
					ExtentManager.CaptureScreen(driver, Constants.CSRscreenShot_Path + "CSR Login Expected Status")));
			Thread.sleep(3000);
			driver.findElement(By.name(OR.CSRuserNameTxtField)).clear();
			driver.findElement(By.name(OR.CSRuserNameTxtField)).sendKeys(TestData.csr_UserName);
			driver.findElement(By.name(OR.CSRpasswordTxtField)).sendKeys(TestData.csr_password);
			snbTestCases.log(LogStatus.INFO, "Clicking on CSR Login Button");
			
			snbTestCases.log(LogStatus.PASS, "CSR User Login", snbTestCases.addScreenCapture(
					ExtentManager.CaptureScreen(driver, Constants.CSRscreenShot_Path + "CSR Login Completed Status")));
			
			driver.findElement(By.id(OR.CSRloginBtn)).click();
			//Thread.sleep(5000);
			wait.until(ExpectedConditions.titleIs(TestData.csr_AccountPage_URL));
			Assert.assertEquals(driver.getCurrentUrl(), TestData.csr_AccountPage_URL);
			
			snbTestCases.log(LogStatus.PASS, "Opens an Account Page with CSR Users", snbTestCases.addScreenCapture(
					ExtentManager.CaptureScreen(driver, Constants.CSRscreenShot_Path + "CSR Accounts Page")));
			
			driver.findElement(By.xpath(OR.CSRLogout)).click();
			Thread.sleep(5000);
			Assert.assertEquals(driver.getCurrentUrl(), Constants.CSRLogin_url);

			Thread.sleep(3000);
			
			snbTestCases.log(LogStatus.INFO, "Verifying CSR User Login with Invalid Credentials");
			driver.findElement(By.name(OR.CSRuserNameTxtField)).clear();
			
			driver.findElement(By.name(OR.CSRuserNameTxtField)).sendKeys("tstark");
			driver.findElement(By.name(OR.CSRpasswordTxtField)).sendKeys("Password");
			snbTestCases.log(LogStatus.INFO, "Clicking on CSR Login Button");
			snbTestCases.log(LogStatus.INFO, "CSR User Login with Authenticated User and Wrong Password", snbTestCases.addScreenCapture(
					ExtentManager.CaptureScreen(driver, Constants.CSRscreenShot_Path + "CSR Login Status with Authenticated User and Wrong Password")));
			driver.findElement(By.id(OR.CSRloginBtn)).click();
			Thread.sleep(5000);
			snbTestCases.log(LogStatus.PASS, "CSR User Login showing CANNOT_AUTHENTICATE", snbTestCases.addScreenCapture(ExtentManager.CaptureScreen(driver, Constants.CSRscreenShot_Path + "CSR Login Error with wrong password")));
			Thread.sleep(3000);
			
			Log.startTestCase("CSRverifyLogin");
			snbTestCases.log(LogStatus.INFO, "Verifying CSR User with Un-authenticated Credentials");
			Thread.sleep(3000);
			driver.findElement(By.name(OR.CSRuserNameTxtField)).clear();
			driver.findElement(By.name(OR.CSRuserNameTxtField)).sendKeys("srhodes");
			driver.findElement(By.name(OR.CSRpasswordTxtField)).sendKeys("Password");
			snbTestCases.log(LogStatus.INFO, "Clicking on CSR Login Button");
			
			snbTestCases.log(LogStatus.INFO, "CSR User Login with Unauthenticated User", snbTestCases.addScreenCapture(
					ExtentManager.CaptureScreen(driver, Constants.CSRscreenShot_Path + "CSR Login Status with Unauthenticated Users")));
			
			driver.findElement(By.id(OR.CSRloginBtn)).click();
			Thread.sleep(5000);

			snbTestCases.log(LogStatus.PASS, "CSR User Login showing CANNOT_AUTHENTICATE ", snbTestCases.addScreenCapture(
					ExtentManager.CaptureScreen(driver, Constants.CSRscreenShot_Path + "CSR Login Error with Unauthenticated Users")));

			
		} catch (Exception e) {
			Assert.fail(e.toString());
			snbTestCases.addScreenCapture(ExtentManager.CaptureScreen(driver, Constants.CSRscreenShot_Path + "CSRError"));
			Log.error("Expection occured while executing test case:" + "CSRverifyLoginandLogOut" + " :" + e.toString());
			snbTestCases.log(LogStatus.ERROR, e.toString());

		}
	}
}