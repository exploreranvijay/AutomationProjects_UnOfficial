package BrowserLaunchers;

public class TestCase_002 extends BaseTest {

	public static void main(String[] args) throws InterruptedException {
		
		launch("fire fox");
		navigateUrl("https://www.facebook.com");
		driver.manage().window().maximize();
		String title=driver.getTitle();
		System.out.println("Page Title= "+title);
		String pageUrl=driver.getCurrentUrl();
		System.out.println("Current Page Url= "+pageUrl);
		driver.manage().deleteAllCookies();
		driver.navigate().forward();
		driver.navigate().back();
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		driver.close();
	}

}
