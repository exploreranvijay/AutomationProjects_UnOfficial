package WebDriverScreenshots;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenCapture3 {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.Google.com");
		String txt1 = driver.findElement(By.linkText("Images")).getText();
		System.out.println(txt1);
		
		System.out.println("------------_-----------------_-------------------------------");

		List<WebElement>links=driver.findElements(By.tagName("a"));
		for(int i=0;i<links.size();i++) {
			if(!links.get(i).getText().isEmpty())
			System.out.println(links.get(i).getText());
		}
		
		System.out.println("---------------------_------------------------------_-------------------------");
		List<WebElement> txt2=driver.findElements(By.xpath("//div[@class='gb_Ed gb_H gb_Zf gb_Pf']//div//a"));
		for(int i=0;i<txt2.size();i++){
			System.out.println(txt2.get(i).getText());
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
