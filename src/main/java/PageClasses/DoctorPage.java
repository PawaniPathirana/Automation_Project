package PageClasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DoctorPage {
	
	 private WebDriver driver;
	    private WebDriverWait wait;

	    // Locators
	    private By selectBranchDropdown = By.xpath("//*[@id=\"DrpBranch\"]");
	    private By searchInput = By.xpath("//*[@id=\":r8:\"]");
	    private By searchButton = By.id("DoctorBranchSearchButton");
	    

	    // Constructor
	    public DoctorPage(WebDriver driver) {
	        this.driver = driver;
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    }

	    // Method to select branch from dropdown
	    public void selectBranch(String branch) {
	        WebElement selectBranch = wait.until(ExpectedConditions.visibilityOfElementLocated(selectBranchDropdown));
	        selectBranch.sendKeys(branch);
	    }

	    // Method to enter doctor name in search input
	    public void enterDoctorName(String doctorName) {
	        WebElement input = driver.findElement(searchInput);
	        input.sendKeys(doctorName);
	    }

	    // Method to click on the search button
	    public void clickSearchButton() {
	        WebElement button = driver.findElement(searchButton);
	        button.click();
	    }

	    // Method to perform doctor search
	    public void searchDoctor(String branch, String doctorName) {
	        selectBranch(branch);
	        enterDoctorName(doctorName);
	        clickSearchButton();
	    }
	}


