package utilityclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavascriptUtilities {
	public static JavascriptExecutor javaScript;
	private ElementUtil ele= new ElementUtil();
	
	//scrollinto view works only for chrome, not for ie and firefox
	public  void scrollIntoElementByJavaScript(By locator, WebDriver driver) 
	{
		WebElement webele=ele.getElement(locator);
		javaScript = ((JavascriptExecutor) driver);
		javaScript.executeScript("arguments[0].scrollIntoView(true);", webele);
	}
	public  void scrollbypixeljavascript(By locator, WebDriver driver) 
	{
		WebElement webele=ele.getElement(locator);
		//get position
		int x = webele.getLocation().getX();
		int y = webele.getLocation().getY();
		//scroll to x y 
		javaScript = ((JavascriptExecutor) driver);
		javaScript.executeScript("window.scrollBy("+x,y+")");
	}
	public  void sendkeysjavascript(By locator, WebDriver driver) 
	{
		WebElement webele=ele.getElement(locator);
		
		javaScript = ((JavascriptExecutor) driver);
	
	}

}
