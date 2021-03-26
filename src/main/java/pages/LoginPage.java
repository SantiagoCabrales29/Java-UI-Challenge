package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private WebDriver driver;
	private By loginOperationResultMessage = By.cssSelector("div[class='alert-box alert-box--red scaling-mb-2 size-90']");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getLoginMessage(){
		return driver.findElement(loginOperationResultMessage).getText();
	}
}
