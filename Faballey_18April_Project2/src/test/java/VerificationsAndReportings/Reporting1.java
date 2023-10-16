package VerificationsAndReportings;

//import com.aventstack.extentreports.Status;

import BrowserLaunchers.BaseTest;

public class Reporting1 extends BaseTest {

	public static void main(String[] args) throws Exception {
		
		init();
		test=rep.createTest("Reporting1.class");
		//test.log(Status.INFO,"Init the Properties Files...");
		logInfo("Init the Properties Files...");
		
		launch("chromebrowser");
		//test.log(Status.INFO,"Opening the Browser:- " + p.getProperty("chromebrowser"));
		logInfo("Opening the Browser:- " + p.getProperty("chromebrowser"));
		
		navigateUrl("amazonurl");
		//test.log(Status.INFO,"Navigating To Application :- " + childProp.getProperty("amazonurl"));
		logInfo("Navigating To Application :- " + childProp.getProperty("amazonurl"));
		
		String expectedLink="Customer Servi";
		if(!isLinkEqual(expectedLink)) 
			reportFailure("Both Link are not Equal");
	    else 
			reportSuccess("Both Link are Equal");
		
		rep.flush();
	}
		
		
		
		
		

	}




