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
import utils.RandomString;
import utils.Screenshot;

public class KRATemplatePage {
	
	WebDriver driver;
	@FindBy (xpath="//*[@title=\"KRA Template\"]")
	WebElement KRATemplateTab;
	@FindBy (xpath="(//*[@type=\"button\"])[1]")
	WebElement AllFunctionsDropdown;
	@FindBy (xpath="(//*[@type=\"button\"])[2]")
	WebElement AllBusinessUnitDropdown;
	@FindBy (xpath="//*[@status=\"success\"]")
	WebElement CreateButton;
	@FindBy (xpath="//input[@placeholder='Template Name']")
	WebElement TemplateName;
	@FindBy (xpath="//textarea[@placeholder='Description']")
	WebElement TemplateDescription;
	@FindBy (xpath="//span[normalize-space()='Select Function Name']")
	WebElement FunctionName;
	@FindBy (xpath="//span[normalize-space()='Select Business Unit']")
	WebElement BusinessUnit;
	@FindBy (xpath="//button[normalize-space()='Save']")
	WebElement SaveTemplate;
	@FindBy (xpath="//button[normalize-space()='Yes, delete it!']")
	WebElement ConfirmDelete;
	@FindBy (xpath="//div[@id='swal2-html-container']")
	WebElement DeleteText;
	@FindBy (xpath="//button[normalize-space()='OK']")
	WebElement OKButton;
	
