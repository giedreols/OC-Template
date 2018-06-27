package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class JavascriptWaiter {

	public static void wait(WebDriver driver) {
		
		new WebDriverWait(driver, 5).until(new Function<WebDriver, Boolean>() {

			public Boolean apply(WebDriver driver) {
			
				return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
			}
		});
	}
}
