package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomePage {
	private WebDriver driver;
	private By registerButton = By.cssSelector("a[class='site-header__nav__link']");
	private By signInButton = By.cssSelector("a[class='site-header__nav__link site-header__nav__link--login']");
	private By profileIcon = By.xpath(".//li[contains(.,'Menú')][1]");
	private By userName = By.cssSelector("div[class='bdb-1 bd--offwhite padding-1 pt-0 weight-bold']");
	private By searchBar = By.className("site-search__controls__input");
	private By mainCategories = By.className("category-flyout-header__link");

	public HomePage(WebDriver driver){
		this.driver = driver;
	}

	public RegisterPage clickRegisterButton(){
		driver.findElement(registerButton).click();
		return new RegisterPage(driver);
	}

	public SignInPopUp clickSignInButton(){
		driver.findElement(signInButton).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return new SignInPopUp(driver);
	}

	public void hoverOverProfileIcon(){
		WebElement profile = driver.findElement(profileIcon);
		Actions actions = new Actions(driver);
		actions.moveToElement(profile).perform();
	}

	public String myAccount_getUsername(){
		WebElement name = driver.findElement(userName);
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOf(name));
		return driver.findElement(userName).getText();
	}

	public WebElement getRegistrationButton(){
		return driver.findElement(registerButton);
	}

	public SearchResultsPage searchItem(String text){
		driver.findElement(searchBar).sendKeys(text + Keys.ENTER);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.urlContains("marketplace"));
		return new SearchResultsPage(driver);
	}

	public CategoryPopup clickCategory(String categoryName){
		List<WebElement> categoriesList = driver.findElements(mainCategories);
		for(WebElement category: categoriesList){
			if (category.getText().equals(categoryName)){
				category.click();
			}
		}
		return new CategoryPopup(driver);
	}

}
