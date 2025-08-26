package com.PerfAccel.Manager.Pages;

import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import base.BaseClass;



public class M_LoginPage extends BaseClass {
    WebDriver driver;
    
	@FindBy (xpath="//*[@class=\"btn loginButton\"]")
	WebElement SignInButton01;
	@FindBy (xpath="//*[@name=\"loginfmt\"]")
	WebElement EnterEmail;
	@FindBy (xpath="//*[@id=\"idSIButton9\"]")
	WebElement NextButton;
	@FindBy (xpath="//*[@id=\"i0118\"]")
	WebElement EnterPassword;
	@FindBy (xpath="//*[@id=\"idSIButton9\"]")
	WebElement SignInButton02;
	@FindBy (xpath="//*[@type=\"submit\"]")
	WebElement YesButton;
	@FindBy (xpath="//*[@class=\"pageTtitle\"]")
	WebElement PageTitle;
	
	
	public M_LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
		
	public void M_LoginIntoFrontPage() throws InterruptedException
	
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(SignInButton01));
		
		SignInButton01.click();
		String mainWindow = driver.getWindowHandle();
		
		wait.until(driver -> driver.getWindowHandles().size() > 1);

		
		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles) {
		    if (!handle.equals(mainWindow)) {
		        driver.switchTo().window(handle);
		        System.out.println("Switched to window: " + driver.getTitle());
		        break;
		    }
		}
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(EnterEmail));
		EnterEmail.sendKeys(prop.getProperty("UserEmail02"));
		wait.until(ExpectedConditions.elementToBeClickable(NextButton));
		NextButton.click();
		Thread.sleep(3000);	
		wait.until(ExpectedConditions.elementToBeClickable(EnterPassword));	
		EnterPassword.sendKeys(prop.getProperty("UserPassword02"));
		wait.until(ExpectedConditions.elementToBeClickable(SignInButton02));
		SignInButton02.click();
		wait.until(ExpectedConditions.elementToBeClickable(YesButton));
		YesButton.click();
		driver.switchTo().window(mainWindow);
		wait.until(ExpectedConditions.visibilityOf(PageTitle));
		String Title = driver.getTitle();
		//System.out.println(Title);
		Assert.assertEquals(Title, "Datafortune Velocity");
		//Screenshot.captureScreenshot(driver, "LoginIntoFrontPage");
		
	}
}
