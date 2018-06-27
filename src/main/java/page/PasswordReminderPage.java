package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PasswordReminderPage extends AbstractPage {

	public PasswordReminderPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "input-email")
	private WebElement inputEmail;

	@FindBy(xpath = "//*[@value='Continue']")
	private WebElement buttonContinue;

	@FindBy(xpath = "//*[@class='alert alert-danger alert-dismissible']")
	private WebElement textAlert;

	public void enterInputEmail(String value) {
		inputEmail.sendKeys(value);
	}

	public void clickButtonContinue() {
		buttonContinue.click();
	}

	public String getTextAlert() {
		return textAlert.getText();
	}

	public String getTagNameTextAlert() {
		return textAlert.getTagName();
	}
}
