package BrowserLaunchers;

import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//import io.github.bonigarcia.wdm.WebDriverManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserLaunch {

	public static void main(String[] args) {
		
		WebDriver driver;//Polymorphism Concept
		
		//System.setProperty("webdriver.chrome.driver","E:\\Working\\chromedriver.exe");	
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.google.com");
		
        System.setProperty("webdriver.gecko.driver","E:\\Working\\geckodriver.exe");	
	    //WebDriverManager.firefoxdriver().setup();
		//System Environment Variable Approach
	    driver=new FirefoxDriver();
		driver.get("https://www.facebook.com");

	}

}
