package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.HomePage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

	protected static Properties props;
	private WebDriver driver;
	protected HomePage homePage;

	@BeforeTest
	public void setup(){
		System.setProperty("webdriver.chrome.driver","resources/chromedriver");
		readProperties();
		driver= new ChromeDriver();
		goHome();
		homePage = new HomePage(driver);
	}

	@BeforeMethod
	public void goHome(){
		driver.get(props.getProperty("url"));
	}

//	@AfterClass
//	public void tearDown(){
//		driver.quit();
//	}
//	@BeforeTest
//	public void OpenDriverForEachTest(){
//		System.setProperty("webdriver.chrome.driver","resources/chromedriver");
//		readProperties();
//		driver= new ChromeDriver();
//		goHome();
//		homePage = new HomePage(driver);
//	}

	@AfterTest
	public void tearAfterEachTest(){
		driver.quit();
	}

	public void readProperties() {
		props = new Properties();
		try {
			props.load(new FileInputStream("application.properties"));
		} catch (IOException var2) {
			System.out.println("Hay un error leyendo el archivo de properties");
		}
	}

}
