package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebDriverSingleton;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class Login_Fail_Steps {

    private WebDriver driver;

    @Before
    public void setUp() {
        if (driver == null) {
            driver = WebDriverSingleton.getDriver();
        }
    }

    @After
    public void tearDown() {
        WebDriverSingleton.quitDriver();
    }

    @When("I enter incorrect email address and password")
    public void i_enter_incorrect_email_address_and_password() {
        WebElement emailField = driver.findElement(By.cssSelector("[data-qa='login-email']"));
        emailField.sendKeys("no_user@testing.com");

        WebElement passwordField = driver.findElement(By.cssSelector("[data-qa='login-password']"));
        passwordField.sendKeys("no_password");
    }

    @Then("I verify that the error message {string} is visible")
    public void i_verify_that_the_error_message_is_visible(String message) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), '" + message + "')]")));
        assertTrue(errorMessage.isDisplayed());
    }
}
