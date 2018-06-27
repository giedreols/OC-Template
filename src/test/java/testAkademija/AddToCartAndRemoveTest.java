package testAkademija;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertTrue;

import java.util.function.Function;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import junit.framework.AssertionFailedError;
import net.bytebuddy.utility.RandomString;
import page.AccountLoginPage;
import page.AllDesktopsPage;
import page.MainPage;
import page.PasswordReminderPage;
import page.ProductPage;
import test.AbstractTest;
import utils.JavascriptWaiter;

public class AddToCartAndRemoveTest extends AbstractTest {

	private static MainPage mainPage;
	private static AllDesktopsPage desktopsPage;

	@BeforeClass
	public static void data() {
		driver.get("https://demo.opencart.com/");

		mainPage = new MainPage(driver);
		desktopsPage = new AllDesktopsPage(driver);

	}

	@Test
	public void testAddToCartAndRemove() throws InterruptedException {
		addToCart();
		JavascriptWaiter.wait(driver);
		assertThat(desktopsPage.getTextAlert(), containsString("Success"));
		assertThat(desktopsPage.getTextCartTotal(), containsString("1 item(s)"));

		removeFromCart();
		JavascriptWaiter.wait(driver);
		assertThat(desktopsPage.getTextCartTotal(), containsString("0 item(s)"));

	}

	private void removeFromCart() {
		desktopsPage.clickButtonCartTotal();
		desktopsPage.clickButtonRemoveFromCart();

	}

	private void addToCart() {
		mainPage.clickLinkDesktops();
		mainPage.clickLinkAllDesktops();
		desktopsPage.clickButtonMacBookAddToCart();
	}

}
