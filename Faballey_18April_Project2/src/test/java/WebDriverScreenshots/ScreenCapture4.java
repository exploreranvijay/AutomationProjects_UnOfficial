package WebDriverScreenshots;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenCapture4 {

	public static void main(String[] args) throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.Google.com");
		List<WebElement> links=driver.findElements(By.xpath("//div[@id='SIvCob']/a"));
		for(int i=0;i<links.size();i++) {
			if(!links.get(i).getText().isEmpty()) {
				Date d=new Date();
				String dt=d.toString().replace(':', '_').replace(' ', '_');
				String linkName=links.get(i).getText();
				links.get(i).click();
				File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileHandler.copy(srcFile, new File("E:\\Automation Reosuces By DS\\Selenium\\"+linkName+"_"+dt+".png"));
				links=driver.findElements(By.xpath("//div[@id='SIvCob']/a"));
			}
				
		}

	}

}
