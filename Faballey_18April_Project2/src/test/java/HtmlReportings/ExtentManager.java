package HtmlReportings;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import BrowserLaunchers.BaseTest;

public class ExtentManager extends BaseTest {

	public static  ExtentHtmlReporter htmlReport;
	public static  ExtentReports report;
	
	public static ExtentReports getInstance() {
		
		if(htmlReport==null)
		{
			htmlReport=new ExtentHtmlReporter(projectPath+"\\HtmlReports\\reports.html");
			htmlReport.config().setDocumentTitle("Automation Reports");
			htmlReport.config().setReportName("Functional Report");
			htmlReport.config().setTheme(Theme.STANDARD);
			
			report=new ExtentReports();
			report.attachReporter(htmlReport);
			report.setSystemInfo("OS", "Window10");
			report.setSystemInfo("Tester Name", "Ranvijay Singh");
			report.setSystemInfo("Browser", "Chrome");
		}
		
		
		return report;
		
		
	}
	
	
	
	
	
	
	
}
