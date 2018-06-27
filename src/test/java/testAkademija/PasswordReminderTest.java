package testAkademija;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import junit.framework.AssertionFailedError;
import net.bytebuddy.utility.RandomString;
import page.AccountLoginPage;
import page.MainPage;
import page.PasswordReminderPage;
import test.AbstractTest;
import utils.JavascriptWaiter;

public class PasswordReminderTest extends AbstractTest {

	private static MainPage mainPage;
	private static AccountLoginPage loginPage;
	private static PasswordReminderPage reminderPage;

	private static String email;

	@BeforeClass
	public static void data() {
		driver.get("https://demo.opencart.com/");

		mainPage = new MainPage(driver);
		loginPage = new AccountLoginPage(driver);
		reminderPage = new PasswordReminderPage(driver);

		email = RandomString.make() + "@gmail.com";

	}

	@Test
	public void testRegistration() {

		mainPage.clickLinkMyAccount();
		mainPage.clickLinkLogin();

		loginPage.clickLinkForgottenPassword();

		reminderPage.enterInputEmail(email);
		reminderPage.clickButtonContinue();
		
		JavascriptWaiter.wait(driver);

		if (reminderPage.getTextAlert().contains("Warning")) {
			assertTrue(true);

		} else {
			throw new AssertionFailedError("Test failed, waiting time is too short.");
		}

	}

}
