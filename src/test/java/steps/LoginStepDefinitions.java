package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import page.LoginPage;
import util.BrowserFactory;

public class LoginStepDefinitions {
	static WebDriver driver;
	LoginPage loginPage;

	@Before
	public void beforeRun() {
		driver = BrowserFactory.startBrowser();
		loginPage=PageFactory.initElements(driver, LoginPage.class);  
	}

	@Given("^user is on the Techfios login page$")
	public void user_is_on_the_Techfios_login_page() {
		driver.get("http://www.techfios.com/billing/?ng=admin/");
	}

	@Given("^user is on the \"([^\"]*)\" login page$")
	public void user_is_on_the_login_page(String page) throws InterruptedException {
		if (page.equalsIgnoreCase("Techfios")) {
			driver.get("http://www.techfios.com/billing/?ng=admin/");
		} else if (page.equalsIgnoreCase("GoogleSearch")) {
			driver.get("https://www.google.com");
		}
		Thread.sleep(3000);
	}

	@When("^user enters username \"([^\"]*)\"$")
	public void user_enters_username(String username) throws Throwable {
		loginPage.enterUserName(username);
		Thread.sleep(2000);
	}

	@When("^user enters password \"([^\"]*)\"$")
	public void user_enters_password(String password) throws Throwable {
		loginPage.enterPassword(password);
		Thread.sleep(2000);
	}

	@When("^user clicks singin button$")
	public void user_clicks_singin_button() throws Throwable {
		loginPage.clickSigninButton();
		Thread.sleep(2000);
	}

	@Then("^user will land on the Dashboard page$")
	public void user_will_land_on_the_Dashboard_page() throws Throwable {
		String expectedTitle = "Dashboard- iBilling";
		String actualTitle = loginPage.getPageTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
		loginPage.takeScreenshotAtEndOfTest(driver);
	}

	@After
	public static void tearDown() {
		driver.close();
		driver.quit();
	}
}



