package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebDriverSingleton;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class Test_Cases_Steps {
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

    @Then("I verify that the user is navigated to the test cases page successfully")
    public void i_verify_that_the_user_is_navigated_to_the_test_cases_page_successfully() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("Automation Practice Website for UI Testing - Test Cases"));
        assertTrue(driver.getTitle().contains("Automation Practice Website for UI Testing - Test Cases"));
    }
}
