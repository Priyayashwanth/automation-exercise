package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebDriverSingleton;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class Register_User_Steps {
    private WebDriver driver;

    @After
    public void tearDown() {
        WebDriverSingleton.quitDriver();
    }

    @Given("I launch the browser")
    public void i_launch_the_browser() {
        if (driver == null) {
            driver = WebDriverSingleton.getDriver();
        }
    }

    @When("I navigate to url {string}")
    public void i_navigate_to_url(String url) {
        driver.get(url);
    }

    @Then("I verify that the home page is visible successfully")
    public void i_verify_that_the_home_page_is_visible_successfully() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("Automation Exercise"));
        assertTrue(driver.getTitle().contains("Automation Exercise"));
    }

    @And("I click on the {string} button")
    public void i_click_on_the_button(String linkText) {
        WebElement link = driver.findElement(By.partialLinkText(linkText));
        link.click();
    }

    @And("I click the {string} button")
    public void i_click_the_button(String buttonText) {
        WebElement button = driver.findElement(By.xpath("//button[contains(text(), '" + buttonText + "')]"));
        button.click();
    }

    @And("I verify that {string} is visible")
    public void i_verify_that_is_visible(String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), '" + text + "')]")));
        assertTrue(element.isDisplayed());
    }

    @And("I enter the name and email address")
    public void i_enter_the_name_and_email_address() {
        WebElement nameField = driver.findElement(By.cssSelector("[data-qa='signup-name']"));
        nameField.sendKeys("testing");

        WebElement emailField = driver.findElement(By.cssSelector("[data-qa='signup-email']"));
        emailField.sendKeys("test_one@email.com");
    }

    @And("I fill in the details: Title, Password, Date of birth")
    public void i_fill_in_the_details_title_password_date_of_birth() {
        WebElement titleButton = driver.findElement(By.id("id_gender2"));
        titleButton.click();

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("password_for_testing");

        WebElement daySelector = driver.findElement(By.cssSelector("select[data-qa='days']"));
        Select selectDate = new Select(daySelector);
        selectDate.selectByValue("1");

        WebElement monthSelector = driver.findElement(By.cssSelector("select[data-qa='months']"));
        Select selectMonth = new Select(monthSelector);
        selectMonth.selectByValue("1");

        WebElement yearSelector = driver.findElement(By.cssSelector("select[data-qa='years']"));
        Select selectYear = new Select(yearSelector);
        selectYear.selectByValue("2000");
    }

    @And("I select the checkbox {string}")
    public void i_select_the_checkbox(String labelText) {
        WebElement labelElement = driver.findElement(By.xpath("//label[text()='" + labelText + "']"));
        WebElement parentElement = labelElement.findElement(By.xpath("./.."));
        WebElement checkboxElement = parentElement.findElement(By.tagName("input"));
        if (!checkboxElement.isSelected()) {
            checkboxElement.click();
        }
    }

    @And("I fill in the additional details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number")
    public void i_fill_in_the_additional_details_first_name_last_name_company_address_address2_country_state_city_zipcode_mobile_number() {
        WebElement firstNameField = driver.findElement(By.id("first_name"));
        firstNameField.sendKeys("Test");

        WebElement lastNameField = driver.findElement(By.id("last_name"));
        lastNameField.sendKeys("User");

        WebElement companyNameField = driver.findElement(By.id("company"));
        companyNameField.sendKeys("ABC Company");

        WebElement address1Field = driver.findElement(By.id("address1"));
        address1Field.sendKeys("1234 A2Z Road");

        WebElement address2Field = driver.findElement(By.id("address2"));
        address2Field.sendKeys("XYZ Street");

        WebElement countrySelector = driver.findElement(By.cssSelector("select[data-qa='country']"));
        Select selectCountry = new Select(countrySelector);
        selectCountry.selectByVisibleText("United States");

        WebElement stateField = driver.findElement(By.id("state"));
        stateField.sendKeys("KA");

        WebElement cityField = driver.findElement(By.id("city"));
        cityField.sendKeys("XYZ city");

        WebElement zipcodeField = driver.findElement(By.id("zipcode"));
        zipcodeField.sendKeys("123456");

        WebElement mobileNumberField = driver.findElement(By.id("mobile_number"));
        mobileNumberField.sendKeys("9876543210");
    }
}
