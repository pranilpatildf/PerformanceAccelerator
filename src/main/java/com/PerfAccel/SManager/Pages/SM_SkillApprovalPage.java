package com.PerfAccel.SManager.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SM_SkillApprovalPage {
	WebDriver driver;
	@FindBy (xpath="//nb-icon[@class='menu-icon ng-tns-c49-5 ng-star-inserted']")
	WebElement SkillApprovalTab;
	@FindBy (xpath="(//*[@type=\"checkbox\"])[1]")
	WebElement FirstSkillCheckbox;
	@FindBy (xpath="(//*[@type=\"checkbox\"])[2]")
	WebElement SecondSkillCheckbox;
	@FindBy (xpath="//button[normalize-space()='Approve']")
	WebElement ApproveButton;
	

	public SM_SkillApprovalPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void SM_SkillApprovalTabValidation() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(SkillApprovalTab)).click();
		wait.until(ExpectedConditions.elementToBeClickable(FirstSkillCheckbox)).click();
		wait.until(ExpectedConditions.elementToBeClickable(SecondSkillCheckbox)).click();
		Thread.sleep(2000);	
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", ApproveButton);
		Thread.sleep(2000);
		String approve=ApproveButton.getText();
		Assert.assertEquals(approve,"APPROVE");
	}
}
