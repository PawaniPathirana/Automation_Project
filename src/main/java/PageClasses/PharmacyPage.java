package PageClasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PharmacyPage {
	
	private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By pharmacyViewButton = By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div[1]/div[4]");
    private By doctorSearchInput = By.xpath("//*[@id=\":r7:\"]");
    private By dateInput = By.xpath("//*[@id=\"TxtAppointmentsSearchDate\"]");
    private By searchButton = By.xpath("//*[@id=\"PrescriptionsSearchButton\"]");
    private By loadingOverlay = By.className("loading-overlay");

    public PharmacyPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(50)); // Set an appropriate timeout
    }

    public void clickPharmacyViewButton() {
      
            
        
        try {
           
            wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingOverlay));
            
            
            WebElement pharmacyView = wait.until(ExpectedConditions.elementToBeClickable(pharmacyViewButton));
            pharmacyView.click();
            
        } catch (Exception e) {
           
            System.out.println("Failed to click search button: " + e.getMessage());
            
        }
    }
    
    public void searchPrescriptions(String doctorName, String date) {
        WebElement doctorSearch = wait.until(ExpectedConditions.visibilityOfElementLocated(doctorSearchInput));
        doctorSearch.sendKeys(doctorName);

        WebElement dateInputField = driver.findElement(dateInput);
        dateInputField.sendKeys(date);

        WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchBtn.click();
    }

}
