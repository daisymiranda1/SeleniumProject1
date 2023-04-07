package testclasses;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.ElementsPage;

public class ElementsPageTest extends BaseClass {


	ElementsPage page1=new ElementsPage();

	@Test(priority = 1)
	public void Fullname() throws InterruptedException {

		page1.Form();

	}

	/*
	 * @Test(priority = 2) public void CountrySelectionTestfrench() throws
	 * InterruptedException {
	 * 
	 * CountryPage.countrySelection(prop.getProperty("Country2"),
	 * prop.getProperty("Language2"));
	 * Assert.assertEquals(CountryPage.patientPage(), false); }
	 */
}
