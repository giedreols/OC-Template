package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends AbstractPage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	// links
	@FindBy(partialLinkText = "Edit your account")
	private WebElement linkEditAccount;
	
	@FindBy(linkText = "My Account")
	private WebElement linkMyAccount;
	
	@FindBy(linkText = "Continue")
	private WebElement buttonContinue;

	// input
	@FindBy(id = "input-firstname")
	private WebElement inputFirstName;

	@FindBy(id = "input-lastname")
	private WebElement inputLastName;

	@FindBy(id = "input-email")
	private WebElement inputEmail;

	@FindBy(id = "input-telephone")
	private WebElement inputTelephone;
	
	public void clickLinkEditAccount() {
		linkEditAccount.click();
	}
	
	public void clickLinkMyAccount() {
		linkMyAccount.click();
	}
	
	public void clickButtonContinue() {
		buttonContinue.click();
	}

	public String getFirstName() {
		return inputFirstName.getAttribute("value");
	}

	public String getLastName() {
		return inputLastName.getAttribute("value");
	}

	public String getEmail() {
		return inputEmail.getAttribute("value");
	}

	public int getTelephonel() {
		return Integer.valueOf(inputTelephone.getAttribute("value"));
	}

}
