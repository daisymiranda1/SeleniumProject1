package factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.log4j.Logger;

public class DriverFactory {
	public static WebDriver driver;
	public Properties prop;

	private static final Logger LOG = Logger.getLogger(DriverFactory.class);

	public WebDriver initDriver(Properties prop) {
		String browserName = prop.getProperty("browser").toLowerCase();
		LOG.info("browser name is : " + browserName);
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.http.factory", "jdk-http-client");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browserName.equals("safari")) {
			driver = new SafariDriver();
		} else {
			LOG.error("Please pass the right browser name : " + browserName);
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		return driver;
	}

	public Properties initProp() throws IOException {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream("config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		}
		return prop;
	}

}
