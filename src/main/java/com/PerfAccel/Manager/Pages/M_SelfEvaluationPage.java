package com.PerfAccel.Manager.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class M_SelfEvaluationPage {
	WebDriver driver;
	
	@FindBy (xpath="//*[name()='path' and contains(@d,'M6 21a1 1 ')]")
	WebElement SelfEvaluationTab;
	@FindBy (xpath="//*[@class=\"select-button\"]")
	WebElement DropdownButton;
	@FindBy (xpath="//span[@class='quarterYear']")
	WebElement MonthValue;
	
	
	
	
	
	
	
	public M_SelfEvaluationPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void SelfEvalutionDropdown() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(SelfEvaluationTab)).click();
		wait.until(ExpectedConditions.elementToBeClickable(DropdownButton)).click();
		Actions act = new Actions(driver);
		Thread.sleep(2000);
		act.sendKeys(Keys.ARROW_DOWN,Keys.ENTER).build().perform();
		Thread.sleep(2000);
		act.sendKeys(Keys.ENTER,Keys.ARROW_DOWN,Keys.ENTER).build().perform();
		Thread.sleep(2000);
		act.sendKeys(Keys.ENTER,Keys.ARROW_DOWN,Keys.ENTER).build().perform();
		String VerifyDropdown=wait.until(ExpectedConditions.visibilityOf(MonthValue)).getText();
		Assert.assertEquals(VerifyDropdown, "Oct-Dec 2025");
		
	}
}
