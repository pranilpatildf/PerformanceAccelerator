package com.PerfAccel.pages;


import org.openqa.selenium.By;
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
import utils.RandomString;
import utils.Screenshot;


public class RolesPage extends BaseClass{
	WebDriver driver;
	@FindBy (xpath="//*[@title=\"Roles\"]")
	WebElement RoleTab;
	@FindBy (xpath="//button[normalize-space(.)='Role']")
	WebElement RoleButton;
	@FindBy (xpath="//input[@placeholder=\"Role Name\"]")
	WebElement RoleName;
	@FindBy (xpath="//*[@placeholder=\"Description\"]")
	WebElement RoleDecription;
	@FindBy (xpath="//button[normalize-space(.)='Save']")
	WebElement SaveButton;
	@FindBy (xpath="//button[normalize-space(.)='Yes, delete it!']")
	WebElement DeleteRoleButton;
	@FindBy (xpath="//button[normalize-space(.)='OK']")
	WebElement OkButton;
	
	

	
	public RolesPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void AddNewRole() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Below steps includes to add the new role.
		wait.until(ExpectedConditions.visibilityOf(RoleTab));
		RoleTab.click();
		wait.until(ExpectedConditions.elementToBeClickable(RoleButton));
		RoleButton.click();
		String Actual = RandomString.generateWithPrefix("Role-", 4);
		wait.until(ExpectedConditions.elementToBeClickable(RoleName));
		RoleName.sendKeys(Actual);
		wait.until(ExpectedConditions.elementToBeClickable(RoleDecription));		
		RoleDecription.sendKeys(prop.getProperty("Description"));
		wait.until(ExpectedConditions.elementToBeClickable(SaveButton));
		SaveButton.click();
		wait.until(ExpectedConditions.elementToBeClickable(RoleButton));		
		Thread.sleep(3000);	
		String PageText=driver.findElement(By.tagName("body")).getText();
		Assert.assertTrue(PageText.contains(Actual),Actual);
		Screenshot.captureScreenshot(driver, "AddedRoleAtLastRow");
		
	
		//Below steps includes to edit the existing role and description.
		WebElement EditRoleButton=driver.findElement(By.xpath("//*[contains(text(),'"+Actual+"')]/../../td[4]/button[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(EditRoleButton));
		EditRoleButton.click();
		wait.until(ExpectedConditions.visibilityOf(RoleDecription));
		RoleName.click();
		Actions act = new Actions(driver);
		act.sendKeys(Keys.BACK_SPACE).build().perform();
		String EditedRoleName = RoleName.getText();
		wait.until(ExpectedConditions.elementToBeClickable(RoleDecription)).click();
		act.sendKeys(Keys.BACK_SPACE).build().perform();	
		wait.until(ExpectedConditions.elementToBeClickable(SaveButton)).click();
		wait.until(ExpectedConditions.visibilityOf(EditRoleButton));
		String PageText02=driver.findElement(By.tagName("body")).getText();
		Assert.assertTrue(PageText02.contains(EditedRoleName),EditedRoleName);
		Screenshot.captureScreenshot(driver, "EditeRole");
		
		//Below steps includes delete the added role
		WebElement DeleteButton = driver.findElement(By.xpath("//*[contains(text(),'"+Actual+"')]/../../td[4]/button[2]"));
		wait.until(ExpectedConditions.visibilityOf(DeleteButton)).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(DeleteRoleButton)).click();	
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(OkButton)).click();
		Thread.sleep(2000);
		Screenshot.captureScreenshot(driver, "DeletedRole");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	

}
