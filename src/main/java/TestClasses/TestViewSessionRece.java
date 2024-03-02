package TestClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.util.Assert;

import PageClasses.LoginPage;
import PageClasses.SessionPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestViewSessionRece {
	
	WebDriver driver;
	LoginPage objLogin;
	SessionPage objSessionPage;
	SoftAssert sa;
	
	@BeforeTest
	public void setup()  {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		sa = new SoftAssert();
	   objSessionPage = new SessionPage(driver);
	   driver.get("https://live.medica.lk/ReceptionV2/");
		
	}
    @Test
    public void testClickViewSessionsButton() {
        
    	objLogin = new LoginPage(driver);
		objLogin.login("nurse", "nurse");
		objSessionPage = new SessionPage(driver);
    	objSessionPage.clickViewSessionsButton();
    	

        // Add assertions or further verifications if needed
        // For example, you can verify if the expected page is loaded after clicking the button
       // String currentUrl = driver.getCurrentUrl();
        //Assert.assertEquals(currentUrl, "https://example.com/sessions");
    }
    
    @Test
    public void testAddSession() {
       
    	
    	objSessionPage.addSession("Colombo", "Physical", "2024/01/15", "2", "Counselling", "4:00 PM", "8:00 PM", "5", "2");

        // Add assertions or further verifications if needed
        // For example, you can verify if the session is added successfully by checking the UI response or database state
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.quit();
    }


}
