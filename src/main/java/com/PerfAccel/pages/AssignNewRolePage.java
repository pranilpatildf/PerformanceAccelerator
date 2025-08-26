package com.PerfAccel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



import utils.Screenshot;

public class AssignNewRolePage {
      WebDriver driver;
      
    @FindBy (xpath="//*[@title=\"Roles\"]")
    WebElement RoleTab;
    @FindBy (xpath="//button[normalize-space(.)='Assign Role']")
  	WebElement AssignRoleButton;
    @FindBy (xpath="//*[contains(text(),'Pooja Joshi')]")
  	WebElement UserName01;
    @FindBy (xpath="(//*[contains(text(),'Pranil Patil')]//..)[1]")
  	WebElement UserName02;
    @FindBy (xpath="//*[contains(text(),'Pranil Patil')]//..//td[5]")
  	WebElement EditRoleButton;
    @FindBy (xpath="//*[@placeholder=\"Select Role\"]")
  	WebElement UserRoles;
    @FindBy (xpath="//button[normalize-space(.)='Update']")
  	WebElement UpdateButton;
    
  
    
	
	public AssignNewRolePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void AssignRole() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(RoleTab)).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(AssignRoleButton)).click();
		Thread.sleep(2000);		
		wait.until(ExpectedConditions.visibilityOf(UserName01));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", UserName01);
		Thread.sleep(2000);
			
		wait.until(ExpectedConditions.elementToBeClickable(EditRoleButton)).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(UserRoles)).click();
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(UpdateButton)).click();
		WebElement Update=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'User Updated Successfully')]")));
		String UpdatedMessage=Update.getText();		
		Assert.assertEquals(UpdatedMessage, "User Updated Successfully");
		
		
		Thread.sleep(5000);
		js.executeScript("arguments[0].style.border='3px solid red'", UserName02);	
		Screenshot.captureScreenshot(driver, "AssignedNewRole");
		
		
		wait.until(ExpectedConditions.elementToBeClickable(EditRoleButton)).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(UserRoles)).click();
		Thread.sleep(2000);
		act.sendKeys(Keys.ARROW_UP).sendKeys(Keys.ENTER).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(UpdateButton)).click();
		Thread.sleep(2000);
		Assert.assertEquals(UpdatedMessage, "User Updated Successfully");
		
		
		
		
	}
	
	
	
}



