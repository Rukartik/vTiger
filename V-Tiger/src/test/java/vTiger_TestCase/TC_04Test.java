package vTiger_TestCase;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import genericLib.BaseClass;
import pomRepo.PurchasePage;
/***
 * 
 * @author kartik
 *
 */
public class TC_04Test extends BaseClass {

	@Test
	public void CreatePurchaseOrderWithItem() {

		String expectedPurchasePageTitle = elib.readStringDataFromExcel("Sheet1", 2, 0);
		String prodName = elib.readStringDataFromExcel("Sheet1", 6, 0);
		String subjectText = elib.readStringDataFromExcel("Sheet1", 3, 0);
		double quntity = elib.readNumberDataFromExcel("Sheet1", 3, 1);

		PurchasePage purchasePage = new PurchasePage(driver);
		purchasePage.homeToApp(driver);

		Assert.assertEquals(driver.getTitle(), expectedPurchasePageTitle, "Purchase Page Title is not displayed");
		Reporter.log("Purchase Page Title displayed successfully", true);

		purchasePage.CreatePurchaseOrderWithItem(driver, prodName, subjectText, quntity);
	}

}
