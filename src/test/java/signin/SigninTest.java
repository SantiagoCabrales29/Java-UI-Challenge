package signin;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SigninTest extends BaseTest {

	@Test
	public void testSuccessfulLogin(){
		var signInPage = homePage.clickSignInButton();
		signInPage.fillEmailField(props.getProperty("email"));
		signInPage.fillPasswordField(props.getProperty("password"));
		signInPage.clickSignInButton();
		homePage.hoverOverProfileIcon();
		Assert.assertEquals(homePage.myAccount_getUsername(), props.getProperty("name") + " " + props.getProperty("lastname"));
	}

	@Test
	public void testUnsuccessfulLogin(){
		var signInPage = homePage.clickSignInButton();
		signInPage.fillEmailField("randommail@mail.com");
		signInPage.fillPasswordField("password");
		var loginPage = signInPage.clickSignInWithWrongCredentials();
		String text = loginPage.getLoginMessage();
		Assert.assertTrue(text.contains("incorrect"));
	}

}
