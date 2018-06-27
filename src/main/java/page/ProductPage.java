package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends AbstractPage {

	@FindBy(xpath = "//li[contains(., 'Availability')]")
	private WebElement textAvailability;
	
	@FindBy(id = "button-cart")
	private WebElement buttonAddToCart;
	
	@FindBy (xpath = "//*[@id=\"cart\"]/button")
	private WebElement buttonCart;

	public ProductPage(WebDriver driver) {
		super(driver);
	}

	public String getTextAvailability() {
		return textAvailability.getText();
	}
	
	public void clickButtonAddToCart() {
		buttonAddToCart.click();
	}
	
	public void clickButtonCart() {
		buttonCart.click();
	}

}
