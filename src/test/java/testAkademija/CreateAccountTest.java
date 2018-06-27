package testAkademija;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import models.Account;
import net.bytebuddy.utility.RandomString;
import page.CreateNewAccountPage;
import page.MyAccountPage;
import test.AbstractTest;
import utils.FromListToObjectConverter;
import utils.TxtReader;

public class CreateAccountTest extends AbstractTest {

	private static CreateNewAccountPage registerPage;
	private static MyAccountPage accountPage;

	private static Account accountDetails;

	@BeforeClass
	public static void data() {
		driver.get("http://88.119.151.54/opencart/index.php?route=account/register");

		registerPage = new CreateNewAccountPage(driver);
		accountPage = new MyAccountPage(driver);

		accountDetails = new Account();
	}

	@Test
	public void testRegistration() {

		fillInAllRegisterPageFields();
		assertThat("Input fields number ir correct", registerPage.countInputFields(), is(14));

		registerPage.clickButtonContinue();

		assertThat("New account has been created and message 'Your Account Has Been Created!' is shown",
				registerPage.getTextConfirmation(), is("Your Account Has Been Created!"));

		accountPage.clickButtonContinue();

		accountPage.clickLinkEditAccount();

		assertThat("Email is correct", accountPage.getEmail(), is(accountDetails.getEmail()));
		assertThat("First name is correct", accountPage.getFirstName(), is(accountDetails.getFirstName()));
		assertThat("Last name is correct", accountPage.getLastName(), is(accountDetails.getLastName()));
		assertThat("Telephone number is correct", accountPage.getTelephonel(), is(accountDetails.getTelephone()));

	}

	private void fillInAllRegisterPageFields() {
		registerPage.enterInputAddress_1(accountDetails.getAddress());
		registerPage.enterInputCity(accountDetails.getCity());
		registerPage.enterInputEmail(accountDetails.getEmail());
		registerPage.enterInputFax(accountDetails.getFax());
		registerPage.enterInputFirstName(accountDetails.getFirstName());
		registerPage.enterInputLastName(accountDetails.getLastName());
		registerPage.enterInputTelephone(accountDetails.getTelephone());
		registerPage.enterInputPostCode(accountDetails.getPostCode());

		registerPage.enterInputPassword(accountDetails.getPassword());
		registerPage.enterInputConfirm(accountDetails.getPassword());

		registerPage.selectZone(accountDetails.getZone());

		registerPage.clickCheckboxAgree();
		registerPage.clickLabelNewsletter();

	}

}
