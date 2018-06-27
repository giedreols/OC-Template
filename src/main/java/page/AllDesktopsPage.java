package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllDesktopsPage extends AbstractPage {

	@FindBy(linkText = "Apple Cinema 30\"")
	private WebElement linkAppleCinema30;

	@FindBy(linkText = "HTC Touch HD")
	private WebElement linkHtcTouchHd;

	@FindBy(xpath = "//div[@class='caption'][1]/h4/a")
	private WebElement linkFirstItem;

	@FindBy(xpath = "//a[contains(., 'MacBook')]/../../../div[@class='button-group']/button")
	private WebElement buttonMacBookAddToCart;

	@FindBy(xpath = "//*[@class='alert alert-success alert-dismissible']")
	private WebElement textAlert;

	@FindBy(id = "cart-total")
	private WebElement textCartTotal;

	@FindBy(xpath = "//*[@class = 'btn btn-inverse btn-block btn-lg dropdown-toggle']")
	private WebElement buttonCartTotal;

	@FindBy(xpath = "//*[@title='Remove']")
	private WebElement buttonRemoveFromCartFirstElement;

	public AllDesktopsPage(WebDriver driver) {
		super(driver);
	}

	public void clickLinkAppleCinema30() {
		linkAppleCinema30.click();
	}

	public String getTextAlert() {
		return textAlert.getText();
	}

	public String getTextCartTotal() {
		return textCartTotal.getText();
	}

	public void clickButtonCartTotal() {
		buttonCartTotal.click();
	}

	public void clickButtonRemoveFromCart() {
		buttonRemoveFromCartFirstElement.click();
	}

	public void clickLinkHtcTouchHd() {
		linkHtcTouchHd.click();
	}

	public void clickLinkFirstItemText() {
		linkFirstItem.click();
	}

	public void clickButtonMacBookAddToCart() {
		buttonMacBookAddToCart.click();
	}

}
