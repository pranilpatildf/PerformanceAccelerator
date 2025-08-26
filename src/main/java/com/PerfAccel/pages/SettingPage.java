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

import base.BaseClass;
import utils.Screenshot;

public class SettingPage extends BaseClass {
	WebDriver driver;
	@FindBy (xpath="//*[@title=\"Settings\"]")
	WebElement SettingButton;
	@FindBy (xpath="//*[@class=\"select-button placeholder\"]")
	WebElement DropdownButton;
	@FindBy (xpath="//td[contains(text(),'Dashboard')]//..//td[2]//nb-checkbox")
	WebElement DashboardFirstCheckbox;
	@FindBy (xpath="//td[contains(text(),'Dashboard')]//..//td[3]//nb-checkbox")
	WebElement DashboardSecondCheckbox;
	@FindBy (xpath="//td[contains(text(),'Dashboard')]//..//td[4]//nb-checkbox")
	WebElement DashboardThirdCheckbox;
	@FindBy (xpath="//button[normalize-space(.)='Save']")
	WebElement SaveButton;
	@FindBy (xpath="//*[@id=\"swal2-html-container\"]")
	WebElement SuccessMessage;
	@FindBy (xpath="//button[normalize-space(.)='OK']")
	WebElement OKButton;
	@FindBy (xpath="(//*[normalize-space(.)='Permissions'])[1]")
	WebElement Permission;
	
	
	
	public SettingPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void SelectDropdownRoles() throws InterruptedException
	{

		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(SettingButton)).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(DropdownButton)).click();
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(Permission));
		act.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(Permission));
		act.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		Screenshot.captureScreenshot(driver, "SettingDropdownRole");
		driver.navigate().refresh();
		
		
		
	}
	
	public void EnterSettingPage() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(SettingButton)).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(DropdownButton)).click();
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(3000);
		Screenshot.captureScreenshot(driver, "SettingPermissionBefore");
		wait.until(ExpectedConditions.elementToBeClickable(DashboardFirstCheckbox)).click();
		wait.until(ExpectedConditions.elementToBeClickable(DashboardSecondCheckbox)).click();
		wait.until(ExpectedConditions.elementToBeClickable(DashboardThirdCheckbox)).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(SaveButton)).click();
		wait.until(ExpectedConditions.elementToBeClickable(OKButton)).click();
		
		Screenshot.captureScreenshot(driver, "SettingPermissionAfter");
		
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(DashboardFirstCheckbox)).click();
		wait.until(ExpectedConditions.elementToBeClickable(DashboardSecondCheckbox)).click();
		wait.until(ExpectedConditions.elementToBeClickable(DashboardThirdCheckbox)).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(SaveButton)).click();
		wait.until(ExpectedConditions.visibilityOf(SuccessMessage));
		String SettingMessage=SuccessMessage.getText();
		Assert.assertEquals(SettingMessage,"Permissions Updated Successfully.");
		Screenshot.captureScreenshot(driver, "SettingPermissionSuccess");
		wait.until(ExpectedConditions.elementToBeClickable(OKButton)).click();
		
		
		
		}
	
	
		
	}

