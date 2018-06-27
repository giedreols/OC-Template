package testAkademija;

import java.math.BigDecimal;
import java.util.Arrays;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import page.MainPage;
import page.ShoppingCartPage;
import test.AbstractTest;

public class DiscountCheckTrick extends AbstractTest {
	
	private static MainPage mainPage;
	private static ShoppingCartPage cartPage;
	
	@BeforeClass
	public void preconditions() {
		driver.get("http://88.119.151.54/opencart/");
		mainPage = new MainPage(driver);
		cartPage = new ShoppingCartPage(driver);
	}
	
	@Test
	public void testDiscounts() {
		
		System.out.println(stringConvertToDouble("$20.215"));
		
		System.out.printf("%.2f", 200.3456);
		
	}
	
	
	private double stringConvertToDouble(String valueString) {
		
		StringBuilder buildValue = new StringBuilder(valueString);
		buildValue.deleteCharAt(0);
		
		double valueDouble = Double.parseDouble(buildValue.toString());
		return valueDouble;
	}

	

}
