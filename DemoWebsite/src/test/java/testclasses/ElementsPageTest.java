package testclasses;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.ElementsPage;
import org.apache.log4j.Logger;
public class ElementsPageTest extends BaseClass {

	ElementsPage page1 = new ElementsPage();
	
	private static final Logger LOG = Logger.getLogger(ElementsPageTest.class);
	@Test(priority = 1)
	public void VerifyfullnameTest() throws InterruptedException {
		page1.Menu();
		Assert.assertTrue(page1.Verifyfullname());
		LOG.info("full name textbox verified");
	}

	@Test(priority = 2)
	public void VerifyEmailTest() throws InterruptedException {
		page1.Menu();
		Assert.assertTrue(page1.VerifyEmailIDtextbox());
		// Assert.assertEquals(CountryPage.patientPage(), false);
	}

}
