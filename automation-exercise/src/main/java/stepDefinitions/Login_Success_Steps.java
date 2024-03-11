package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WebDriverSingleton;

public class Login_Success_Steps {
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

    @When("I enter correct email address and password")
    public void i_enter_correct_email_address_and_password() {
        WebElement emailField = driver.findElement(By.cssSelector("[data-qa='login-email']"));
        emailField.sendKeys("testing123@testing.com");

        WebElement passwordField = driver.findElement(By.cssSelector("[data-qa='login-password']"));
        passwordField.sendKeys("password");
    }
}
