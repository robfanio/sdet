package Test;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
	@Test(priority = 1 )
	public void getTitle() throws IOException {

		OpenUrl();
		logger.info("open url");
		
		logger.info("SigIn into the website");
		lgPage.SignIn(userId, password);

		logger.info("Verified The Title Page");
		
		if (driver.getTitle().equals("1Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
		} else {
			captureScreen(driver, "logIntest");
			Assert.assertTrue(false);

		}

	}

	@Test(priority =2 )
	public void LogoVerification() {
		OpenUrl();
		logger.info("open url");
		lgPage.SignIn(userId, password);
		boolean logo = lgPage.logo.isDisplayed();
		Assert.assertTrue(logo);

	}

	@Test(priority =3 )

	public void btnClickable() throws IOException {
		OpenUrl();
		logger.info("open url");
		lgPage.submit.isEnabled();
	}

	@Test(priority =4 )
	public void display() {
		OpenUrl();
		lgPage.SignIn(userId, password);
		boolean dP = lgPage.ManagerId.isDisplayed();
		Assert.assertTrue(dP);
	}

}
