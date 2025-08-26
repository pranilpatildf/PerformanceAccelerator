package com.PerfAccel.SManager.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseClass;

public class SM_MyTeamPage extends BaseClass {
	WebDriver driver;
	@FindBy (xpath="//span[@aria-label='toggle Rakteem']")
	WebElement DropdownButton01;
	@FindBy (xpath="//span[@aria-label='toggle Manager']")
	WebElement DropdownButton02;
	@FindBy (xpath="//span[normalize-space()='Pranil Patil']")
	WebElement User;
	@FindBy (xpath="//span[normalize-space()='Jan-Mar   2025']")
	WebElement Quarter;
	

	
	public SM_MyTeamPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void ValidateQuarterDropdown() {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(DropdownButton01)).click();
		wait.until(ExpectedConditions.elementToBeClickable(DropdownButton02)).click();
		wait.until(ExpectedConditions.elementToBeClickable(User)).click();
		wait.until(ExpectedConditions.elementToBeClickable(Quarter)).click();
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ARROW_DOWN,Keys.ENTER).build().perform();
		act.sendKeys(Keys.ENTER,Keys.ARROW_DOWN,Keys.ENTER).build().perform();
	}
}
