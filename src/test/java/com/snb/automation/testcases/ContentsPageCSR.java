package com.snb.automation.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.snb.automation.base.TestBase;
import com.snb.automation.objectrepository.OR;
import com.snb.automation.utilities.Log;

public class ContentsPageCSR extends TestBase{
	
	@Test
	public void CSRContentsPageVerify(ITestResult result){
		try
		{
			Log.startTestCase(result.getName());
			snbTestCases = snbreports.startTest(result.getName());
			driver.findElement(By.id(OR.OAPFindUserField)).sendKeys("name/username/email/company name");
			Thread.sleep(5000);
			driver.findElement(By.id(OR.OAPFindUserSearch)).click();
			Thread.sleep(5000);
			driver.findElement(By.id(OR.OAPFindUserField)).submit();
			Thread.sleep(5000);
			driver.findElement(By.id(OR.CSREnrollUserBtn)).click();
			
			driver.navigate().to("OAP Home Page URL");
			
			//if it look likes a drop down
			Select sel = new Select(driver.findElement(By.id(OR.OAPUserStatusDropDown)));
			sel.selectByVisibleText("Emulate User");
			
			// if it is click able
			driver.findElement(By.id(OR.OAPUserStatusDropDown)).click();
			driver.switchTo().frame("value by inspecting");
			driver.findElement(By.linkText(OR.CSREmulateLink)).click();
			
			//for pagination
			
			
			
		
		}catch (Exception e){
			Log.error("Exception occured while executing test case:" +result.getName() + ":" +e.toString());
			snbTestCases.log(LogStatus.ERROR, e.toString());
		}
	}
	

}
