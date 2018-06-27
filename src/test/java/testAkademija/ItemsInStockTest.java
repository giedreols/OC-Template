package testAkademija;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.MainPage;
import page.ProductPage;
import page.SearchPage;
import test.AbstractTest;
import utils.FromListToObjectConverter;
import utils.TxtReader;

public class ItemsInStockTest extends AbstractTest {

	MainPage mainPage;
	SearchPage searchPage;
	ProductPage productPage;

	@BeforeClass
	public void preconditions() {
		driver.get("http://88.119.151.54/opencart");
		mainPage = new MainPage(driver);
		searchPage = new SearchPage(driver);
		productPage = new ProductPage(driver);

	}

	@DataProvider(name = "provider")
	public static Object[][] names() throws IOException {
		List <String> list = TxtReader.getRecods("src/test/resources/TestData.txt");
		return FromListToObjectConverter.convert(list);
	}

	@Test(dataProvider = "provider")
	public void searchTest(String item) throws IOException {

		mainPage.clearInputSearch();
		mainPage.enterInputSearch(item);
		mainPage.clickButtonSearch();
		searchPage.clickLinkFirstItemText();

		assertThat(productPage.getTextAvailability(), containsString("In Stock"));
	}

}