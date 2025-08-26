package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporterNG {

	static ExtentReports extent;
	
	public static ExtentReports extentReportGenerator()
	{
		String path = System.getProperty("user.dir")+ "\\Reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Performance Accelerator");
		reporter.config().setDocumentTitle("Regression Test Cases");
		reporter.config().setTheme(Theme.DARK);
		 extent = new ExtentReports();
		// final attachment of report this need to return here
		extent.attachReporter(reporter);
		extent.setSystemInfo("Organization","Datafortune");
		extent.setSystemInfo("Project","Performance Accelerator");
		return extent;
	}
}