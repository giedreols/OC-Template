package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCartPage extends AbstractPage {

	private WebDriverWait wait = new WebDriverWait(driver, 5);

	@FindBy(xpath = "//*[@id=\"cart\"]/ul/li[2]/div/p/a[1]")
	private WebElement linkViewCart;

	@FindBy(xpath = "//*[@id=\"content\"]/form/div/table/tbody/tr/td[4]/div/input")
	private WebElement fieldQuantity;

	@FindBy(xpath = "//*[@id=\"content\"]/form/div/table/tbody/tr/td[5]")
	private WebElement valueUnitPrice;

	@FindBy(xpath = "//*[@id=\"content\"]/form/div/table/tbody/tr/td[6]")
	private WebElement valueTotalPrice;

	@FindBy(xpath = "//*[@id=\"content\"]/form/div/table/tbody/tr/td[4]/div/span/button[1]")
	private WebElement buttonRefresh;
	
	@FindBy(xpath = "//*[@id=\"content\"]/form/div/table/tbody/tr/td[4]/div/span/button[2]")
	private WebElement buttonRemove;

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}

	public void clickLinkViewCart() {
		linkViewCart.click();
	}

	public int getQuantity() {
		return Integer.parseInt(fieldQuantity.getAttribute("value"));
	}

	public void enterQuantity(int i) {
		fieldQuantity.clear();
		fieldQuantity.sendKeys(String.valueOf(i));

	}

	public double getUnitPrice() {
		// wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"content\"]/form/div/table/tbody/tr/td[5]")));
		return stringConvertToDouble(valueUnitPrice.getText());
	}

	public double getTotalPrice() {
		return stringConvertToDouble(valueTotalPrice.getText());
	}

	public void clickButtonRefreshAMount() {
		buttonRefresh.click();
	}

	private double stringConvertToDouble(String valueString) {

		StringBuilder buildValue = new StringBuilder(valueString);
		buildValue.deleteCharAt(0);
		if (buildValue.length() > 6) {
			buildValue.deleteCharAt(buildValue.indexOf(","));
		}

		double valueDouble = Double.parseDouble(buildValue.toString());
		return valueDouble;
	}
	
	public void clickButtonRemove() {
		buttonRemove.click();
	}

}
