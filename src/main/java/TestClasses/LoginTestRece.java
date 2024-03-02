package TestClasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

//import PageClasses.InstitutePage;
import PageClasses.LoginPage;
import PageClasses.SessionPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTestRece {
	
	WebDriver driver;
	LoginPage objLogin;
	SessionPage objSessionPage;
	SoftAssert sa;
	
	@BeforeTest
	public void setup()  {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		sa = new SoftAssert();
		driver.get("https://live.medica.lk/ReceptionV2/");
		//driver.get(PropertyFileReader.readPropertyFile("URL", "./Data/Data.properties"));
		
		
	}
	

	@Test (priority=1)
	public void login() throws InterruptedException  {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		objLogin = new LoginPage(driver);
		objLogin.login("nurse", "nurse");
		//objLogin.login(PropertyFileReader.readPropertyFile("Username", "./Data/Data.properties"),PropertyFileReader.readPropertyFile("Password", "./Data/Data.properties"));
		objSessionPage = new SessionPage(driver);
		//sa.assertEquals(objHome.getHomePageText(), "Retrieve Quotation");
		//sa.assertTrue(objHome.getHomePageText().contains("Retrieve Quotation"));
	//	sa.assertTrue(objIns.getHomePageText().contains(PropertyFileReader.readPropertyFile("Heading", "./Data/Data.properties")));
		
	  Thread.sleep(1000);
		
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
		sa.assertAll();
		}

}
