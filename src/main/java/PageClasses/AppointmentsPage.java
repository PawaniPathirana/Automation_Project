package PageClasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppointmentsPage {
	
	private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By appButton = By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div[1]/div[2]/div");
    private By dropdownLocator = By.xpath("//*[@id=\":r7:\"]");
    private By dateInputLocator = By.id("TxtAppointmentsSearchDate");
    private By searchButtonLocator = By.xpath("//*[@id=\"AppointmentsSearchButton\"]");
    private By appointmentButtonLocator = By.xpath("//*[@id=\"root\"]/div/div/div[3]/div/div[1]/div/div[2]/table/tbody/tr[1]/td[7]/div/button[1]");
    private By loadingOverlay = By.className("loading-overlay");
    
    public AppointmentsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(50)); 
    }


    public void appointmentBtn() {
        // Click on the appointment button to view details
       
        
        try {
            // Wait for the loading overlay to disappear
            wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingOverlay));
            
            // Once the loading overlay disappears, click the search button
            WebElement appointmentButton = wait.until(ExpectedConditions.elementToBeClickable( appButton ));
            appointmentButton.click();
        } catch (Exception e) {
            // Log or report the exception
            System.out.println("Failed to click search button: " + e.getMessage());
            // You can re-throw the exception if you want the caller to handle it
            // throw e;
        }
    
    }
    public void searchAppointments(String dropdownOption, String date) {
        // Select dropdown option
        WebElement dropdownElement = wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownLocator));
        dropdownElement.sendKeys(dropdownOption);

        // Enter date
        WebElement dateInput = wait.until(ExpectedConditions.visibilityOfElementLocated(dateInputLocator));
        dateInput.sendKeys(date);

        // Click on search button
        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(searchButtonLocator));
        searchButton.click();
    }

    public void viewAppointmentDetails() {
        // Click on the appointment button to view details
        WebElement appointmentButton = wait.until(ExpectedConditions.elementToBeClickable(appointmentButtonLocator));
        appointmentButton.click();
    }


}
