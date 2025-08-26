package com.PerfAccel.pages;


import java.util.List;

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

import base.BaseClass;
import utils.RandomString;

public class SkillsPage extends BaseClass{
	
    WebDriver driver;
    @FindBy (xpath="//*[@title=\"Skills\"]")
    WebElement SkillsTab;
    @FindBy (xpath="//input[@placeholder='--Search--']")
    WebElement SkillInputBox;
    @FindBy (xpath=" //button[@type='button']//i[@class='fa fa-search']")
    WebElement SearchButton;
    @FindBy (xpath="(//div[@class=\"ng-star-inserted\"])[2]//span")
    WebElement SkillText;
    @FindBy (xpath="//b[normalize-space()='CLEAR']")
    WebElement ClearButton;
    @FindBy (xpath="//div[2]//select[1]")
    WebElement SkillsDropdown;
    @FindBy (xpath="//div[3]//select[1]")
    WebElement SubskillsDropdown;    
    @FindBy (xpath="//div[@class='row employee-cards ng-star-inserted']//div[@class='col-md-2 ng-star-inserted']")
    List<WebElement> RecordsCount;
    
    @FindBy (xpath="//span[@class='tab-text ng-star-inserted'][normalize-space()='Skills']")
    WebElement AddskillTab;
    @FindBy (xpath="//b[normalize-space()='Categories']")
    WebElement CategoriesButton;
    @FindBy (xpath="//b[normalize-space()='Category']")
    WebElement AddCategoriesButton;
    @FindBy (xpath="//input[@placeholder='Category Name']")
    WebElement CategoryName;
    @FindBy (xpath="//textarea[@placeholder='Description']")
    WebElement CategoryDescription;
    @FindBy (xpath=" //button[normalize-space()='Save']")
    WebElement SaveButton;  
    @FindBy (xpath="//span[@class='title subtitle']")
    WebElement SuccessMessage;
    @FindBy (xpath="//span[@class='copyright textColor']")
    WebElement CategoryBottom;
    @FindBy (xpath="//button[normalize-space()='Yes, delete it!']")
    WebElement YesDeleteButton;
    
    @FindBy (xpath="//button[normalize-space()='OK']")
    WebElement OkButton;
    @FindBy (xpath="//div[@id='swal2-html-container']")
    WebElement DeletedMessage;
    
    
    @FindBy (xpath="//button[@class='add-btn status-success appearance-filled size-medium shape-rectangle icon-end nb-transition']")
    WebElement AddSkillButton;
    @FindBy (xpath="//button[@class='select-button placeholder']")
    WebElement SkillCategory;   
    @FindBy (xpath="//*[contains(text(),' Tools & Testing ')]")
    WebElement SkillCategoryOption;
    @FindBy (xpath="//input[@name='name']")
    WebElement SkillName;
    @FindBy (xpath="//textarea[@type='text']")
    WebElement SkillDescription;
    @FindBy (xpath="//button[normalize-space()='Save']")
    WebElement SkillSaveButton;
    
