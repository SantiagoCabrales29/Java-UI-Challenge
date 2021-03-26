package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SubCategoryPage {
	private final WebDriver driver;
	private By title = By.tagName("h1");

	public SubCategoryPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getTitle(){
		return driver.findElement(title).getText();
	}
}
