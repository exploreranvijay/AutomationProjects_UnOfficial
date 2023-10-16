package BrowserLaunchers;

import org.apache.log4j.Logger;

public class GenerateReportUsingLog4j extends BaseTest {

	private static final Logger log = Logger.getLogger(GenerateReportUsingLog4j.class);

	public static void main(String[] args) throws Exception {

		init();
		log.info("Init the Properties Files...");
		launch("chromebrowser");
		log.info("Opening the Browser:- " + p.getProperty("chromebrowser"));
		navigateUrl("amazonurl");
		log.info("Navigating To Application :- " + childProp.getProperty("amazonurl"));
		selectOption("amazondropbox_id", "Books");
		log.info("Selecting Books by Using Locator :- " + orProp.getProperty("amazondropbox_id"));
		typeText("amazonsearchtextbox_name", "Harry Potter");
		log.info("Typing Text Harry Potter by Using Locator :- " + orProp.getProperty("amazonsearchtextbox_name"));
		clickElement("amazonsearchbutton_xpath");
		log.info("Click on Element by Using Locator :- " + orProp.getProperty("amazonsearchbutton_xpath"));



	}

}
