package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
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

public class Add_Review_On_Products_Steps {

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

    @Then("I should be on the ALL PRODUCTS page")
    public void i_should_be_on_the_all_products_page() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("Automation Exercise - All Products"));
        assertTrue(driver.getTitle().contains("Automation Exercise - All Products"));
    }

    @When("I click on view product link for product {string}")
    public void i_click_on_view_product_link_for_product_on_the_page(String productNumber) {
        WebElement viewProductLink = driver.findElement(By.xpath("//a[contains(@href, '/product_details/" + productNumber + "')]"));
        viewProductLink.click();
    }

    @And("I enter my name, email, and review")
    public void i_enter_my_name_email_and_review() {
        String reviewText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse ut mauris turpis. " +
                "Etiam ut cursus erat, a faucibus nibh. In iaculis dui vel suscipit facilisis. Duis consectetur " +
                "egestas vehicula. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam erat volutpat. " +
                "Suspendisse nec orci mattis leo tincidunt congue quis vel turpis.";

        WebElement nameField = driver.findElement(By.id("name"));
        nameField.sendKeys("Test User");

        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys("test_user@testing.com");

        WebElement reviewField = driver.findElement(By.id("review"));
        reviewField.sendKeys(reviewText);
    }
}
