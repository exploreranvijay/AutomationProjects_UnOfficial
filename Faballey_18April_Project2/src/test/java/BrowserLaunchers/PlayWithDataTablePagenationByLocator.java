package BrowserLaunchers;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PlayWithDataTablePagenationByLocator extends BaseTest {

	public static void main(String[] args) throws Exception {
		
		init();
		launch("chromebrowser");
		navigateUrl("Pagination");
		int pageMaxSize=driver.findElements(By.cssSelector("div#example_paginate>span>a")).size();
		System.out.println("Total Number Of Pages: " +pageMaxSize);
		for(int i=1;i<=pageMaxSize;i++)
		{
			String pageSelector="div#example_paginate>span>a:nth-child("+i+")";
			driver.findElement(By.cssSelector(pageSelector)).click();
			List<WebElement> elementNames=driver.findElements(By.cssSelector("table#example>tbody>tr>td:nth-child(1)"));
			for(WebElement elementname:elementNames)
			{
				System.out.println(elementname.getText());
			}
			Thread.sleep(2000);
		}
		
		
		
		
		
		
		

	}

}
