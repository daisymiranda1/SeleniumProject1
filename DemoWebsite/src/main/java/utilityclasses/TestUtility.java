package utilityclasses;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import base.BaseClass;

public class TestUtility {
	//Extent Report - 1.
		public static String getSystemDate() 
		{
			DateFormat dateFormat = new SimpleDateFormat("_ddMMyyyy_HHmmss");
			Date date = new Date();
			return dateFormat.format(date);
		}
		public static String getscreenshot(WebDriver driver, String screenshotName) throws IOException 
		{
			String dateName = new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);

			String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName + ".png";
			File finalDestination = new File(destination);
			FileUtils.copyFile(source, finalDestination);
			return destination;
		}
		//Set Date For Log4J.
		public static void setDateForLog4j()
		{
			SimpleDateFormat dateFormat = new SimpleDateFormat("_ddMMyyyy_HHmmss");
			System.setProperty("current_date", dateFormat.format(new Date()));
			PropertyConfigurator.configure("./src/main/resources/log4j.properties");
		}


}
