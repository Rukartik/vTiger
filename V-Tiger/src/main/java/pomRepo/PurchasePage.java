package pomRepo;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/***
 * 
 * @author kartik
 *
 */
public class PurchasePage {

	public PurchasePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

//**********************************MoreOption************************************************

	@FindBy(linkText = "More")
	private WebElement moreOptions;

	@FindBy(linkText = "Purchase Order")
	private WebElement purchaseOrderLink;

	public WebElement getMoreOptions() {
		return moreOptions;
	}

	public WebElement getPurchaseOrderLink() {
		return purchaseOrderLink;
	}

	public void homeToApp(WebDriver driver) {

		Actions action = new Actions(driver);
		action.moveToElement(moreOptions).perform();
		purchaseOrderLink.click();
	}

//************************************TC-01*********************************************************

	@FindBy(xpath = "//img[@alt=\"Create Purchase Order...\"]")
	private WebElement imgIcon;

	@FindBy(xpath = "//input[@name=\"subject\"]")
	private WebElement subject;

	@FindBy(xpath = "//input[@name=\"vendor_name\"]/..//img[@alt=\"Select\"]")
	private WebElement vendorName;

	@FindBy(id = "searchIcon1")
	private WebElement item;

	@FindBy(id = "qty1")
	private WebElement qty;

	@FindBy(linkText = "Sign Out")
	private WebElement signOut;

	public WebElement getSignOut() {
		return signOut;
	}

	public WebElement getQty() {
		return qty;
	}

	@FindBy(xpath = "(//input[@name=\"button\"])[1]")
	private WebElement saveButton;

	@FindBy(id = "1")
	private WebElement vendor1;

	@FindBy(id = "popup_product_11")
	private WebElement prod1;

	@FindBy(xpath = "(//td[@class=\"small\" and @valign=\"bottom\"])[1]")
	private WebElement loginIcon;

	public WebElement getLoginIcon() {
		return loginIcon;
	}

	public WebElement getProd1() {
		return prod1;
	}

	public WebElement getVendor1() {
		return vendor1;
	}

	public WebElement getImgIcon() {
		return imgIcon;
	}

	public WebElement getSubject() {
		return subject;
	}

	public WebElement getVendorName() {
		return vendorName;
	}

