package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CategoryPopup {
	private final WebDriver driver;
	private By subCategories = By.cssSelector(".category-flyout__subhead > a");

	public CategoryPopup(WebDriver driver) {
		this.driver = driver;
	}

	public SubCategoryPage clickSubCategory(String text){
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElements(subCategories).get(0)));
		List<WebElement> categories = driver.findElements(subCategories);
		for(WebElement category: categories){
				//category.click();
				try {
					if (category.getText().equals(text)) {
						//WebElement element = driver.findElements(subCategories).get(0);
						//element.click();
						category.click();
					}
				}catch (StaleElementReferenceException e){
					//WebElement element = driver.findElements(subCategories).get(0);
					//element.click();
				}
			}
		return new SubCategoryPage(driver);
	}
}
