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
public class TC_05Test extends BaseClass {

	@Test
	public void CreatePurchaseOrderWithItemAndAddProduct() {

		String expectedPurchasePageTitle = elib.readStringDataFromExcel("Sheet1", 2, 0);
		String TC_5VendorName = elib.readStringDataFromExcel("Sheet1", 7, 0);
		String TC_5StreetAdd = elib.readStringDataFromExcel("Sheet1", 7, 1);
		double TC_5PinCode = elib.readNumberDataFromExcel("Sheet1", 7, 2);
		String subjectText = elib.readStringDataFromExcel("Sheet1", 3, 0);
		String TC_5BillingAdd = elib.readStringDataFromExcel("Sheet1", 7, 3);
		double TC_5BillingPinCode = elib.readNumberDataFromExcel("Sheet1", 7, 4);

		PurchasePage purchasePage = new PurchasePage(driver);
		purchasePage.homeToApp(driver);

		Assert.assertEquals(driver.getTitle(), expectedPurchasePageTitle, "Purchase Page Title is not displayed");
		Reporter.log("Purchase Page Title displayed successfully", true);

		purchasePage.CreatePurchaseOrderWithItemAndAddProduct(driver, TC_5VendorName, TC_5StreetAdd, TC_5PinCode,
				subjectText, TC_5BillingAdd, TC_5BillingPinCode);
	}

}
