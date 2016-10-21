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

public class OAPLandingPageTestCase extends TestBase {

	@Test
	public void OAPverifyLoginandLogOut()

	{
		try {
			Log.startTestCase("OAPverifyLoginandLogOut");
			snbTestCases = snbreports.startTest("SNBUSA-: OAP User Login");
			Assert.assertEquals(driver.getCurrentUrl(),"http://localhost:7777/portalserver/snb-oap/index");
			snbTestCases.log(LogStatus.INFO, "OAP Landing Page is displayed", snbTestCases.addScreenCapture(ExtentManager.CaptureScreen(driver, Constants.OAPscreenShot_Path+"OAP Login Expected Status")));

			//snbTestCases.addScreenCapture(ExtentManager.CaptureScreen(driver, Constants.screenShot_Path + "OAP Login Expected Status"));
			//snbTestCases.log(LogStatus.PASS, "OAP Landing Page is displayed");
			
			driver.findElement(By.name(OR.OAPuserNameTxtField)).sendKeys("srhodes");
			driver.findElement(By.name(OR.OAPpasswordTxtField)).sendKeys("Password1!");
			snbTestCases.log(LogStatus.INFO, "Clicking on OAP Login Button");

			snbTestCases.log(LogStatus.INFO, "Clicking on OAP Login Button", snbTestCases.addScreenCapture(ExtentManager.CaptureScreen(driver, Constants.OAPscreenShot_Path+ "OAP Login Completed Status")));
			driver.findElement(By.id(OR.OAPloginBtn)).click();
			Thread.sleep(3000);
			Assert.assertEquals(driver.getCurrentUrl(), "http://localhost:7777/portalserver/home");
			snbTestCases.log(LogStatus.PASS, "Opens an Account Page", snbTestCases.addScreenCapture(
					ExtentManager.CaptureScreen(driver, Constants.OAPscreenShot_Path + "OAP Accounts Page")));
			snbTestCases.addScreenCapture(ExtentManager.CaptureScreen(driver, Constants.OAPscreenShot_Path + "OAP Login Completed Status"));
			Thread.sleep(7000);
			Assert.assertEquals(driver.getCurrentUrl(), "http://localhost:7777/portalserver/snb-oap/accounts");
			//snbTestCases.addScreenCapture(ExtentManager.CaptureScreen(driver, Constants.screenShot_Path + "OAP AccountPage"));
			//snbTestCases.log(LogStatus.PASS, "OAP Account Page is displayed",snbTestCases.addScreenCapture(ExtentManager.CaptureScreen(driver, Constants.screenShot_Path + "OAP AccountPage")));
			} catch (Exception e) {
				//snbTestCases.addScreenCapture(ExtentManager.CaptureScreen(driver, Constants.screenShot_Path + "CSRError"));
				Log.error("Expection occured while executing test case:" + "OAPverifyLoginandLogOut" + " :" + e.toString());
				snbTestCases.log(LogStatus.FAIL,"Failed TestCase",snbTestCases.addScreenCapture(ExtentManager.CaptureScreen(driver, Constants.OAPscreenShot_Path + "CSRError")));
				Assert.fail(e.toString());

		}
	}
}
