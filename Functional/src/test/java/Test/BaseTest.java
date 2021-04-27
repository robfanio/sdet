package Test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import Pages.LoginPage;
import Utilities.ReadConfig;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;

public class BaseTest {
	WebDriver driver;
	LoginPage lgPage;
	public static Logger logger;
	ReadConfig readConfig = new ReadConfig();
//--------VARIABLES FROM CONFIG.PROPERTIES
	String baseUrl = readConfig.getUrl();
	String userId = readConfig.getUserName();
	String password = readConfig.getPassword();
	
	@Parameters("browser")
	@BeforeClass
	public void SetUp(@Optional("Chrome")String browsers) {
		
		logger = Logger.getLogger("Functional");
		PropertyConfigurator.configure("log4j.properties"); //if your If your log4j.properties file is in the top most of the directory i.e src/log4j.properties then you don't have to use PropertyConfigurator.configure("log4j.properties"); log4j will automatically searches for that file. hope this will help

		if (browsers.equalsIgnoreCase("Chrome")) {
			
			System.setProperty("webdriver.chrome.driver", readConfig.getChrome());
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			lgPage = new LoginPage(driver);
 
		} else if (browsers.equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.gecko.driver", readConfig.getFirefox());
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			lgPage = new LoginPage(driver);
		}else if(browsers.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver",readConfig.getIE());
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
		}	
		
	
	}
	
	public void OpenUrl() {
		driver.get(baseUrl); 
	}
	public void captureScreen(WebDriver driver, String tname) throws IOException {
//		TakesScreenshot ts = (TakesScreenshot) driver;
//		File source = ts.getScreenshotAs(OutputType.FILE);
//		Date currentDate = new Date();
//		String takeShot= currentDate.toString().replace(" ", "-").replace(" ", "-");
//		File target = new File(System.getProperty("user.dir")+"\\Screenshots\\"+takeShot +tname+"pic.png");
//		FileUtils.copyFile(source, target);
		
		String label= new Date().toString().replace(" ", "-").replace(":", "-");
		File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scr, new File(System.getProperty("user.dir")+ "\\Screenshots\\"+label+tname+".png"));
		
		
		
		System.out.println("Screenshot taken");
	}
	
	
	
	
	
	

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}



