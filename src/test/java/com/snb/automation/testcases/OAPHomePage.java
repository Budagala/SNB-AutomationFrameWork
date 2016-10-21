package com.snb.automation.testcases;

import org.openqa.selenium.By;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.snb.automation.base.TestBase;
import com.snb.automation.objectrepository.OR;
import com.snb.automation.utilities.Log;

import junit.framework.Assert;

public class OAPHomePage extends TestBase {
	
	@Test
	public void VerifyLogin (ITestResult result)
	{
		try{
			Log.startTestCase(result.getName());
			snbTestCases = snbreports.startTest(result.getName(), "Login to OAP Home Page");
			
			driver.findElement(By.id(OR.OAPuserNameTxtField)).sendKeys("username");
			driver.findElement(By.id(OR.OAPpasswordTxtField)).sendKeys("password");
			Thread.sleep(5000);
			driver.findElement(By.xpath(OR.OAPloginBtn)).click();
			Thread.sleep(7000);
			driver.findElement(By.id(OR.OAPForgotUsernameLink)).click();
			
			driver.findElement(By.linkText(OR.OAPMyProfileLink)).click();
			Assert.assertEquals("Page Title of My Profile", driver.getTitle());
			Thread.sleep(5000);
			driver.navigate().to("Go back to URL from where we started");
			
			driver.findElement(By.linkText(OR.OAPMyBankerLink)).click();
			Assert.assertEquals("Page Title of My Profile", driver.getTitle());
			Thread.sleep(5000);
			driver.navigate().to("Go back to URL from where we started");
			
			driver.findElement(By.linkText(OR.OAPMyUsersLink)).click();
			Assert.assertEquals("Page Title of My Profile", driver.getTitle());
			Thread.sleep(5000);
			driver.navigate().to("Go back to URL from where we started");
			
			driver.findElement(By.id(OR.OAPLogout)).click();

			
		}catch (Exception e){
			Log.error("Exception occured while executing the test case:" +result.getName() +":" +e.toString());
			snbTestCases.log(LogStatus.ERROR,e.toString());
			
		
		}
	}
	
}
