package WebDriverScreenshots;

import java.io.File;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenCapture2 {

	public static void main(String[] args) throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.Google.com");
		List<WebElement> links = driver.findElements(By.linkText("Rajnikanth"));
		if(links.size()==0) {
			File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(srcFile, new File("E:\\Automation Reosuces By DS\\Selenium\\Rajnikant.png"));
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
