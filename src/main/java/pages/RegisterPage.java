package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {
	private final WebDriver driver;
	private By nameField = By.id("user_first_name");
	private By lastNameField = By.id("user_last_name");
	private By emailField = By.id("user_email");
	private By passwordField = By.id("user_password");
	private By registerField = By.cssSelector("input[name='commit']");

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
	}

	public void fillNameField(String text){
		driver.findElement(nameField).sendKeys(text);
	}

	public void fillLastNameField(String text){
		driver.findElement(lastNameField).sendKeys(text);
	}

	public void fillEmailField(String text){
		driver.findElement(emailField).sendKeys(text);
	}

	public void fillPasswordField(String text){
		driver.findElement(passwordField).sendKeys(text);
	}

	public void clickRegisterButton(){
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(registerField)));
		driver.findElement(registerField).click();
	}
}
