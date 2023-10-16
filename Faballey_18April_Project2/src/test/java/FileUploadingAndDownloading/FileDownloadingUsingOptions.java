package FileUploadingAndDownloading;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileDownloadingUsingOptions {

	public static void main(String[] args) throws Exception {
		
		//String filetype="DOC, DOCX";	
		//For Chrome Browser
		WebDriverManager.chromedriver().setup();
		ChromeOptions option=new ChromeOptions();
		HashMap<String,Object> pref=new HashMap<String, Object>();
		pref.put("plugins.always_open_pdf_externally",true);
		option.setExperimentalOption("prefs", pref);
		
		WebDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://file-examples.com/");
		driver.findElement(By.xpath("//h3[text()='Documents']/following-sibling::a")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//td[text()='DOC, DOCX']/following-sibling::td[2]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[starts-with(text(),'Download sample')]")).click();
	}

}
