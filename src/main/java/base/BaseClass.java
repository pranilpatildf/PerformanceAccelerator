package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.PerfAccel.Manager.Pages.M_KRAReleasePage;
import com.PerfAccel.Manager.Pages.M_LoginLogoutPage;
import com.PerfAccel.Manager.Pages.M_LoginPage;
import com.PerfAccel.Manager.Pages.M_SelfEvaluationPage;
import com.PerfAccel.Manager.Pages.M_SkillApprovalPage;
import com.PerfAccel.SManager.Pages.KRAReleaseAndEvaluate;
import com.PerfAccel.SManager.Pages.SM_KRAReleasePage;
import com.PerfAccel.SManager.Pages.SM_KRAsApprovalPage;
import com.PerfAccel.SManager.Pages.SM_LoginLogoutPage;
import com.PerfAccel.SManager.Pages.SM_LoginPage;
import com.PerfAccel.SManager.Pages.SM_MyTeamPage;
import com.PerfAccel.SManager.Pages.SM_SelfEvaluationPage;
import com.PerfAccel.SManager.Pages.SM_SkillApprovalPage;
import com.PerfAccel.pages.AssignNewRolePage;
import com.PerfAccel.pages.KRAPage;
import com.PerfAccel.pages.KRATemplatePage;
import com.PerfAccel.pages.LoginLogoutPage;
import com.PerfAccel.pages.LoginPage;
import com.PerfAccel.pages.ReportPage;
import com.PerfAccel.pages.RolesPage;
import com.PerfAccel.pages.SettingPage;
import com.PerfAccel.pages.SkillsPage;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.Listeners;
import com.aventstack.extentreports.ExtentTest;
import utils.Screenshot;

public class BaseClass {

    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    public static Properties prop;
    public static String currentDirectory = System.getProperty("user.dir");

    // POM objects (use getDriver() when initializing)
    protected LoginPage loginpage;
    protected RolesPage rolespage;
    protected AssignNewRolePage assignnewrolepage;
    protected SettingPage settingpage;
    protected KRAPage krapage;
    protected KRATemplatePage kratemplatepage;
    protected SkillsPage skillspage;
    protected ReportPage reportpage;
    protected  LoginLogoutPage logout;
   
    
   // Manager access objects
    protected M_SelfEvaluationPage m_selfevaluationpage;
    protected M_LoginPage m_loginpage;
    protected  M_LoginLogoutPage m_loginlogoutpage;
    protected M_KRAReleasePage m_krarelease;
    protected M_SkillApprovalPage m_skillaprrovalpage;
    
    //Senior manager access objects 
    protected SM_LoginPage sm_loginpage;
    protected  SM_KRAReleasePage sm_krareleasepage;
    protected  SM_LoginLogoutPage sm_loginlogout;
    protected  SM_SelfEvaluationPage sm_selfevaluationpage;
    protected SM_SkillApprovalPage sm_skillapprovalpage;
    protected SM_KRAsApprovalPage sm_kraapprovalpage;
    protected SM_MyTeamPage sm_myteampage;
    protected  KRAReleaseAndEvaluate krareleaseandevaluate;
    
    
    
    //Driver setup

    public static void setDriver(WebDriver driver) {
        driverThreadLocal.set(driver);
    }

    public static WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    public static void quitDriver() {
        WebDriver driver = driverThreadLocal.get();
        if (driver != null) {
            driver.quit();
            driverThreadLocal.remove();
        }
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp(ITestResult result, ITestContext context) throws IOException {
    	
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
      //  options.addArguments("--headless=new"); // Headless mode
        WebDriver driver = new ChromeDriver(options);
        setDriver(driver);

        result.setAttribute("driver", driver);
        context.setAttribute("driver", driver);

        // Link the ExtentTest instance to the test result
        ExtentTest test = Listeners.getExtentTest();
        result.setAttribute("extentTest", test);

        driver.manage().window().maximize();
        driver.get("https://dfperformance.azurewebsites.net/");

        // Load config
        prop = new Properties();
        try {
            FileInputStream ip = new FileInputStream(currentDirectory + "/data/config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Initialize POM objects
        loginpage = new LoginPage(driver);
        rolespage = new RolesPage(driver);
        assignnewrolepage = new AssignNewRolePage(driver);
        settingpage = new SettingPage(driver);
        krapage = new KRAPage(driver);
        kratemplatepage = new KRATemplatePage(driver);
         skillspage  = new SkillsPage(driver);
         reportpage = new ReportPage(driver);
          logout = new LoginLogoutPage(driver);
         
         //Below Objects for Managerial access.
         m_loginpage = new M_LoginPage(driver);
         m_loginlogoutpage = new M_LoginLogoutPage(driver);
         m_selfevaluationpage= new M_SelfEvaluationPage(driver);
         m_krarelease = new M_KRAReleasePage(driver);
         m_skillaprrovalpage = new M_SkillApprovalPage(driver);
         
         
         //Below objects for senior manager role
         sm_loginpage= new SM_LoginPage(driver);
          sm_krareleasepage = new SM_KRAReleasePage(driver);
           sm_loginlogout = new SM_LoginLogoutPage (driver);
          sm_selfevaluationpage = new SM_SelfEvaluationPage(driver);
         sm_skillapprovalpage= new SM_SkillApprovalPage (driver);
         sm_kraapprovalpage = new SM_KRAsApprovalPage (driver);
         sm_myteampage = new SM_MyTeamPage (driver);
         krareleaseandevaluate = new KRAReleaseAndEvaluate(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        WebDriver driver = getDriver();

        if (driver != null) {
            // Take screenshot before quitting driver
            String testName = result.getMethod().getMethodName();
            String path = Screenshot.captureScreenshot(driver, testName);
            Object extentTestAttr = result.getAttribute("extentTest");

            if (extentTestAttr instanceof ExtentTest test) {
                test.addScreenCaptureFromPath(path, "📸 Screenshot");
            } else {
                System.out.println("WARNING: ExtentTest not found in result attributes.");
            }
        }

        // Quit driver
        quitDriver();
    }
}
