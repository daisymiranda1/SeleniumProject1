package base;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import utilityclasses.TestUtility;

import org.apache.log4j.Logger;

import factory.DriverFactory;
import pages.ElementsPage;

public class BaseClass {
	DriverFactory df;
	public static Properties prop;
	public static WebDriver driver;
	public static ElementsPage elementPage;
	private static final Logger Log = Logger.getLogger(BaseClass.class);


	
	@BeforeTest
	public void setup() {
		try {
			df = new DriverFactory();
			prop = df.initProp();
			driver = df.initDriver(prop);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		TestUtility.setDateForLog4j();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
		Log.info("Browser terminated");
	}
}
