package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WebDriverSingleton;

public class Register_User_With_Existing_Email_Steps {

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

    @When("I enter a name and an already registered email address")
    public void i_enter_a_name_and_an_already_registered_email_address() {
        WebElement nameField = driver.findElement(By.cssSelector("[data-qa='signup-name']"));
        nameField.sendKeys("tester");

        WebElement emailField = driver.findElement(By.cssSelector("[data-qa='signup-email']"));
        emailField.sendKeys("testing123@testing.com");
    }
}
