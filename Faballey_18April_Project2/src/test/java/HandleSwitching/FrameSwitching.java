package HandleSwitching;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameSwitching {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://ui.vision/demo/webtest/frames/");
		
		//By WebELement
		//driver.switchTo().frame(driver.findElement(By.xpath("//frame[@src='frame_2.html']")));
		
		//By Name and Id
		driver.switchTo().frame(1);
		driver.findElement(By.name("mytext2")).sendKeys("Jai Shree Ram");
		driver.switchTo().defaultContent();
		driver.switchTo().frame(0);
		driver.findElement(By.name("mytext1")).sendKeys("Jai Hanuman");
		
		
		

	}

}