	public WebElement getItem() {
		return item;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public void createPurchaseOrder(WebDriver driver, String subjectText, double quntity) {

		imgIcon.click();

		subject.sendKeys(subjectText);

		vendorName.click();

		String father = driver.getWindowHandle();
		Set<String> child1 = driver.getWindowHandles();
		for (String page1 : child1) {
			driver.switchTo().window(page1);
		}
		vendor1.click();

		driver.switchTo().window(father);
		item.click();

		String mother = driver.getWindowHandle();
		Set<String> child2 = driver.getWindowHandles();
		for (String page2 : child2) {
			driver.switchTo().window(page2);
		}
		prod1.click();

		driver.switchTo().window(mother);
		qty.sendKeys(" " + quntity);
		saveButton.click();

	}

	// **********************************TC-02**************************************

	@FindBy(id = "search_txt")
	private WebElement searchVendor;

	public WebElement getSearchVendor() {
		return searchVendor;
	}

	@FindBy(name = "search")
	private WebElement seacrhNow;

	public WebElement getSeacrhNow() {
		return seacrhNow;
	}

	@FindBy(linkText = "Ganesh")
	private WebElement TCVendorName;

	public WebElement getTCVendorName() {
		return TCVendorName;
	}

	@FindBy(linkText = "Dress")
	private WebElement prod2;

	public WebElement getProd2() {
		return prod2;
	}

	public void CreatePurchaseOrderWithVendorName(WebDriver driver, String subjectText, String VendorName,
			double quntity) {
		imgIcon.click();

		subject.sendKeys(subjectText);

		vendorName.click();

		String father = driver.getWindowHandle();
		Set<String> child1 = driver.getWindowHandles();
		for (String page1 : child1) {
			driver.switchTo().window(page1);
		}
		searchVendor.sendKeys(VendorName);// 4,0 Ganesh seacrhNow.click();
		TCVendorName.click();

		driver.switchTo().window(father);
		item.click();

		String mother = driver.getWindowHandle();
		Set<String> child2 = driver.getWindowHandles();
		for (String page2 : child2) {
			driver.switchTo().window(page2);
		}
		prod2.click();

		driver.switchTo().window(mother);
		qty.sendKeys("" + quntity);

		saveButton.click();

	}

//	  //*********************************TC-03*************************************

	@FindBy(name = "Vendors")
	private WebElement vendorModule;

	public WebElement getVendorModule() {
		return vendorModule;
	}

	@FindBy(xpath = "//img[@alt=\"Create Vendor...\"]")
	private WebElement createVendor;

	public WebElement getCreateVendor() {
		return createVendor;
	}

	@FindBy(name = "vendorname")
	private WebElement addVendorName;

	public WebElement getAddVendorName() {
		return addVendorName;

	}

	@FindBy(name = "street")
	private WebElement streetAddress;

	public WebElement getStreetAddress() {
		return streetAddress;
	}

	@FindBy(id = "city")
	private WebElement city;

	public WebElement getCity() {
		return city;
	}

	@FindBy(id = "postalcode")

	private WebElement postalCode;

	public WebElement getPostalCode() {
		return postalCode;
	}

	@FindBy(linkText = "Create Purchase Order")
	private WebElement createPurchaseOrderLink;

	public WebElement

			getCreatePurchaseOrderLink() {
		return createPurchaseOrderLink;
	}

	public void CreatePurchaseOrderWithVendorNameFromVendorModule(WebDriver driver, String user1, String streetAdd,
			double pinCode, String subjectText, double quntity) {

		Actions action = new Actions(driver);
		action.moveToElement(moreOptions).perform();
		vendorModule.click();
		createVendor.click();
		addVendorName.sendKeys(user1);
		streetAddress.sendKeys(streetAdd);
		postalCode.sendKeys("" + pinCode);
		saveButton.click();
		createPurchaseOrderLink.click();
		subject.sendKeys(subjectText);

		item.click();
		String mother = driver.getWindowHandle();
		Set<String> child2 = driver.getWindowHandles();
		for (String page2 : child2) {
			driver.switchTo().window(page2);
		}
		prod2.click();

		driver.switchTo().window(mother);
		qty.sendKeys("" + quntity);
		saveButton.click();
	}
	// *********************************TC-04*************************************

	@FindBy(linkText = "Products")
	private WebElement productsLink;

	public WebElement getProductsLink() {
		return productsLink;
	}

	@FindBy(xpath = "//img[@alt=\"Create Product...\"]")
	private WebElement createProductIcon;

	public WebElement getCreateProductIcon() {
		return createProductIcon;
	}

	@FindBy(name = "productname")
	private WebElement productName;

	public WebElement getProductName() {
		return productName;
	}

	@FindBy(linkText = "Dress")
	private WebElement prodDress;

	public WebElement getProdDress() {
		return prodDress;
	}

	public void CreatePurchaseOrderWithItem(WebDriver driver, String prodName, String subjectText, double quntity) {

		productsLink.click();
		createProductIcon.click();
		productName.sendKeys(prodName);
		saveButton.click();
		createPurchaseOrderLink.click();
		subject.sendKeys(subjectText);
		vendorName.click();

		String father = driver.getWindowHandle();
		Set<String> child1 = driver.getWindowHandles();
		child1.remove(father);
		for (String page1 : child1) {
			driver.switchTo().window(page1);
		}
		searchVendor.sendKeys("Ganesh");
		seacrhNow.click();
		TCVendorName.click();
		driver.switchTo().window(father);
		item.click();
		String mother = driver.getWindowHandle();
		Set<String> child2 = driver.getWindowHandles();
		for (String page2 : child2) {
			driver.switchTo().window(page2);
		}
		prodDress.click();
		driver.switchTo().window(mother);
		qty.clear();
		qty.sendKeys("" + quntity);
		/*
		 * try { Thread.sleep(2000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		saveButton.click();
		// loginIcon.click(); signOut.click();
	}

	// **************************************TC-05********************************
	@FindBy(name = "bill_street")
	private WebElement billingAddress;

	public WebElement getBillingAddress() {
		return billingAddress;
	}

	@FindBy(id = "bill_code")
	private WebElement billPostalCode;

	public WebElement getBillPostalCode() {
		return billPostalCode;
	}

	@FindBy(xpath = "//b[text()=\"Copy Billing address\"]/..//input[@name=\"cpy\"]")
	private WebElement copyButton;

	public WebElement getCopyButton() {
		return copyButton;
	}

	public void CreatePurchaseOrderWithItemAndAddProduct(WebDriver driver, String TC_5VendorName, String TC_5StreetAdd,
			double tC_5PinCode, String subjectText, String TC_5BillingAdd, double tC_5BillingPinCode) {
		Actions action = new Actions(driver);
		action.moveToElement(moreOptions).perform();
		vendorModule.click();
		createVendor.click();
		addVendorName.clear();
		addVendorName.sendKeys(TC_5VendorName);
		streetAddress.clear();
		streetAddress.sendKeys(TC_5StreetAdd);
		postalCode.clear();
		postalCode.sendKeys("" + tC_5PinCode);
		saveButton.click();

		createPurchaseOrderLink.click();
		subject.sendKeys(subjectText);
		billingAddress.clear();
		billingAddress.sendKeys(TC_5BillingAdd);
		billPostalCode.clear();
		billPostalCode.sendKeys("" + tC_5BillingPinCode);
		copyButton.click();

	}

}
