package PageClasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By usernameInput = By.name("username");
    private By passwordInput = By.xpath("//*[@id=\":r1:\"]");
    private By loginButton = By.xpath("//*[@id=\"root\"]/div/div[1]/form/button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Set an appropriate timeout
    }

    public void login(String username, String password) {
        // Wait for the username input field to be visible
        WebElement usernameInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInput));
        // Enter the username
        usernameInputField.sendKeys(username);

        // Find the password input field
        WebElement passwordInputField = driver.findElement(passwordInput);
        // Enter the password
        passwordInputField.sendKeys(password);

        // Find the login button and click it
        WebElement loginButtonElement = driver.findElement(loginButton);
        loginButtonElement.click();

        // You might want to wait for the login process to complete before returning,
        // for example, by waiting for a specific URL or an element on the next page.
    }



}
