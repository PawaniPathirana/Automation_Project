package PageClasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BillingPage {
	
	private WebDriver driver;
	  private WebDriverWait wait;
	  
	  private By navDocButton = By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div[2]/span[2]");
	  private By loadingOverlay = By.className("loading-overlay");
	  private By searchBar = By.xpath("//*[@id=\"TxtAppointmentId\"]");
	  private By searchBtn = By.xpath("//*[@id=\"AptSearchButton\"]");
	  private By docButton = By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div[1]/div[3]");
	  
	  
	    public BillingPage(WebDriver driver) {
	    	
	    	this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		}

	  
	  public void navDocButton() {
	        
	              
	        
	        try {
	           
	            wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingOverlay));
	            
	            
	            WebElement billingView = wait.until(ExpectedConditions.elementToBeClickable(searchBtn));
	            billingView.click();
	            
	        } catch (Exception e) {
	           
	            System.out.println("Failed to click search button: " + e.getMessage());
	            
	        }
	       
	    }
	  
	  public void searchBar(String appID) {
	        
          
	        
	        try {
	           
	            wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingOverlay));
	            
	            
	            
	            WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBar));
	            search.sendKeys(appID);
	    		
	        } catch (Exception e) {
	           
	            System.out.println("Failed to click search button: " + e.getMessage());
	            
	        }
	       
	    }
	  public void searchButton() {
	        
          
	        
	        try {
	           
	            wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingOverlay));
	            
	            
	            WebElement billingView = wait.until(ExpectedConditions.elementToBeClickable(navDocButton));
	            billingView.click();
	    		
	        } catch (Exception e) {
	           
	            System.out.println("Failed to click search button: " + e.getMessage());
	            
	        }
	       
	    }
	  public void docNav() {
	        
          
	        
	        try {
	           
	            wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingOverlay));
	            
	            
	            WebElement billingView = wait.until(ExpectedConditions.elementToBeClickable(docButton));
	            billingView.click();
	    		
	        } catch (Exception e) {
	           
	            System.out.println("Failed to click search button: " + e.getMessage());
	            
	        }
	       
	    }

}
