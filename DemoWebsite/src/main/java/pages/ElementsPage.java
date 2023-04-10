package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BaseClass;
import factory.DriverFactory;
import utilityclasses.ElementUtil;
import utilityclasses.JavascriptUtilities;

public class ElementsPage extends BaseClass {

	private ElementUtil ele = new ElementUtil();
	private JavascriptUtilities js = new JavascriptUtilities();

	private static final Logger LOG = Logger.getLogger(ElementsPage.class);

	private By Elements = By.xpath("//*[@id='app']/div/div/div[2]/div/div[1]");
	private By TextBox = By.xpath("//span[@class='text']");
	private By fullnameele = By.xpath("//input[@id='userName']");
	private By email=By.xpath("//*[@id='userEmail']");

	public void Menu() throws InterruptedException {
		ele.waitForElementVisible(Elements, 3);
		/*
		 * Boolean val=ele.EleIsDisplayed(Elements);
		 * System.out.println("testingvlue"+val);
		 */
		js.scrollIntoElementByJavaScript(Elements, driver);
		ele.click(Elements);
		LOG.info("element button is clicked");
		Thread.sleep(1000);
		ele.click(TextBox);
		LOG.info("texbox is clicked");
	}

	public boolean Verifyfullname() throws InterruptedException  {

		
		ele.click(fullnameele);
	
		LOG.info("moved cursorto firstname field");

		/*
		 * WebElement fullname1 = ele.getElement(fullname); JavascriptExecutor js =
		 * (JavascriptExecutor) driver; js.executeScript("arguments[0].value='Rachel';",
		 * fullname1);
		 */

		ele.sendkeys(fullnameele, prop.getProperty("fullname"));
		Thread.sleep(1000);
		LOG.info("entered full name");
		return true;

	}

	/*
	 * public Boolean patientPage() { Boolean result=false; Boolean
	 * patient=ele.EleIsDisplayed(Patientlink); Boolean
	 * professional=ele.EleIsDisplayed(Professionallink);
	 * LOG.info("verified if patient and professional tabs are displayed");
	 * if(patient==true&& professional==true) { result=true; } return result; }
	 */

	public boolean VerifyEmailIDtextbox() throws InterruptedException {
		ele.click(email);
		LOG.info("moved cursor to email field");
		ele.sendkeys(email, prop.getProperty("email"));
		Thread.sleep(1000);
		LOG.info("entered email");
		return true;
		
		//return email.isDisplayed();
	}
}
