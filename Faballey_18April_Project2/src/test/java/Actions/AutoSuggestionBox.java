package Actions;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestionBox {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.Google.com/");
		driver.findElement(By.name("q")).sendKeys("Hadoop Tutorial");
		String val=driver.findElement(By.name("q")).getAttribute("value");
		List<WebElement> list = driver.findElements(By.xpath("//ul[@class='G43f7e']/li"));
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getText().equalsIgnoreCase(val)) {
				list.get(i).click();
				return;
			}
		}
		
		
		
		
		
		
		
	}

}
