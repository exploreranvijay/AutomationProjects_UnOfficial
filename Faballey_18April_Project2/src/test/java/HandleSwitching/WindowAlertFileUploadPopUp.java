package HandleSwitching;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowAlertFileUploadPopUp {

	public static void main(String[] args) {
		
WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/upload/");
		driver.findElement(By.id("uploadfile_0")).sendKeys("C://Users//Ranvijay//Downloads//Screenshot (1).png");
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("submitbutton")).click();
		System.out.println("Success");

	}

}
