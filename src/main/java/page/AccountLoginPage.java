package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountLoginPage extends AbstractPage {
	
	@FindBy(linkText = "Forgotten Password")
	private WebElement linkForgottenPassword;

	public AccountLoginPage(WebDriver driver) {
		super(driver);
	}
	
	public void clickLinkForgottenPassword() {
		linkForgottenPassword.click();
	}

}
