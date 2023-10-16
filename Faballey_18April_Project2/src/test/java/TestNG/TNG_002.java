package TestNG;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import BrowserLaunchers.BaseTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;

public class TNG_002 extends BaseTest {
  
  @BeforeMethod
  @Parameters("browser")
  public void startUp(String bType) throws Exception {
	  init();
		test=rep.createTest("GenerateExtentReport");
		test.log(Status.INFO,"Init the Properties Files...");
		 
		launch(bType);
		test.log(Status.PASS,"Opening the Browser:- " + p.getProperty("chromebrowser"));
		
		navigateUrl("amazonurl");
		test.log(Status.INFO,"Navigating To Application :- " + childProp.getProperty("amazonurl"));
	  
  }
  @Test
  public void amazon() {
	    selectOption("amazondropbox_id", "Books");
		test.log(Status.INFO,"Selecting Books by Using Locator :- " + orProp.getProperty("amazondropbox_id"));
		
		typeText("amazonsearchtextbox_name", "Harry Potter");
		test.log(Status.INFO,"Typing Text Harry Potter by Using Locator :- " + orProp.getProperty("amazonsearchtextbox_name"));
		
		clickElement("amazonsearchbutton_xpath");
		test.log(Status.INFO,"Click on Element by Using Locator :- " + orProp.getProperty("amazonsearchbutton_xpath"));

  }

  @AfterMethod
  public void endProcess() {
	  rep.flush();
	  driver.quit();
  }

}
