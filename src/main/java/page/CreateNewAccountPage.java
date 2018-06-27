package page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import net.bytebuddy.utility.RandomString;

public class CreateNewAccountPage extends AbstractPage {

	public CreateNewAccountPage(WebDriver driver) {
		super(driver);
	}

	// inputs
	@FindBy(name = "firstname")
	private WebElement inputFirstName;

	@FindBy(name = "lastname")
	private WebElement inputLastName;

	@FindBy(name = "email")
	private WebElement inputEmail;

	@FindBy(name = "telephone")
	private WebElement inputTelephone;

	@FindBy(name = "fax")
	private WebElement inputFax;

	@FindBy(name = "address_1")
	private WebElement inputAddress_1;

	@FindBy(name = "city")
	private WebElement inputCity;

	@FindBy(name = "password")
	private WebElement inputPassword;

	@FindBy(name = "confirm")
	private WebElement inputConfirm;

	@FindBy(id = "input-postcode")
	private WebElement inputPostCode;

	@FindBy(xpath = "//*[@class='form-control']")
	private List<WebElement> inputFields;

	// Select
	@FindBy(id = "input-zone")
	private WebElement selectZone;

	// labels
	@FindBy(name = "newsletter")
	private WebElement labelNewsletter;

	// checkbox
	@FindBy(name = "agree")
	private WebElement checkboxAgree;

	// button
	@FindBy(xpath = "//*[@value='Continue']")
	private WebElement buttonContinue;

	// text
	@FindBy(xpath = "//h1")
	private WebElement textConfirmation;

	public int countInputFields() {
		return inputFields.size();
	}

	public void enterInputFirstName(String value) {
		inputFirstName.sendKeys(value);
	}

	public void enterInputLastName(String value) {
		inputLastName.sendKeys(value);
	}

	public void enterInputEmail(String value) {
		inputEmail.sendKeys(value);
	}

	public void enterInputTelephone(int i) {
		inputTelephone.sendKeys(Integer.toString(i));
	}

	public void enterInputFax(int i) {
		inputFax.sendKeys(Integer.toString(i));
	}

	public void enterInputAddress_1(String value) {
		inputAddress_1.sendKeys(value);
	}

	public void enterInputCity(String value) {
		inputCity.sendKeys(value);
	}

	public void enterInputPassword(String value) {
		inputPassword.sendKeys(value);
	}

	public void enterInputConfirm(String value) {
		inputConfirm.sendKeys(value);
	}

	public void enterInputPostCode(int i) {
		inputPostCode.sendKeys(Integer.toString(i));
	}

	public Select clickZone() {
		return new Select(selectZone);
	}

	public void selectZone(int index) {
		Select zone = new Select(selectZone);
		zone.selectByIndex(index);
	}

	public void clickLabelNewsletter() {
		labelNewsletter.click();
	}

	public void clickCheckboxAgree() {
		checkboxAgree.click();
	}

	public void clickButtonContinue() {
		buttonContinue.click();
	}

	public String getTextConfirmation() {
		return textConfirmation.getText();
	}

}
