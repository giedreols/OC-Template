package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends AbstractPage {

	@FindBy(xpath = "//div[@class='caption'][1]/h4/a")
	private WebElement linkFirstItem;

	public SearchPage(WebDriver driver) {
		super(driver);
	}

	public String getLinkFirstItemText() {
		return linkFirstItem.getText();
	}

	public void clickLinkFirstItemText() {
		linkFirstItem.click();
	}

}