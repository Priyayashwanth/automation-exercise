package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebDriverSingleton;

import java.io.File;
import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class Contact_Us_Steps {

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

    @When("I enter name, email, subject, and message")
    public void i_enter_name_email_subject_and_message() {
        WebElement nameField = driver.findElement(By.cssSelector("[data-qa='name']"));
        nameField.sendKeys("Test User");

        WebElement emailField = driver.findElement(By.cssSelector("[data-qa='email']"));
        emailField.sendKeys("test_user@testing.com");

        WebElement subjectField = driver.findElement(By.cssSelector("[data-qa='subject']"));
        subjectField.sendKeys("Automation Testing");

        WebElement messageField = driver.findElement(By.cssSelector("[data-qa='message']"));
        messageField.sendKeys("Testing Contact Us Form using automation.");
    }

    @And("I upload a file")
    public void i_upload_a_file() {
        WebElement fileInput = driver.findElement(By.name("upload_file"));
        String filePath = new File("src/main/resources/dummy.txt").getAbsolutePath();
        fileInput.sendKeys(filePath);
    }

    @Then("I verify that the success message {string} is visible")
    public void i_verify_that_the_success_message_is_visible(String message) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), '" + message + "')]")));
        assertTrue(successMessage.isDisplayed());
    }

    @And("I click on {string}")
    public void i_click_on(String buttonText) {
        WebElement button = driver.findElement(By.cssSelector("[data-qa='" + buttonText + "']"));
        button.click();
    }

    @And("I click on OK from the alert")
    public void i_click_on_OK_from_the_alert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
}
