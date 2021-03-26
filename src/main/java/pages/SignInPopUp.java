package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPopUp {
	private final WebDriver driver;
	private By email = By.id("user_session_login");
	private By password = By.id("user_session_password");
	private By signInButton = By.cssSelector("input[value='Log In']");

	public SignInPopUp(WebDriver driver) {
		this.driver = driver;
	}

	public void fillEmailField(String text) {
		driver.findElement(email).sendKeys(text);
	}

	public void fillPasswordField(String text) {
		driver.findElement(password).sendKeys(text);
	}

	public void clickSignInButton() {
		driver.findElement(signInButton).click();
	}

	public LoginPage clickSignInWithWrongCredentials() {
		driver.findElement(signInButton).click();
		return new LoginPage(driver);
	}
}
