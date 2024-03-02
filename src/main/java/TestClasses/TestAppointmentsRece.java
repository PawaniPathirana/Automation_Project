package TestClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageClasses.AppointmentsPage;
import PageClasses.LoginPage;
import PageClasses.SessionPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestAppointmentsRece {
	WebDriver driver;
	LoginPage objLogin;
	AppointmentsPage objAppointmentsPage;
	SoftAssert sa;
	
	@BeforeTest
	public void setup()  {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		sa = new SoftAssert();
		objAppointmentsPage = new AppointmentsPage(driver);
	   driver.get("https://live.medica.lk/ReceptionV2/");
		
	}
	 
    @Test
    public void testAppointmentsBtn() {
       
    	objLogin = new LoginPage(driver);
		objLogin.login("nurse", "nurse");
		objAppointmentsPage = new AppointmentsPage(driver);
		objAppointmentsPage.appointmentBtn();

        
    }
    
    @Test
    public void testsearchAppointments() {
       
    	objAppointmentsPage.searchAppointments("All Doctors", "2024-01-15");

      
    }
    
    @Test
    public void testViewAppointmentDetails() {
       
    	objAppointmentsPage.viewAppointmentDetails();

       
    }
}
