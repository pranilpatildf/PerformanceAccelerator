package com.PerfAccel.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ReportPage {
	WebDriver driver;
	@FindBy (xpath="//*[@title=\"Report\"]")
	WebElement ReportTab;
	@FindBy (xpath="//select[@class='form-control ng-untouched ng-pristine ng-valid']")
	WebElement FunctionsDropdown;
	@FindBy (xpath="//select[@class='form-control subskill-select ng-untouched ng-pristine ng-valid']")
	WebElement RolesDropdown;
	@FindBy (xpath="//input[@class='form-control ng-pristine ng-valid ng-touched']")
	WebElement FromDateButton;
	@FindBy (xpath="//input[@class='form-control ng-untouched ng-pristine ng-valid']")
	WebElement ToDateButton;
	
	
	
	

	
	public ReportPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void FunctionAndRoleDropdown() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(ReportTab)).click();
		wait.until(ExpectedConditions.elementToBeClickable(FunctionsDropdown)).click();
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(RolesDropdown)).click();
		Thread.sleep(2000);
		act.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		String pageSource = driver.getPageSource();
		Assert.assertTrue(pageSource.contains("Delivery"));
		wait.until(ExpectedConditions.elementToBeClickable(FromDateButton)).click();
			
	}
	
	
	
}
