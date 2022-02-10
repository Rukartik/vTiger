package vTiger_TestCase;

import org.testng.annotations.Test;

import pomRepo.PurchasePage;
/***
 * 
 * @author kartik
 *
 */
public class TC_03Test extends BaseClass {

	@Test
	public void CreatePurchaseOrderWithVendorNameFromVendorModule() {

		double quntity = elib.readNumberDataFromExcel("Sheet1", 3, 1);
		String user1 = elib.readStringDataFromExcel("Sheet1", 5, 0);
		String streetAdd = elib.readStringDataFromExcel("Sheet1", 5, 1);
		double pinCode = elib.readNumberDataFromExcel("Sheet1", 5, 2);
		String subjectText = elib.readStringDataFromExcel("Sheet1", 3, 0);

		PurchasePage purchasePage = new PurchasePage(driver);
		purchasePage.CreatePurchaseOrderWithVendorNameFromVendorModule(driver, user1, streetAdd, pinCode, subjectText,
				quntity);

	}
}
