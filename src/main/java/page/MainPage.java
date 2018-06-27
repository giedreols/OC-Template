package page;

import java.util.List;

import javax.xml.xpath.XPath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage {

	public String URL = "http://88.119.151.54/opencart/";

	// inputs
	@FindBy(name = "search")
	private WebElement inputSearch;

	// labels
	@FindBy(xpath = "//ul[@class='list-inline']/li/span")
	private List<WebElement> labelPhone;

	// buttons
	@FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
	private WebElement buttonSearch;
	
	@FindBy(xpath = "//button[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']")
	private WebElement buttonCart;

	@FindBy(xpath = "//div[@class='button-group']/button[1]")
	private List<WebElement> buttonsAddToCart;
	
	@FindBy(xpath = "//*[contains(., 'View Cart')]")
	private WebElement buttonViewCart;
	
	
	// links
	@FindBy(linkText = "Login")
	private WebElement linkLogin;
	
	@FindBy(linkText = "My Account")
	private WebElement linkMyAccount;
	
	@FindBy(linkText = "Desktops")
	private WebElement linkDesktops;
	
	@FindBy(linkText = "Show All Desktops")
	private WebElement linkAllDesktops;
	

	public MainPage(WebDriver driver) {
		super(driver);
	}
	
	public void clickLinkLogin() {
		linkLogin.click();
	}
	
	public void clickLinkDesktops() {
		linkDesktops.click();
	}
	
	public void clickLinkAllDesktops() {
		linkAllDesktops.click();
	}
	
	public void clickLinkMyAccount() {
		linkMyAccount.click();
	}

	public void enterInputSearch(String value) {
		inputSearch.sendKeys(value);
	}
	
	public void clearInputSearch() {
		inputSearch.clear();
	}

	public void clickButtonSearch() {
		buttonSearch.click();
	}
	
	public void clickButtonAddToCart() {
		buttonCart.click();
	}
	
	public void clickButtonViewCart() {
		buttonViewCart.click();
	}
}