	@FindBy (xpath="//nb-card[@class='assigned-designations']//button[normalize-space()='Add']")
	WebElement DesignatedRolesButton;
	@FindBy (xpath="//nb-card[@class='assigned-KRAs']//button[normalize-space()='Add']")
	WebElement AssignedKRAsButton;
	@FindBy (xpath="//button[@class='select-button placeholder']")
	WebElement DesignatedRolesDropdown;
	
	
	@FindBy (xpath="//button[normalize-space()='Save']")
	WebElement RoleSaveButton;
	@FindBy (xpath="//button[@class='submitBtn status-success appearance-filled size-medium shape-rectangle nb-transition']")
	WebElement KRAsSaveButton;
	@FindBy (xpath="//button[normalize-space()='Save']")
	WebElement MainSaveButton;
	
	
	
	
	public KRATemplatePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void ValidateKRATemplatesDropdown() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(KRATemplateTab)).click();
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
		Screenshot.captureScreenshot(driver, "KRATemplateDropdownValidation");
			
	}
	
	public void CreateTemplate() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(KRATemplateTab)).click();
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
		wait.until(ExpectedConditions.elementToBeClickable(CreateButton)).click();
		String TemplateNameString=RandomString.generateWithPrefix("Template_", 4);
		String TemplateDescriptionString=RandomString.generateWithPrefix("Template_", 4);
		wait.until(ExpectedConditions.elementToBeClickable(TemplateName)).sendKeys(TemplateNameString);
		wait.until(ExpectedConditions.elementToBeClickable(TemplateDescription)).sendKeys(TemplateDescriptionString);	
		wait.until(ExpectedConditions.elementToBeClickable(FunctionName)).click();
		Thread.sleep(2000);
		act.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(BusinessUnit)).click();
		Thread.sleep(2000);
		act.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(SaveTemplate)).click();
		Thread.sleep(2000);
		WebElement CreatedMessage=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Template Created Successfully')]")));
		String SuccessMessageText=CreatedMessage.getText();
		
		Assert.assertEquals(SuccessMessageText, "Template Created Successfully");
				
	}
	
	public void EditKRATemplate() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(KRATemplateTab)).click();
		Actions act = new Actions(driver);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(CreateButton)).click();
		String TemplateNameString=RandomString.generateWithPrefix("Template_", 4);
		String TemplateDescriptionString=RandomString.generateWithPrefix("Template_", 4);
		wait.until(ExpectedConditions.elementToBeClickable(TemplateName)).sendKeys(TemplateNameString);
		wait.until(ExpectedConditions.elementToBeClickable(TemplateDescription)).sendKeys(TemplateDescriptionString);	
		wait.until(ExpectedConditions.elementToBeClickable(FunctionName)).click();
		Thread.sleep(2000);
		act.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(BusinessUnit)).click();
		Thread.sleep(2000);
		act.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(SaveTemplate)).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Template Created Successfully')]")));
		Thread.sleep(2000);
		WebElement Edit=driver.findElement(By.xpath("//*[contains(text(),'"+TemplateNameString + "')]//..//td[4]//button[2]"));
		wait.until(ExpectedConditions.elementToBeClickable(Edit)).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(TemplateName)).click();
		Thread.sleep(2000);
		act.sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).build().perform();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(TemplateDescription)).click();
		Thread.sleep(2000);
		act.sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(SaveTemplate)).click();
		Thread.sleep(2000);
		WebElement CreatedMessage=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Template Updated Successfully')]")));
		String SuccessMessageText=CreatedMessage.getText();
		Assert.assertEquals(SuccessMessageText, "Template Updated Successfully");
		
		
	}
	
	public void DeleteKRATemplate() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(KRATemplateTab)).click();
		Thread.sleep(2000);
		Actions act= new Actions(driver);
		wait.until(ExpectedConditions.elementToBeClickable(CreateButton)).click();
		String TemplateNameString=RandomString.generateWithPrefix("Template_", 4);
		String TemplateDescriptionString=RandomString.generateWithPrefix("Template_", 4);
		wait.until(ExpectedConditions.elementToBeClickable(TemplateName)).sendKeys(TemplateNameString);
		wait.until(ExpectedConditions.elementToBeClickable(TemplateDescription)).sendKeys(TemplateDescriptionString);	
		wait.until(ExpectedConditions.elementToBeClickable(FunctionName)).click();
		Thread.sleep(2000);
		act.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(BusinessUnit)).click();
		Thread.sleep(2000);
		act.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(SaveTemplate)).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Template Created Successfully')]")));
		Thread.sleep(2000);
		WebElement Delete=driver.findElement(By.xpath("//*[contains(text(),'"+TemplateNameString +"')]//..//td[4]//button[3]"));
		wait.until(ExpectedConditions.elementToBeClickable(Delete)).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(ConfirmDelete)).click();
		wait.until(ExpectedConditions.visibilityOf(OKButton));
		String DeletedConfirmation=wait.until(ExpectedConditions.visibilityOf(DeleteText)).getText();
		Assert.assertEquals(DeletedConfirmation, "Record has been deleted.");
		wait.until(ExpectedConditions.elementToBeClickable(OKButton)).click();
		
	}
	
	public void ViewTemplate_And_AddRolesAndKRAs() throws InterruptedException
	
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(KRATemplateTab)).click();
		Thread.sleep(2000);
		Actions act= new Actions(driver);
		wait.until(ExpectedConditions.elementToBeClickable(CreateButton)).click();
		String TemplateNameString=RandomString.generateWithPrefix("Template_", 4);
		String TemplateDescriptionString=RandomString.generateWithPrefix("Template_", 4);
		wait.until(ExpectedConditions.elementToBeClickable(TemplateName)).sendKeys(TemplateNameString);
		wait.until(ExpectedConditions.elementToBeClickable(TemplateDescription)).sendKeys(TemplateDescriptionString);	
		wait.until(ExpectedConditions.elementToBeClickable(FunctionName)).click();
		Thread.sleep(2000);
		act.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(BusinessUnit)).click();
		Thread.sleep(2000);
		act.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(SaveTemplate)).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Template Created Successfully')]")));
		Thread.sleep(2000);
		WebElement View=driver.findElement(By.xpath("//*[contains(text(),'"+TemplateNameString +"')]//..//td[4]//button[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(View)).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(DesignatedRolesButton)).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(DesignatedRolesDropdown)).click();
		Thread.sleep(2000);
		act.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(RoleSaveButton)).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(AssignedKRAsButton)).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(DesignatedRolesDropdown)).click();
		Thread.sleep(2000);
		act.sendKeys(Keys.ENTER).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(KRAsSaveButton)).click();
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(MainSaveButton)).click();
		WebElement KRAPopup=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'KRAs Updated Successfully')]")));
		String KRAsAddedConfirmation=KRAPopup.getText();
		WebElement RolesPopup=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Designated Role Updated Successfully')]")));
		String RolesAddedConfirmation=RolesPopup.getText();
		Assert.assertEquals(KRAsAddedConfirmation, "KRAs Updated Successfully");
		Assert.assertEquals(RolesAddedConfirmation, "Designated Role Updated Successfully");
		
		
		
		
		
		
	}
	
	
}
