package pages;

import org.openqa.selenium.WebDriver;
import base.BasePage;

public class LoginPage extends BasePage{
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public void initialPage() {
		navegateTo("http://automationpractice.com/index.php");
	}
	
	public void doLogin(String email, String password) {
		if(getElementValueByLink("Sign in").equals("Sign in")){
			clickLink("Sign in");
			waitForId("email");
			sendKeysById("email", email);
			sendKeysById("passwd", password);
			clickButton("SubmitLogin");
		}
	}
	
	public void doLogout() {
		try {
			clickByClass("logout");
		} catch (Exception e) {
			
		}
		
	}
	
}
