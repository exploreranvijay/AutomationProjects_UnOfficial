package BrowserLaunchers;

import java.io.File; 
import java.io.FileInputStream;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import HtmlReportings.ExtentManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public static WebDriver driver;
	public static String projectPath=System.getProperty("user.dir");
	public static FileInputStream fis;
	public static Properties p;
	public static Properties mainProp;
	public static Properties childProp;
	public static Properties orProp;
	public static ExtentReports rep;
	public static ExtentTest test;
	public static String filePath;
	
	static {
		Date dt=new Date();
		filePath=dt.toString().replace(':', '_').replace(' ', '_');	
		}
	
	public static void init() throws Exception {
		
		fis=new FileInputStream(projectPath+"/src/test/resources/environment.properties");
		mainProp=new Properties();
		mainProp.load(fis);
		String e=mainProp.getProperty("env");
		System.out.println("Environment Name= "+e);
		
		fis=new FileInputStream(projectPath+"/src/test/resources/"+e+".properties");
		childProp=new Properties();
		childProp.load(fis);
		String url=childProp.getProperty("amazonurl");
		System.out.println("Environment URL= "+url);
		
		fis=new FileInputStream(projectPath+"/src/test/resources/data.properties");
	    p=new Properties();
		p.load(fis);
		
		fis=new FileInputStream(projectPath+"/src/test/resources/or.properties");
		orProp=new Properties();
		orProp.load(fis);
		
		fis=new FileInputStream(projectPath+"/src/test/resources/log4jconfig.properties");
		PropertyConfigurator.configure(fis);
		
		rep=ExtentManager.getInstance();
		
	 }
	
	public static void launch(String browser) {
		
		if(browser.equals("chrome")) {//Only For TestNG Parameter Concept
		//if(p.getProperty(browserKey).equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions option=new ChromeOptions();
			//option.addArguments("user-data-dirC:\\Users\\Ranvijay\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 1");
			option.addArguments("--disable-notifications");
			option.addArguments("--start-maximized");
			driver=new ChromeDriver(option);
	}
		else if(browser.equals("firefox")) {
		//else if(p.getProperty(browserKey).equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
	}
	public static void navigateUrl(String urlKey) {
		                                                         
		    driver.navigate().to(childProp.getProperty(urlKey));
	}
	
	public static void clickElement(String locatorKey) {
		//driver.findElement(By.xpath(orProp.getProperty(locatorKey))).click();//Static Way
		getElement(locatorKey).click();
	}

	public static void typeText(String locatorKey, String text) {
		//driver.findElement(By.name(orProp.getProperty(locatorKey))).sendKeys(text);//Static Way
		getElement(locatorKey).sendKeys(text);
	}

	public static void selectOption(String locatorKey, String option) {
		//driver.findElement(By.id(orProp.getProperty(locatorKey))).sendKeys(option);//Static Way
		getElement(locatorKey).sendKeys(option);
	}
	public static WebElement getElement(String locatorKey) {
		
		WebElement element=null;
		//Check For Element Presence 
		if(!isElementPresent(locatorKey))
		    //Report Failure
			System.out.println("Element is Not Present: "+locatorKey);
		
		    element=driver.findElement(getLocator(locatorKey));  
		/*
		 * if(locatorKey.endsWith("_id")) {
		 * element=driver.findElement(By.id(orProp.getProperty(locatorKey))); } else
		 * if(locatorKey.endsWith("_name")) {
		 * element=driver.findElement(By.name(orProp.getProperty(locatorKey))); } else
		 * if(locatorKey.endsWith("_className")) {
		 * element=driver.findElement(By.className(orProp.getProperty(locatorKey))); }
		 * else if(locatorKey.endsWith("_xpath")) {
		 * element=driver.findElement(By.xpath(orProp.getProperty(locatorKey)));
		 * 
		 * } else if(locatorKey.endsWith("_css")) {
		 * element=driver.findElement(By.cssSelector(orProp.getProperty(locatorKey)));
		 * 
		 * } else if(locatorKey.endsWith("_linkText")) {
		 * element=driver.findElement(By.linkText(orProp.getProperty(locatorKey))); }
		 * else if(locatorKey.endsWith("_partialLinkText")) {
		 * element=driver.findElement(By.partialLinkText(orProp.getProperty(locatorKey)));
		 *  }
		 */
		return element;
		
	}	
	public static boolean isElementPresent(String locatorKey) {
		
		System.out.println("Checking For Element Presence: "+locatorKey);
		
		WebDriverWait wait=new WebDriverWait(driver,30);//Explicit Wait
		
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(getLocator(locatorKey)));
			
			/*
			 * if(locatorKey.endsWith("_id")) {
			 * wait.until(ExpectedConditions.presenceOfElementLocated(By.id(orProp.
			 * getProperty(locatorKey)))); }else if(locatorKey.endsWith("_name")) {
			 * wait.until(ExpectedConditions.presenceOfElementLocated(By.name(orProp.
			 * getProperty(locatorKey)))); }else if(locatorKey.endsWith("_className")) {
			 * wait.until(ExpectedConditions.presenceOfElementLocated(By.className(orProp.
			 * getProperty(locatorKey)))); }else if(locatorKey.endsWith("_xpath")) {
			 * wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(orProp.
			 * getProperty(locatorKey)))); }else if(locatorKey.endsWith("_css")) {
			 * wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(orProp.
			 * getProperty(locatorKey)))); }else if(locatorKey.endsWith("_linkText")) {
			 * wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(orProp.
			 * getProperty(locatorKey)))); }else if(locatorKey.endsWith("_partialLinkText"))
			 * { wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(
			 * orProp.getProperty(locatorKey)))); }
			 */
		} 
		catch (Exception e)
		{
			return false;
		}
		 return true;
	}
	public  static By getLocator(String locatorKey) {
		By by=null;
		if(locatorKey.endsWith("_id")) {
			by=By.id(orProp.getProperty(locatorKey));
		}else if(locatorKey.endsWith("_name")) {
			by=By.name(orProp.getProperty(locatorKey));
	}else if(locatorKey.endsWith("_className")) {
		by=By.className(orProp.getProperty(locatorKey));
	}else if(locatorKey.endsWith("_xpath")) {
		by=By.xpath(orProp.getProperty(locatorKey));
	}else if(locatorKey.endsWith("_cssSelector")) {
		by=By.cssSelector(orProp.getProperty(locatorKey));
	}else if(locatorKey.endsWith("_linkText")) {
		by=By.linkText(orProp.getProperty(locatorKey));
	}else if(locatorKey.endsWith("_partialLinkText")) {
		by=By.partialLinkText(orProp.getProperty(locatorKey));
	}
		return by;
	}
