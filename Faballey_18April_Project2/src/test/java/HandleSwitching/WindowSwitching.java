package HandleSwitching;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowSwitching {
     
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		
		WebDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://www.icicibank.com/");
		String parentWindow=driver.getWindowHandle();
		System.out.println("My Parent Window Id ="+ parentWindow);
		String title1=driver.getTitle();
		System.out.println(title1);
		//driver.findElement(By.xpath("//p[text()='Avail Personal Loan, Now']")).click();
		WebDriverWait wait=new WebDriverWait(driver, 40);
		while(!wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@alt='PL'][@data-src='/content/dam/icicibank/india/managed-assets/images/homepage/pl-monsoon-home-renovation-non-papl-hp-d.webp']"))).isDisplayed())
		{
		driver.findElement(By.xpath("//div[@class='banner-slider hero-mobile hero-desktop i-home-banner slick-initialized slick-slider slick-dotted']/button[contains(text(),'Next')]")).click();
			
		}
		driver.findElement(By.xpath("//img[@alt='PL'][@data-src='/content/dam/icicibank/india/managed-assets/images/homepage/pl-monsoon-home-renovation-non-papl-hp-d.webp']")).click();
		Set<String> windows=driver.getWindowHandles();
		ArrayList<String>nwinds=new ArrayList<String>(windows);
		for(String i:nwinds) {
			System.out.println(i);
		}
		driver.switchTo().window(nwinds.get(1));
		//System.out.println(childWindow);
		String title2=driver.getTitle();
		System.out.println(title2);
		driver.close();
		driver.switchTo().window(nwinds.get(0));
		String title3=driver.getTitle();
		System.out.println(title3);
	    
		
		
		
		
}
}
