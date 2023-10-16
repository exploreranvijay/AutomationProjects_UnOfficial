package BrowserLaunchers;


 public class TestCase_AmazonTask extends BaseTest{

	public static void main(String[] args) throws Exception {
		
		init();
		launch("chromebrowser");
		navigateUrl("amazonurl");
		selectOption("amazondropbox_id","Books");
		typeText("amazonsearchtextbox_name","Harry Potter");
		clickElement("amazonsearchbutton_xpath");
		
	}

	

}
