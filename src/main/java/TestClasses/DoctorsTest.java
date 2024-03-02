package TestClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageClasses.BillingPage;
import PageClasses.DoctorPage;
import PageClasses.LoginPage;
import PageClasses.SessionPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DoctorsTest {

	private WebDriver driver;
	private SoftAssert softAssert;
	 LoginPage objLogin;
	    SessionPage objSessionPage;
	    BillingPage objBillingPage;
	    DoctorPage objDoctorsPage;
	SoftAssert sa;
	
	@BeforeTest
	public void setup()  {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		sa = new SoftAssert();
		driver.get("https://live.medica.lk/ReceptionV2/");
		//driver.get(PropertyFileReader.readPropertyFile("URL", "./Data/Data.properties"));
		
		
	}
	 @Test(priority = 1)
	    public void navButtonTest() {
	    	objLogin = new LoginPage(driver);
			objLogin.login("nurse", "nurse");
			objSessionPage = new SessionPage(driver);
			objSessionPage.navDocButton();
	        softAssert.assertEquals(driver.getCurrentUrl(), "https://live.medica.lk/ReceptionV2/refund",
	                "URL after clicking Pharmacy View button is incorrect");
	    }
	 @Test(priority = 2)
	    public void navDocPageButtonTest() {
		 objBillingPage = new BillingPage(driver);
	    	objBillingPage.docNav();
	        softAssert.assertEquals(driver.getCurrentUrl(), "https://live.medica.lk/ReceptionV2/refund",
	                "URL after clicking Pharmacy View button is incorrect");
	    }
	 @Test(priority = 3)
	    public void selectBranchTest() {
		 objDoctorsPage = new DoctorPage(driver);
		 objDoctorsPage.selectBranch("Colombo");
	        softAssert.assertEquals(driver.getCurrentUrl(), "https://live.medica.lk/ReceptionV2/refund",
	                "URL after clicking Pharmacy View button is incorrect");
	    }
	 @Test(priority = 4)
	    public void searchDoctorTest() {
		 objDoctorsPage = new DoctorPage(driver);
		 objDoctorsPage.searchDoctor("Colombo","Gaythri");
	        softAssert.assertEquals(driver.getCurrentUrl(), "https://live.medica.lk/ReceptionV2/refund",
	                "URL after clicking Pharmacy View button is incorrect");
	    }
	 
	 @AfterTest
		public void teardown() {
			driver.close();
			sa.assertAll();
			}
}
	 
	 


