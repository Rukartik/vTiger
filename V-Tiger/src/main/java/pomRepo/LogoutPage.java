package pomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/***
 * 
 * @author kartik
 *
 */

public class LogoutPage {

	// constructor
	public LogoutPage(WebDriver driver) {
		PageFactory.initElements((WebDriver) driver, this);
	}

	@FindBy(xpath = "(//td[@class=\"small\" and @valign=\"bottom\"])[1]")
	private WebElement loginIcon;

	@FindBy(linkText = "Sign Out")
	private WebElement signOut;

	public WebElement getLoginIcon() {
		return loginIcon;
	}

	public WebElement getSignOut() {
		return signOut;
	}

	public void LogoutToApp() {
		loginIcon.click();
		signOut.click();
	}

}
