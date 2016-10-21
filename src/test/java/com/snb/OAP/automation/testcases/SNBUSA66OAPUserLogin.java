package com.snb.OAP.automation.testcases;

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

public class SNBUSA66OAPUserLogin extends TestBase {

	@Test
	public void OAPverifyLoginandLogOut()

	{
		try {
			Log.startTestCase("OAPverifyLoginandLogOut");
			snbTestCases = snbreports.startTest("SNBUSA-66: OAP User Login");
			Assert.assertEquals(driver.getCurrentUrl(),"http://localhost:7777/portalserver/snb-oap/index");
			snbTestCases.log(LogStatus.INFO, "OAP Landing Page is displayed", snbTestCases.addScreenCapture(ExtentManager.CaptureScreen(driver, Constants.OAPscreenShot_Path+"OAP Login Expected Status")));

			//snbTestCases.addScreenCapture(ExtentManager.CaptureScreen(driver, Constants.screenShot_Path + "OAP Login Expected Status"));
			//snbTestCases.log(LogStatus.PASS, "OAP Landing Page is displayed");
			
			driver.findElement(By.name(OR.OAPuserNameTxtField)).sendKeys("srhodes");
			driver.findElement(By.name(OR.OAPpasswordTxtField)).sendKeys("Password1!");
			snbTestCases.log(LogStatus.INFO, "Clicking on OAP Login Button");

			snbTestCases.log(LogStatus.INFO, "OAP User Login", snbTestCases.addScreenCapture(ExtentManager.CaptureScreen(driver, Constants.OAPscreenShot_Path+ "OAP Login Completed Status")));
			driver.findElement(By.id(OR.OAPloginBtn)).click();
			Thread.sleep(3000);
			Assert.assertEquals(driver.getCurrentUrl(), "http://localhost:7777/portalserver/snb-oap/accounts");
			snbTestCases.log(LogStatus.PASS, "Opens an Account Page of OAP Users", snbTestCases.addScreenCapture(
					ExtentManager.CaptureScreen(driver, Constants.OAPscreenShot_Path + "OAP Accounts Page")));
			Thread.sleep(5000);
			
			driver.findElement(By.xpath(OR.OAPLogout)).click();
			Thread.sleep(5000);
			Assert.assertEquals(driver.getCurrentUrl(), "http://localhost:7777/portalserver/snb-oap/index");
			Thread.sleep(3000);
			
			snbTestCases.log(LogStatus.INFO, "Verifying OAP User Login with Invalid Credentials");
			driver.findElement(By.name(OR.OAPuserNameTxtField)).clear();
			driver.findElement(By.name(OR.OAPuserNameTxtField)).sendKeys("SrHodes");
			driver.findElement(By.name(OR.OAPpasswordTxtField)).sendKeys("Password1!");
			snbTestCases.log(LogStatus.INFO, "Clicking on OAP Login Button");
			snbTestCases.log(LogStatus.INFO, "CSR User Login with INAVLID credentials", snbTestCases.addScreenCapture(
					ExtentManager.CaptureScreen(driver, Constants.CSRscreenShot_Path + "OAP Login Status with invalid credentials")));
			driver.findElement(By.id(OR.OAPloginBtn)).click();
			Thread.sleep(5000);
			snbTestCases.log(LogStatus.PASS, "OAP User Login showing error", snbTestCases.addScreenCapture(ExtentManager.CaptureScreen(driver, Constants.OAPscreenShot_Path + "OAP Login Error with wrong password")));
			Thread.sleep(3000);

			snbTestCases.log(LogStatus.INFO, "Verifying OAP User Login with Invalid Username");
			driver.findElement(By.name(OR.OAPuserNameTxtField)).clear();
			driver.findElement(By.name(OR.OAPuserNameTxtField)).sendKeys("tstark");
			driver.findElement(By.name(OR.OAPpasswordTxtField)).sendKeys("Password1!");
			snbTestCases.log(LogStatus.INFO, "Clicking on OAP Login Button");
			snbTestCases.log(LogStatus.INFO, "CSR User Login with INAVLID username", snbTestCases.addScreenCapture(
					ExtentManager.CaptureScreen(driver, Constants.CSRscreenShot_Path + "OAP Login Status with invalid Username")));
			driver.findElement(By.id(OR.OAPloginBtn)).click();
			Thread.sleep(5000);
			snbTestCases.log(LogStatus.PASS, "OAP User Login showing error", snbTestCases.addScreenCapture(ExtentManager.CaptureScreen(driver, Constants.OAPscreenShot_Path + "OAP Login Error with wrong username")));
			Thread.sleep(3000);
			
			} catch (Exception e) {
				//snbTestCases.addScreenCapture(ExtentManager.CaptureScreen(driver, Constants.screenShot_Path + "CSRError"));
				Log.error("Expection occured while executing test case:" + "OAPverifyLoginandLogOut" + " :" + e.toString());
				snbTestCases.log(LogStatus.FAIL,"Failed TestCase",snbTestCases.addScreenCapture(ExtentManager.CaptureScreen(driver, Constants.OAPscreenShot_Path + "OAPError")));
				Assert.fail(e.toString());

		}
	}
}
