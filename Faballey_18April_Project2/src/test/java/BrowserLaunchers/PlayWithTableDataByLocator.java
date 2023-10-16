package BrowserLaunchers;

import org.openqa.selenium.By;

public class PlayWithTableDataByLocator extends BaseTest {

	public static void main(String[] args) throws Exception {
		init();
		launch("chromebrowser");
		navigateUrl("RediffUrl");
		
		//Static Xpath
		String price1=driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr[9]/td[4]")).getText();
		System.out.println(price1);
		//a[contains(text(),'RTS Power Corpor')]/parent::*/following-sibling::td[3]
		
		//Dynamic Xpath
		String price2=driver.findElement(By.xpath("//a[contains(text(),'RTS Power Corpor')]/parent::*/following-sibling::td[3]")).getText();
		System.out.println(price2);
		
		
		
		
		

	}

}
