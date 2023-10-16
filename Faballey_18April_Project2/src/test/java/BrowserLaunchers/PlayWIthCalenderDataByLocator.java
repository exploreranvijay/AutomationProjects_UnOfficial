package BrowserLaunchers;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PlayWIthCalenderDataByLocator extends BaseTest {

	public static void main(String[] args) throws Exception {
		
		init();
		launch("chromebrowser");
		navigateUrl("GoIbiboUrl");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//span[contains(text(),'Departure')]")).click();
		                                      //(//div[@class='DayPicker-Caption']/div)[1]
		List<WebElement> months=driver.findElements(By.xpath("(//div[@class='DayPicker-Caption']/div)"));
		 int i=1;
		 while(!months.get(i).getText().contains("January 2024"))
			 {
			 if(i<3)
				 i++;
			 else
				 driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click(); 
			 i=1;
			}
		 
		}
		
		
		
		
		
		
		
		
	}


