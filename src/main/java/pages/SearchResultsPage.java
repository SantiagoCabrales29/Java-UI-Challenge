package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class SearchResultsPage {

	private WebDriver driver;
	private By popularProductNames = By.className("weight-bold");
	private By pricesTag = By.xpath("//div[text()='Price']");
	private By pricesWrapper = By.xpath("//div[@class='facet']//div[text()='Price']/parent::div");
	private By minField = By.id("minValue");
	private By maxField = By.id("maxValue");
	private By applyFilterButton = By.className("search-input-group__button");
	private By searchResults = By.cssSelector("li[class*='sortable-tile']");
	private By productPrice = By.cssSelector("div[class='grid-card__price'] span.price-display");
	private By sortField = By.id("sort");

	public SearchResultsPage(WebDriver driver) {
		this.driver = driver;
	}

	public List<String> getPopularProductNames(){
		List<WebElement> popularProductsList = driver.findElements(popularProductNames);
		//return popularProductsList.stream().map(WebElement::getText).collect(Collectors.toList()); Another way
		return popularProductsList.stream().map(e -> e.getText()).collect(Collectors.toList());
	}

	public void addPriceFilter(int min, int max){
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("facet__heading"))));
		//Scroll the page, we could comment those lines
		String script = "arguments[0].scrollIntoView();";
		((JavascriptExecutor)driver).executeScript(script,driver.findElement(pricesTag));
		WebElement prices = driver.findElement(pricesWrapper);
		prices.findElement(minField).sendKeys(String.valueOf(min));
		prices.findElement(maxField).sendKeys(String.valueOf(max));
		prices.findElement(applyFilterButton).click();
	}

	public List<String> getProductPrices(){
		try {
			WebDriverWait wait = new WebDriverWait(driver,5);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div[class='search-overview__count'] h2"))));
			//wait.until(ExpectedConditions.visibilityOf(driver.findElements(By.className("search-pill__term")).get(1)));
			//wait.until(ExpectedConditions.urlContains("min"));
			List<WebElement> popularProductsList = driver.findElements(searchResults);
			driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
			return popularProductsList.stream().map(e -> e.findElement(productPrice).getText()).collect(Collectors.toList());

		}catch (StaleElementReferenceException e){
		//WebElement element = driver.findElements(subCategories).get(0);
		//element.click();
		}
		return null;
	}

	public void addSortFilter(){
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver,5);
		//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("facet__heading"))));
		Select sort = new Select(driver.findElement(sortField));
		//sort.selectByIndex(3);
		sort.selectByVisibleText("Price High to Low");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("facet__heading"))));
	}
}
