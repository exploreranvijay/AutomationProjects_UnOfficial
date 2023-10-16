package HtmlReportings;

//import org.apache.log4j.Logger;

import com.aventstack.extentreports.Status;

import BrowserLaunchers.BaseTest;

public class GenerateExtentReport extends BaseTest {

	//private static final Logger log = Logger.getLogger(GenerateExtentReport.class);

	public static void main(String[] args) throws Exception {

		init();
		test=rep.createTest("GenerateExtentReport");
		test.log(Status.INFO,"Init the Properties Files...");
		launch("chromebrowser");
		test.log(Status.PASS,"Opening the Browser:- " + p.getProperty("chromebrowser"));
		navigateUrl("amazonurl");
		test.log(Status.FAIL,"Navigating To Application :- " + childProp.getProperty("amazonurl"));
		selectOption("amazondropbox_id", "Books");
		test.log(Status.INFO,"Selecting Books by Using Locator :- " + orProp.getProperty("amazondropbox_id"));
		typeText("amazonsearchtextbox_name", "Harry Potter");
		test.log(Status.INFO,"Typing Text Harry Potter by Using Locator :- " + orProp.getProperty("amazonsearchtextbox_name"));
		clickElement("amazonsearchbutton_xpath");
		test.log(Status.INFO,"Click on Element by Using Locator :- " + orProp.getProperty("amazonsearchbutton_xpath"));

		rep.flush();


	}

}
