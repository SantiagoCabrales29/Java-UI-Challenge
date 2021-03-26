package register;

import base.BaseTest;
import helpers.DataGenerator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {

	@Test
	public void testSuccessfulRegistration() {
		var registerPage = homePage.clickRegisterButton();
		registerPage.fillNameField(props.getProperty("name"));
		registerPage.fillLastNameField(props.getProperty("lastname"));
		registerPage.fillEmailField(props.getProperty("email"));
		registerPage.fillPasswordField(props.getProperty("password"));
		registerPage.clickRegisterButton();
		homePage.hoverOverProfileIcon();
		Assert.assertEquals(homePage.myAccount_getUsername(), props.getProperty("name") + " " + props.getProperty("lastname"));
	}

	@Test
	public void testUnsuccessfulRegistration() {
		var registerPage = homePage.clickRegisterButton();
		registerPage.fillNameField(DataGenerator.createRandomString());
		registerPage.fillLastNameField(DataGenerator.createRandomString());
		registerPage.fillEmailField(DataGenerator.createRandomString());
		registerPage.fillPasswordField(DataGenerator.createRandomString());
		registerPage.clickRegisterButton();
		Assert.assertTrue(homePage.getRegistrationButton().isDisplayed());
	}
}
