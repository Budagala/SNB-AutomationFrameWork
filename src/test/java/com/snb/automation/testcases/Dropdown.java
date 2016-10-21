package com.snb.automation.testcases;

import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.snb.automation.base.TestBase;
import com.snb.automation.base.ExtentManager;
import com.snb.automation.base.BrowserFactory;




public class Dropdown extends TestBase{
	
	@Test
	public void drop(Method method) throws InterruptedException{
		snbTestCases = snbreports.startTest(method.getName());
		
		
		/*WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));
		List<WebElement> byClick = dropdown.findElements(By.tagName("option"));
		for(WebElement option : byClick){
			if("Baby".equals(option.getText().trim()))
				option.click();
		}*/
	Select dropdown = new Select(driver.findElement(By.id("searchDropdownBox")));
	dropdown.selectByVisibleText("Baby");
	WebDriverWait wait = new WebDriverWait(driver,60);
	
	}
	
}

				
				