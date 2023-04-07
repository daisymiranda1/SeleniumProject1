package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilityclasses.ElementUtil;

public class LoginPage {
	private ElementUtil ele;

	private static final Logger LOG = Logger.getLogger(LoginPage.class);

    //locators
	private By email = By.id("loginForm-email-input");
	private By pwd = By.id("loginForm-password-input");
	private By loginbutton = By.id("loginForm-submit-button");
	private By Header2FA=By.id("wizardCard-header-text");

	

	// Page actions
	public void LogIn(String username,String password) {
		ele.sendkeys(email, username);
		ele.sendkeys(pwd, password);
		ele.click(loginbutton);
		LOG.info("Clicked on Login button");
		
	}

}
