package utilityclasses;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseClass;


public class ElementUtil extends BaseClass {
	private Select select;


	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public void sendkeys(By locator, String value) {
		WebElement ele = getElement(locator);
		ele.clear();
		ele.sendKeys(value);
	}

	public void click(By locator) {
		getElement(locator).click();
	}

	public String getText(By locator) {
		return getElement(locator).getText();
	}

	public void selectDropDownByValue(By locator, String value) {
		select = new Select(getElement(locator));
		select.selectByValue(value);
	}

	public void dropdownWithoutSelect(By locator, By list, String value) {
		getElement(locator).click();
		List<WebElement> allOptions = getElements(list);
		for (int i = 0; i <= allOptions.size() - 1; i++) {
			if (allOptions.get(i).getText().equals(value)) {
				allOptions.get(i).click();
			}
		}
	}

	public boolean EleIsDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}

	// timeouts
	public WebElement waitForElementVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

}
