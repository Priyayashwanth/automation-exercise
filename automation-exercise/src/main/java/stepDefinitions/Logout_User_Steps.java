package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import utils.WebDriverSingleton;

import static org.testng.Assert.assertTrue;

public class Logout_User_Steps {

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

    @Then("I verify that the user is navigated to the login page")
    public void i_verify_that_the_user_is_navigated_to_the_login_page() {
        assertTrue(driver.getTitle().contains("Automation Exercise - Signup / Login"));
    }
}
