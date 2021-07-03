package page;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using ="//input[@id='username']") WebElement USERNAME_FIELD;
	@FindBy(how = How.XPATH, using ="//input[@id='password']") WebElement PASSWORD_FIELD;
	@FindBy(how = How.XPATH, using ="//button[@name='login']") WebElement SIGNIN_FIELD;
	
	//Interactive Methods
	
	public void enterUserName(String userName) {
		USERNAME_FIELD.sendKeys(userName);
	}
	public void enterPassword(String password) {
		PASSWORD_FIELD.sendKeys(password);	
	}
	public void enterCredentials(String userName, String password) {
		USERNAME_FIELD.sendKeys(userName);
		PASSWORD_FIELD.sendKeys(password);
		 }
	public void clickSigninButton() {
		SIGNIN_FIELD.click();
	}
	public String getPageTitle() {
		  return driver.getTitle();
		 }
	

	public void takeScreenshotAtEndOfTest(WebDriver driver) throws IOException {
		  TakesScreenshot ts = ((TakesScreenshot)driver);
		  File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		  SimpleDateFormat formatter = new SimpleDateFormat("MMddyy_HHmmss");
		  Date date = new Date();
		  String label = formatter.format(date);
		  String currentDirectory = System.getProperty("user.dir");
		  FileUtils.copyFile(sourceFile, new File(currentDirectory + "/screenshot/" + label +".png"));

		 }

}
