package PageClasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SessionPage {
	
	  private WebDriver driver;
	  private WebDriverWait wait;
	
	private By viewSessionsButton = By.xpath("//*[@id=\"root\"]/div/div/div[3]/div/div[1]/div[2]/div/table/tbody/tr[1]/td[5]/div/button[1]");
    private By updatedElement = By.xpath("//*[@id=\"root\"]/div/div/div[3]/div/div[1]");
    private By addSessionButton = By.xpath("//*[@id=\"root\"]/div/div/div[3]/div/div[1]/div[2]/div/table/tbody/tr[1]/td[5]/div/button[3]");
    private By dropdownIDType = By.xpath("/html/body/div[1]/div/div/div[3]/div/div/div/div[3]/div[1]/form/div/div/div[1]/div[3]/div/div");
    private By dropdownSessionType = By.xpath("//*[@id=\"selectSessionType\"]");
    private By dateInput = By.xpath("/html/body/div[1]/div/div/div[3]/div/div/div/div[3]/div[1]/form/div/div/div[1]/div[4]/div/div");
    private By roomNoInput = By.xpath("//*[@id=\"roomNo\"]");
    private By sessionCategoryInput = By.xpath("//*[@id=\"selectSessionType\"]");
    private By startTimeInput = By.xpath("//*[@id=\":rc:\"]");
    private By endTimeInput = By.xpath("//*[@id=\":rd:\"]");
    private By maxNoOfAppointmentsInput = By.xpath("//*[@id=\"maxNoOfAppointments\"]");
    private By noOfReservedAppointmentsInput = By.xpath("//*[@id=\"NoOfReservedAppointments\"]");
    private By saveButton = By.xpath("//*[@id=\"root\"]/div/div/div[3]/div/div/div/div[3]/div/form/div/div/div[4]/div[2]/div/button[1]");
    private By navDocButton = By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div[2]/span[2]");
    private By loadingOverlay = By.className("loading-overlay");

    
  
    
    public SessionPage(WebDriver driver) {
    	
    	this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(50));
	}

    public void navDocButton() {
        
    	 
        try {
           
            wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingOverlay));
            
            
            WebElement pharmacyView = wait.until(ExpectedConditions.elementToBeClickable(navDocButton));
            pharmacyView.click();
            
        } catch (Exception e) {
           
            System.out.println("Failed to click search button: " + e.getMessage());
            
        }
       
    }
	

	public void clickViewSessionsButton() {
       
        WebElement viewSessionsBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(viewSessionsButton));
       
        viewSessionsBtn.click();

        
        wait.until(ExpectedConditions.visibilityOfElementLocated(updatedElement));

       
    }
	
	public void addSession(String branchName, String sessionType, String date, String roomNo, String sessionCategory,
			String startTime, String endTime, String maxAppointments, String reservedAppointments) {
		
		WebElement addSessionBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(addSessionButton));
		addSessionBtn.click();	// Select branch name
		WebElement branchDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownIDType));
		branchDropdown.sendKeys(branchName);

		// Select session type
		WebElement sessionTypeDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownSessionType));
		sessionTypeDropdown.sendKeys(sessionType);

		// Fill in other session details
		WebElement dateInputField = driver.findElement(dateInput);
		dateInputField.sendKeys(date);

		WebElement roomNoInputField = driver.findElement(roomNoInput);
		roomNoInputField.sendKeys(roomNo);

		WebElement sessionCategoryInputField = driver.findElement(sessionCategoryInput);
		sessionCategoryInputField.sendKeys(sessionCategory);

		WebElement startTimeInputField = driver.findElement(startTimeInput);
		startTimeInputField.sendKeys(startTime);

		WebElement endTimeInputField = driver.findElement(endTimeInput);
		endTimeInputField.sendKeys(endTime);

		WebElement maxAppointmentsInputField = driver.findElement(maxNoOfAppointmentsInput);
		maxAppointmentsInputField.sendKeys(maxAppointments);

		WebElement reservedAppointmentsInputField = driver.findElement(noOfReservedAppointmentsInput);
		reservedAppointmentsInputField.sendKeys(reservedAppointments);

		// Click on Save button
		WebElement saveButtonElement = driver.findElement(saveButton);
		saveButtonElement.click();
	}



}
