package TestClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageClasses.AppointmentsPage;
import PageClasses.LoginPage;
import PageClasses.PharmacyPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestPharmacyRece {
	
	private WebDriver driver;
    private PharmacyPage pharmacyPage;
    private SoftAssert softAssert;
    LoginPage objLogin;
    
    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        pharmacyPage = new PharmacyPage(driver);
        softAssert = new SoftAssert();
        driver.get("https://live.medica.lk/ReceptionV2/");
    }
    
    @Test(priority = 1)
    public void pharmacyViewTest() {
    	objLogin = new LoginPage(driver);
		objLogin.login("nurse", "nurse");

	    pharmacyPage.clickPharmacyViewButton();
        softAssert.assertEquals(driver.getCurrentUrl(), "https://live.medica.lk/ReceptionV2/pharmacy",
                "URL after clicking Pharmacy View button is incorrect");
    }
    @Test(priority = 2, dependsOnMethods = "pharmacyViewTest")
    public void searchPrescriptionsTest() {
        pharmacyPage.searchPrescriptions("Physical", "2024/01/15");
        
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        softAssert.assertAll();
    }

}
