package TestClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageClasses.BillingPage;
import PageClasses.LoginPage;
import PageClasses.PharmacyPage;
import PageClasses.SessionPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BillingTest {
	
	private WebDriver driver;
    private PharmacyPage pharmacyPage;
    private SoftAssert softAssert;
    LoginPage objLogin;
    SessionPage objSessionPage;
    BillingPage objBillingPage;
    SoftAssert sa;
    
    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        
        softAssert = new SoftAssert();
        driver.get("https://live.medica.lk/ReceptionV2/");
    }
    
    @Test(priority = 1)
    public void navDocButtonTest() {
    	objLogin = new LoginPage(driver);
		objLogin.login("nurse", "nurse");
		objSessionPage = new SessionPage(driver);
		objSessionPage.navDocButton();
        softAssert.assertEquals(driver.getCurrentUrl(), "https://live.medica.lk/ReceptionV2/refund",
                "URL after clicking Pharmacy View button is incorrect");
    }
    @Test(priority = 2)
    public void searchAppTest() {
    	objBillingPage = new BillingPage(driver);
    	objBillingPage.searchBar("789");
        softAssert.assertEquals(driver.getCurrentUrl(), "https://live.medica.lk/ReceptionV2/refund",
                "URL after clicking Pharmacy View button is incorrect");
    }
	@AfterTest
	public void teardown() {
		driver.close();
		sa.assertAll();
		}

}
