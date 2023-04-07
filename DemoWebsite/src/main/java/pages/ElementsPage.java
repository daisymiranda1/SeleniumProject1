package pages;


import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import base.BaseClass;
import factory.DriverFactory;
import utilityclasses.ElementUtil;
import utilityclasses.JavascriptUtilities;

public class ElementsPage extends BaseClass {

	private ElementUtil ele= new ElementUtil();
	private JavascriptUtilities js=new JavascriptUtilities();

	private static final Logger LOG = Logger.getLogger(ElementsPage.class);
	
	private By Elements = By.xpath("//*[@id='app']/div/div/div[2]/div/div[1]");
	private By TextBox=By.xpath("//span[@class='text']");
	private By fullname = By.xpath("//input[@id='userName']");
	
	

	public void Form() throws InterruptedException {
		ele.waitForElementVisible(Elements,10);
		/*
		 * Boolean val=ele.EleIsDisplayed(Elements);
		 * System.out.println("testingvlue"+val);
		 */
		js.scrollIntoElementByJavaScript(Elements,driver);
		ele.click(Elements);
		LOG.info("element button is clicked");
		Thread.sleep(1000);
		ele.click(TextBox);
		LOG.info("texbox is clicked");
		ele.click(fullname);
		LOG.info("moved cursor to firstname field");
		/*
		 * JavascriptExecutor js=(JavascriptExecutor)driver;
		 * js.executeScript("arguments[0].value='Rachel';", fullname);
		 */
		ele.sendkeys(fullname, "Rachel");
		Thread.sleep(1000);
		LOG.info("entered full name");
	}
	/*
	 * public Boolean patientPage() { Boolean result=false; Boolean
	 * patient=ele.EleIsDisplayed(Patientlink); Boolean
	 * professional=ele.EleIsDisplayed(Professionallink);
	 * LOG.info("verified if patient and professional tabs are displayed");
	 * if(patient==true&& professional==true) { result=true; } return result; }
	 */
}