    @FindBy (xpath="//span[@class='title subtitle']")
    WebElement SkillCreatedMessage;
    @FindBy (xpath="//h5[normalize-space()='Tools & Testing']")
    WebElement ToolsAndTesting;
    
    

	
	public SkillsPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void SkillSearch()
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		wait.until(ExpectedConditions.elementToBeClickable(SkillsTab)).click();
		wait.until(ExpectedConditions.elementToBeClickable(SkillInputBox)).sendKeys(prop.getProperty("SkillName"));
		wait.until(ExpectedConditions.elementToBeClickable(SearchButton)).click();
		wait.until(ExpectedConditions.visibilityOf(SkillText));
		String text=SkillText.getText();
		js.executeScript("arguments[0].scrollIntoView();", ClearButton);
		Assert.assertTrue(text.contains("Python"));	
	}
	
	
	
	public void SkillDropdowns() throws InterruptedException
	{ 
	  WebDriverWait wait = new WebDriverWait(driver, 30);
	  JavascriptExecutor js = (JavascriptExecutor)driver;
	  wait.until(ExpectedConditions.elementToBeClickable(SkillsTab)).click();
	  wait.until(ExpectedConditions.elementToBeClickable(SkillsDropdown)).click();
	  Actions act = new Actions(driver);
	  act.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
	  wait.until(ExpectedConditions.elementToBeClickable(SubskillsDropdown)).click();
	  Thread.sleep(2000);
	  act.sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ENTER).build().perform();
	  Thread.sleep(2000);
	  js.executeScript("arguments[0].scrollIntoView();", ClearButton);
	  wait.until(ExpectedConditions.visibilityOfAllElements(RecordsCount));
	  Thread.sleep(2000); 
	  wait.until(ExpectedConditions.visibilityOf(SkillText));
	  String text=SkillText.getText();
	  js.executeScript("arguments[0].scrollIntoView();", ClearButton);
	  Assert.assertTrue(text.contains("JavaScript"));	
		
	}
	
	public void AddSkillCategory()
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
	    JavascriptExecutor js = (JavascriptExecutor)driver;
	    wait.until(ExpectedConditions.elementToBeClickable(SkillsTab)).click();
	    wait.until(ExpectedConditions.elementToBeClickable(AddskillTab)).click();
	    wait.until(ExpectedConditions.elementToBeClickable(CategoriesButton)).click();
	    wait.until(ExpectedConditions.elementToBeClickable(AddCategoriesButton)).click();
	    String Category= RandomString.generateWithPrefix("Testing Category-", 2);
	    wait.until(ExpectedConditions.elementToBeClickable(CategoryName)).sendKeys(Category);
	    wait.until(ExpectedConditions.elementToBeClickable(CategoryDescription)).sendKeys(prop.getProperty("CategoryDescription"));
	    wait.until(ExpectedConditions.elementToBeClickable(SaveButton)).click();
	    String Message= wait.until(ExpectedConditions.visibilityOf(SuccessMessage)).getText();
	    js.executeScript("arguments[0].scrollIntoView();", CategoryBottom);
	    Assert.assertEquals(Message, "Category Created Successfully");
	    
	}
	
	
	public void DeleteCategory() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
	//    JavascriptExecutor js = (JavascriptExecutor)driver;
	    wait.until(ExpectedConditions.elementToBeClickable(SkillsTab)).click();
	    wait.until(ExpectedConditions.elementToBeClickable(AddskillTab)).click();
	    wait.until(ExpectedConditions.elementToBeClickable(CategoriesButton)).click();
	    wait.until(ExpectedConditions.elementToBeClickable(AddCategoriesButton)).click();
	    String Category= RandomString.generateWithPrefix("Testing Category-", 2);
	    wait.until(ExpectedConditions.elementToBeClickable(CategoryName)).sendKeys(Category);
	    wait.until(ExpectedConditions.elementToBeClickable(CategoryDescription)).sendKeys(prop.getProperty("CategoryDescription"));
	    wait.until(ExpectedConditions.elementToBeClickable(SaveButton)).click();
	    
	 
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='"+Category+"']//..//..//td[4]//button[2]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(YesDeleteButton)).click();
		Thread.sleep(2000); 
		String DeletedString =wait.until(ExpectedConditions.visibilityOf(DeletedMessage)).getText();
		Assert.assertEquals(DeletedString, "Record has been deleted.");
		wait.until(ExpectedConditions.elementToBeClickable(OkButton)).click(); 
	}
	
	
	public void AddNewSkill() throws InterruptedException {
		
		 WebDriverWait wait = new WebDriverWait(driver, 30);
		 wait.until(ExpectedConditions.elementToBeClickable(SkillsTab)).click();
		 wait.until(ExpectedConditions.elementToBeClickable(AddskillTab)).click();		 
		 wait.until(ExpectedConditions.elementToBeClickable(AddSkillButton)).click();
		 wait.until(ExpectedConditions.elementToBeClickable(SkillCategory)).click();
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("arguments[0].scrollIntoView();", SkillCategoryOption);
		 SkillCategoryOption.click();
		 String SkillDesc=RandomString.generateWithPrefix("Robot Framework-",2);
		 WebElement Scroll01=wait.until(ExpectedConditions.elementToBeClickable(SkillName));
		 Scroll01.sendKeys(SkillDesc);
		 wait.until(ExpectedConditions.elementToBeClickable(SkillDescription)).sendKeys(prop.getProperty("SkillDescription01"));
		 wait.until(ExpectedConditions.elementToBeClickable(SkillSaveButton)).click();
		 wait.until(ExpectedConditions.visibilityOf(SkillCreatedMessage));
		 String SuccessMessage=SkillCreatedMessage.getText();
		 Assert.assertEquals(SuccessMessage, "Skill Created Successfully");
		 

	}
	
	
	
	
}
