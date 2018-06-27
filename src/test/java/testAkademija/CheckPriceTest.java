package testAkademija;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.function.Function;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.thoughtworks.xstream.XStream;

import junit.framework.AssertionFailedError;
import models.ShopItem;
import net.bytebuddy.utility.RandomString;
import page.AccountLoginPage;
import page.MainPage;
import page.PasswordReminderPage;
import page.ProductPage;
import page.SearchPage;
import page.ShoppingCartPage;
import test.AbstractTest;
import utils.XmlReader;
import utils.JavascriptWaiter;

import utils.FromListToObjectConverter;

public class CheckPriceTest extends AbstractTest {

	private static MainPage mainPage;
	private static SearchPage searchPage;
	private static ProductPage productPage;
	private static ShoppingCartPage cartPage;

	private int quantity;
	private String name;
	private static ArrayList<ShopItem> itemList;

	@BeforeClass
	public static void data() {
		driver.get("https://demo.opencart.com/");

		mainPage = new MainPage(driver);
		searchPage = new SearchPage(driver);
		productPage = new ProductPage(driver);
		cartPage = new ShoppingCartPage(driver);

		itemList = XmlReader.readDataFromXML("src/test/resources/ItemAndAmount.xml");
	}

	@DataProvider(name = "items")
	public static Object[][] getItems() {
		return FromListToObjectConverter.convert(itemList);

	}

	@Test(dataProvider = "items")
	public void testCheckPrice(ShopItem item) throws InterruptedException, IOException {

		name = item.getName();
		quantity = Integer.parseInt(item.getAmount());

		searchProduct(name);

		addToCart();
		viewCart();

		selectQuantity(quantity);

		assertThat("Actual and calculated total prices are equal", getTotalPrice(), is(calculateTotalPrice(quantity)));

		removeItem();

	}

	private void removeItem() {
		cartPage.clickButtonRemove();
		JavascriptWaiter.wait(driver);

	}

	private double calculateTotalPrice(int quantity) {
		return getUnitPrice() * quantity;

	}

	private double getTotalPrice() {
		return cartPage.getTotalPrice();
	}

	private double getUnitPrice() {
		return cartPage.getUnitPrice();

	}

	private void selectQuantity(int units) {
		cartPage.enterQuantity(units);
		JavascriptWaiter.wait(driver);
		cartPage.clickButtonRefreshAMount();

	}

	private void viewCart() {
		productPage.clickButtonCart();
		cartPage.clickLinkViewCart();
	}

	private void addToCart() {
		searchPage.clickLinkFirstItemText();
		productPage.clickButtonAddToCart();
		JavascriptWaiter.wait(driver);

	}

	private void searchProduct(String product) {
		mainPage.enterInputSearch(product);
		mainPage.clickButtonSearch();
	}

}
