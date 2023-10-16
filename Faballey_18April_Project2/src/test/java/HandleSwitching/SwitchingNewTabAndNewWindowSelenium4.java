package HandleSwitching;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwitchingNewTabAndNewWindowSelenium4 {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
//		ChromeOptions option=new ChromeOptions();
//		option.addArguments("--disable-notifications");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
		
		//For New TAB
//		driver.switchTo().newWindow(WindowType.TAB);
//		driver.get("https://www.amazon.in/");
		//For New Window
		//driver.switchTo().newWindow(WindowType.WINDOW);
		//driver.get("https://www.amazon.in/");
		
		

	}

}
