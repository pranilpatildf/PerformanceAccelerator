package com.PerfAccel.SManager.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SM_KRAsApprovalPage {
	WebDriver driver;
	@FindBy (xpath="//*[@title=\"KRAs Approval\"]")
	WebElement KRAApprovalTab;
	@FindBy (xpath="//*[@class=\"select-button\"]")
	WebElement DropdownButton;
	
	
	
	public SM_KRAsApprovalPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void KRAQuarterDropdown() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(KRAApprovalTab)).click();
		wait.until(ExpectedConditions.elementToBeClickable(DropdownButton)).click();
		
		Actions act = new Actions(driver);
		Thread.sleep(2000);
		act.sendKeys(Keys.ARROW_UP,Keys.ENTER).build().perform();
		Thread.sleep(2000);
		act.sendKeys(Keys.ENTER,Keys.ARROW_UP,Keys.ENTER).build().perform();
		Thread.sleep(2000);		
		String VerifyDropdown=wait.until(ExpectedConditions.visibilityOf(DropdownButton)).getText();
		Assert.assertEquals(VerifyDropdown, "Jan-Mar   2025");
		
	}
	

}
