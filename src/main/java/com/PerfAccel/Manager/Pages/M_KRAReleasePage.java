package com.PerfAccel.Manager.Pages;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class M_KRAReleasePage {
	WebDriver driver;
	@FindBy (xpath="//*[@title=\"KRA Release\"]")
	WebElement ReleaseKRATab;
	@FindBy (xpath="//span[normalize-space()='Select Designation']")
	WebElement DesignationDropdown;
	@FindBy (xpath="//button[normalize-space()='Next']")
	WebElement NextButton;
	@FindBy (xpath="//*[@id=\"nb-option-5\"]")
	WebElement SoftwareEngRole;
	
	
	@FindBy (xpath="//tbody/tr[1]/td[1]/input[1]")
	WebElement FirstUser;
	@FindBy (xpath="//button[normalize-space()='Add Special KRA']")
	WebElement AddKRAButton;
	@FindBy (xpath="//b[normalize-space()='Existing Special KRA']")
	WebElement ExistingKRATitle;
	@FindBy (xpath="(//*[@class=\"select-button placeholder\"])[1]")
	WebElement UserKRADropdown;
	
	@FindBy (xpath="//*[@class=\"col-md-12 multiple nb-transition ng-star-inserted\"]")
	WebElement UserName;
	
	
	
	
	public M_KRAReleasePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	   public void KRAFlowValidation() throws InterruptedException {
		   
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(ReleaseKRATab)).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(DesignationDropdown)).click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", SoftwareEngRole);
		//wait.until(ExpectedConditions.elementToBeClickable(SoftwareEngRole)).click();
		wait.until(ExpectedConditions.elementToBeClickable(NextButton)).click();
		wait.until(ExpectedConditions.elementToBeClickable(FirstUser)).click();
		wait.until(ExpectedConditions.elementToBeClickable(NextButton)).click();
		wait.until(ExpectedConditions.elementToBeClickable(AddKRAButton)).click();
		wait.until(ExpectedConditions.elementToBeClickable(UserKRADropdown)).click();
		wait.until(ExpectedConditions.visibilityOf(UserName));
		
		
		
	}
}
