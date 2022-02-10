package genericLib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import pomRepo.LoginPage;
import pomRepo.LogoutPage;
import pomRepo.PurchasePage;

/***
 * 
 * @author kartik
 *
 */

public class BaseClass {

	public WebDriver driver;
	public WebDriverWait explicitWait;
	public PurchasePage purchasePage;
	public ExcelLib elib = new ExcelLib();

	@Parameters("browserName")
	@BeforeClass(alwaysRun = true)
	public void beforeClass(@Optional("chrome") String bName) {
		if (bName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./src/main/resources/driver/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (bName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./src/main/resources/driver/geckodriver.exe");
			driver = new FirefoxDriver();
		} else {
			System.setProperty("webdriver.chrome.driver", "./src/main/resources/driver/chromedriver.exe");
			driver = new ChromeDriver();
		}
		Reporter.log("Browser is launched Successfully", true);
		driver.manage().window().maximize();
		Reporter.log("Browser is maximized Successfully", true);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		explicitWait = new WebDriverWait(driver, 10);
		driver.get(elib.readStringDataFromExcel("Sheet1", 0, 0));
	}

	@BeforeMethod(alwaysRun = true)
	public void beforeMethod() {

		Assert.assertEquals(driver.getTitle(), elib.readStringDataFromExcel("Sheet1", 1, 0),
				"Login page is not displayed");
		Reporter.log("Login page displayed successfully", true);

		LoginPage loginPage = new LoginPage(driver);
		loginPage.LoginToApp(elib.readStringDataFromExcel("Sheet1", 0, 1),
				elib.readStringDataFromExcel("Sheet1", 0, 2));

		WebDriverWait explicitWait = new WebDriverWait(driver, 10);
		explicitWait
				.until(ExpectedConditions.titleIs("Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM"));

		Assert.assertEquals(driver.getTitle(), elib.readStringDataFromExcel("Sheet1", 1, 1),
				"Home page is not displayed");
		Reporter.log("Home page displayed successfully", true);
	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod() {

		LogoutPage logoutPage = new LogoutPage(driver);
		logoutPage.LogoutToApp();
		Assert.assertEquals(driver.getTitle(), elib.readStringDataFromExcel("Sheet1", 1, 0),
				"Login page is not displayed");
		Reporter.log("Login page displayed successfully", true);

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {

		driver.quit();
		Reporter.log("Application logged out successfully", true);
	}

}