//*********************Highlight the Web Element**********************
	public static void highlight(WebElement element) {
		JavascriptExecutor jsExecutor=(JavascriptExecutor)driver;
		jsExecutor.executeScript("arguments[0].setAttribute('style','background: green; border: 2px solid red;');",element);
	}
	
	
//**************************Verification**********************************************
	public static boolean isLinkEqual(String expectedLink) {
		String actualLink=driver.findElement(By.linkText("Customer Service")).getText();
		if(actualLink.equals(expectedLink)) 
			return true;
			else
			return false;
		
	}
//*************************Reporting**************************************************
	
	    public static void logInfo(String logInformation) {
	    	test.log(Status.INFO,logInformation);
	    }
	
		public static void reportSuccess(String successMessage) {
			test.log(Status.PASS, successMessage);
		}
		public static void reportFailure(String failureMessage) throws Exception {
			test.log(Status.FAIL, failureMessage);
			highlight(driver.findElement(By.linkText("Customer Service")));
			takesScreenshot();
		}

		public static void takesScreenshot() throws Exception {
			
			Date dt=new Date();
			String dateFormat=dt.toString().replace(':', '_').replace(' ', '_')+".png";
			File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(srcFile, new File(projectPath+"//FailureScreenshots//"+dateFormat));
			logInfo("Screenshot--->" +test.addScreenCaptureFromPath(projectPath+"//FailureScreenshots//"+dateFormat));
			
			
		}
		
}		
		
	
