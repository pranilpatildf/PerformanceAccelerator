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


public class KRAPage {
	WebDriver driver;
	
	@FindBy (xpath="//*[@alt=\"Datafortune\"]")
	WebElement Default;
	@FindBy (xpath="//*[@title=\"KRA\"]")
	WebElement KRATab;
	@FindBy (xpath="(//*[@class=\"select-button placeholder\"])[1]")
	WebElement AllFunctionsDropdown;
	@FindBy (xpath="(//*[@type=\"button\"])[2]")
	WebElement AllBusinessUnitDropdown;
	@FindBy (xpath="//button[normalize-space(.)='KRA']")
	WebElement AddKRAButton;
	@FindBy (xpath="//*[@formcontrolname=\"kraName\"]")
	WebElement KRAName;
	@FindBy (xpath="//*[@formcontrolname=\"weightage\"]")
	WebElement KRAWeightage;
	@FindBy (xpath="//div/nb-select[1]/button")
	WebElement FunctionDropdown;
	@FindBy (xpath="//div/nb-select[2]/button")
	WebElement BusinessUnitDropdown;
	@FindBy (xpath="//*[@role=\"textbox\"]")
	WebElement KRADescription;
	@FindBy (xpath="//*[@status=\"success\"]")
	WebElement SaveButton;
	@FindBy (xpath="//tbody/tr[1]/td[2]")
	WebElement WaitingKRA;
	@FindBy (xpath="//button[normalize-space(.)='Yes, delete it!']")
	WebElement DeleteKRAButton;
	@FindBy (xpath="//button[normalize-space(.)='OK']")
	WebElement OKButton;
	@FindBy (xpath="//*[@id=\"swal2-title\"]")
	WebElement OKButtonText;
	


	
	public KRAPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void ValidateKRADropdowns() throws InterruptedException
	{
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(KRATab)).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(AllFunctionsDropdown)).click();
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(AllBusinessUnitDropdown));
		wait.until(ExpectedConditions.elementToBeClickable(AllBusinessUnitDropdown)).click();
		Thread.sleep(2000);
		act.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		String Actual ="Delivery";
		String PageText=driver.findElement(By.tagName("body")).getText();
		Assert.assertTrue(PageText.contains(Actual),Actual);
		Screenshot.captureScreenshot(driver, "KRADropdownValidation");
					
				
	}
	
	public void AddNewKRA() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(Default)).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(KRATab)).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(AddKRAButton)).click();
		String KRANAme = utils.RandomString.generateWithPrefix("001Testing-KRA-", 4);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(KRAName)).sendKeys(KRANAme);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(KRAWeightage)).sendKeys("100");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(FunctionDropdown)).click();
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(BusinessUnitDropdown)).click();
		Thread.sleep(3000);
		act.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		String KRADescri = utils.RandomString.generateWithPrefix("Testing-KRA-", 4);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(KRADescription)).sendKeys(KRADescri);
		wait.until(ExpectedConditions.elementToBeClickable(SaveButton)).click();
		WebElement Message=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'KRA Created Successfully')]")));
		String CreatedMessage=Message.getText();
		Assert.assertEquals(CreatedMessage, "KRA Created Successfully");
		wait.until(ExpectedConditions.visibilityOf(WaitingKRA));
		WebElement Highlighted=driver.findElement(By.xpath("(//*[contains(text(),'"+KRANAme+"')]//..//..//..)[1]"));	
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.border='3px solid red'", Highlighted);
		Screenshot.captureScreenshot(driver, "CreatedNewKRA");
		
	
	}
	
	public void AddAndEditKRA() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(Default)).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(KRATab)).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(AddKRAButton)).click();
		String KRANAme = utils.RandomString.generateWithPrefix("001Testing-KRA-", 4);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(KRAName)).sendKeys(KRANAme);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(KRAWeightage)).sendKeys("100");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(FunctionDropdown)).click();
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(BusinessUnitDropdown)).click();
		Thread.sleep(3000);
		act.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		String KRADescri = utils.RandomString.generateWithPrefix("Testing-KRA-", 4);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(KRADescription)).sendKeys(KRADescri);
		wait.until(ExpectedConditions.elementToBeClickable(SaveButton)).click();
		wait.until(ExpectedConditions.visibilityOf(WaitingKRA));
		Thread.sleep(1000);	
		WebElement EditButton=driver.findElement(By.xpath("//*[contains(text(),'"+KRANAme+"')]//..//..//..//button[1]"));	
		wait.until(ExpectedConditions.elementToBeClickable(EditButton)).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(KRAName)).click();
		Thread.sleep(2000);
		act.sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).build().perform();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(KRADescription)).click();
		act.sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).build().perform();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(SaveButton)).click();
		wait.until(ExpectedConditions.visibilityOf(WaitingKRA));
		WebElement UpdateMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'KRA Updated Successfully')]")));
		String KRAUpdate=UpdateMessage.getText();
		Assert.assertEquals(KRAUpdate, "KRA Updated Successfully");
		
		
	}
	
	public void DeleteKRA() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(Default)).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(KRATab)).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(AddKRAButton)).click();
		String KRANAme = utils.RandomString.generateWithPrefix("001Testing-KRA-", 4);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(KRAName)).sendKeys(KRANAme);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(KRAWeightage)).sendKeys("100");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(FunctionDropdown)).click();
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(BusinessUnitDropdown)).click();
		Thread.sleep(3000);
		act.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		String KRADescri = utils.RandomString.generateWithPrefix("Testing-KRA-", 4);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(KRADescription)).sendKeys(KRADescri);
		wait.until(ExpectedConditions.elementToBeClickable(SaveButton)).click();
		wait.until(ExpectedConditions.visibilityOf(WaitingKRA));
		
		Thread.sleep(2000);
		WebElement DeleteButton=driver.findElement(By.xpath("//*[contains(text(),'"+KRANAme+"')]//..//..//..//button[2]"));
		wait.until(ExpectedConditions.elementToBeClickable(DeleteButton)).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(DeleteKRAButton)).click();
		Thread.sleep(2000);		
		wait.until(ExpectedConditions.visibilityOf(OKButtonText));
		Screenshot.captureScreenshot(driver, "KRADelected");
		String Ok = OKButtonText.getText();
		Assert.assertEquals(Ok, "Deleted!");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(OKButton)).click();
		
		
		
		
	}
	
}
