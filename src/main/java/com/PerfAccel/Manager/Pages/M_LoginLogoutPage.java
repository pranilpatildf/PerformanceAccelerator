package com.PerfAccel.Manager.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseClass;

public class M_LoginLogoutPage extends  BaseClass {
	WebDriver driver;
	@FindBy (xpath="//nb-user[@class='user-name size-medium shape-round context-menu-host']")
	WebElement UsernameButton;
	@FindBy (xpath="//*[@title=\"Logout\"]")
	WebElement LogoutButton;
	@FindBy (xpath="//*[@class=\"btn loginButton ng-star-inserted\"]")
	WebElement SignIButton;
	


	public M_LoginLogoutPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void M_LogoutPage()
	{
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(UsernameButton)).click();
		wait.until(ExpectedConditions.elementToBeClickable(LogoutButton)).click();
		wait.until(ExpectedConditions.visibilityOf(SignIButton));
		
		
	}
	
}
