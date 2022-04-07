package stepDefinitions;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import static org.junit.Assert.*;

public class SampleSteps {
    private WebDriver driver;

    public SampleSteps() {
        this.driver = Hooks.driver;
    }

    @Given("^I am on the home page$")
    public void iAmOnTheHomePage() throws Throwable {
        driver.get("https://kristinek.github.io/site");
    }

    @Then("^I should see home page header$")
    public void iShouldSeeHomePageHeader() throws Throwable {
        assertEquals("This is a home page",
                driver.findElement(By.cssSelector("h1")).getText());
    }

    @And("^I should see home page description$")
    public void iShouldSeeHomePageDescription() throws Throwable {
        assertEquals("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                driver.findElement(By.cssSelector("p")).getText());
    }

    @When("^I enter name: \"([^\"]*)\"$")
    public void iEnterName(String name) throws Throwable {
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(name);
    }

    @And("^I enter age: (\\d+)$")
    public void iEnterAge(int age) throws Throwable {
        driver.findElement(By.id("age")).sendKeys(String.valueOf(age));
    }

    @Given("^I (?:am on|open) age page$")
    public void iAmOnAgePage() throws Throwable {
        driver.get("https://kristinek.github.io/site/examples/age");
    }

    @And("^I click submit age$")
    public void iClickSubmitAge() throws Throwable {
        driver.findElement(By.id("submit")).click();
    }

    @Then("^I see message: \"([^\"]*)\"$")
    public void iSeeMessage(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.id("message")).getText());
    }

    @When("^I enter values:$")
    public void iEnterValues(Map<String, String> valuesToEnter) throws Throwable {
        for (Map.Entry<String, String> e : valuesToEnter.entrySet()) {
            driver.findElement(By.id(e.getKey())).clear();
            driver.findElement(By.id(e.getKey())).sendKeys(e.getValue());
            System.out.println("key is " + e.getKey());
            System.out.println("value is " + e.getValue());
        }
    }

    @And("^I should see menu$")
    public void iShouldSeeMenu() throws Throwable {
        assertTrue(driver.findElement(By.className("w3-navbar")).isDisplayed());
    }

    @And("^I click the result checkbox button$")
    public void iClickTheResultCheckboxButton() throws Throwable {
        driver.findElement(By.id("result_button_checkbox")).click();
    }

    @When("^I clicked on checkboxes:$")
    public void iClickedOnCheckboxes(List<String> values) throws Throwable {
        for (String value : values) {
            driver.findElement(By.cssSelector("[value='" + value + "']")).click();
        }
    }

    @Then("^message for checkboxes \"([^\"]*)\" is seen$")
    public void messageForCheckboxesIsSeen(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.id("result_checkbox")).getText());
    }

    @Given("^I am on action page$")
    public void iAmOnActionPage() {
        driver.get("https://kristinek.github.io/site/examples/actions");
    }


    // Sample 1
    @Given("^I am on the locators page$")
    public void iAmOnTheLocatorsPage() throws Throwable {
        driver.get("https://kristinek.github.io/site/examples/locators");
    }

    @Then("^I should see both locators page headers$")
    public void iShouldSeeBothHeaders() throws Throwable {
        assertEquals("Heading 1",
                driver.findElement(By.id("heading_1")).getText());
        assertEquals("Heading 2 text",
                driver.findElement(By.id("heading_2")).getText());
    }

    @And("^Buttons in Locators page are clickable$")
    public void buttonsAreClickable() throws Throwable {
        assertTrue(driver.findElement(By.name("randomButton1")).isEnabled());
        assertTrue(driver.findElement(By.name("randomButton2")).isEnabled());
    }

    //Sample2

    //  @Then("^I see error: \"You haven't entered anything in age field\"")
    //  public void iSeeError() throws Throwable {
    //      assertEquals("You haven't entered anything in age field",
    //              driver.findElement(By.id("error")).getText());

    //  }

    @Then("^I see error: \"([^\"]*)\"$")
    public void iSeeError(String message) throws Throwable {
        assertEquals(message,
                driver.findElement(By.id("error")).getText());
    }

    @And("^I am not navigated to age message page$")
    public void notNavigatedToAgePage() throws Throwable {

        assertFalse(driver.getCurrentUrl().contains("https://kristinek.github.io/site/examples/age_2.html"));

    }

    //Sample 3
    @Given("^I am on feedback page$")
    public void iAmOnTheFeedbackPage() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/provide_feedback");
    }

    @When("^I set name on feedback page: \"([^\"]*)\"$")
    public void iSetNameFeedbackPage(String name) throws Throwable {
        driver.findElement(By.id("fb_name")).sendKeys(name);
    }

    @And("^I set age on feedback page: ([^\"]*)$")
    public void iSetAgeFeedbackPage(String age) throws Throwable {
        driver.findElement(By.id("fb_age")).sendKeys(age);
    }

    @And("^I click Send button on feedback page$")
    public void iClickSend() throws Throwable {
        driver.findElement(By.className("w3-btn-block")).click();
    }

    @Then("^I verify name: \"([^\"]*)\"$")
    public void iVerifyName(String name) throws Throwable {
        assertEquals(name, driver.findElement(By.id("name")).getText());
    }

    @And("^I verify age: ([^\"]*)$")
    public void iVerifyAge(String age) throws Throwable {
        assertEquals(age, driver.findElement(By.id("age")).getText());
    }

    //Task 1
    @Given("^I am on Number page$")
    public void iAmOnNumberPage() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }

    @When("^I enter number: ([^\"]*)$")
    public void iEnterNumberOnNumberPage(String number) throws Throwable {
        driver.findElement(By.id("numb")).sendKeys(number);
    }

    @And("^I click Submit button$")
    public void iClickSubmit() throws Throwable {
        driver.findElement(By.className("w3-btn")).click();
    }

    @Then("^I see error message$")
    public void iVerifyMessage() throws Throwable {
        assertTrue(driver.findElement(By.id("ch1_error")).isDisplayed());

    }

    @Then("^I see alert message with square root of ([^\"]*)$")
    public void iSeeSquareRoot(String number) throws Throwable {
        System.out.println(Double.parseDouble(number));
        driver.switchTo().alert().getText();
        String root = String.format(Locale.ENGLISH, "%.2f", Math.sqrt(Double.parseDouble(number)));
        assertEquals("Square root of " + number + " is " + root, driver.switchTo().alert().getText());
    }

    @And("^I close alert message$")
    public void iCloseAlert() throws Throwable {
        driver.switchTo().alert().accept();
    }

//Sample 4

    @When("^I select feedback languages$")
    public void iSelectFeedbackLanguages(List<String> languages) throws Throwable {
        for (String language : languages) {
            driver.findElement(By.xpath("//input[@class='w3-check' and @value='" + language + "']")).click();
        }
    }

    @Then("^I can see languages \"([^\"]*)\" in feedback check$")
    public void iSeeLanguagesInFeedbackCheck(String languages) throws Throwable {
        assertEquals(languages, driver.findElement(By.id("language")).getText());
    }


//Sample 5

    @When("^I enter Name, Age and Genre:$")
    public void iEnterNameAgeGenreInFeedback(Map<String, String> feedbackInput) throws Throwable {
        if (feedbackInput.containsKey("name")) {
            iSetNameFeedbackPage(feedbackInput.get("name"));
        }
        iSetAgeFeedbackPage(feedbackInput.get("age"));
        driver.findElement(By.xpath("//input[@value='" + feedbackInput.get("genre") + "']")).click();
    }

    @And("^I verify genre: \"([^\"]*)\"$")
    public void iVerifyGenre(String genre) throws Throwable {
        assertEquals(genre, driver.findElement(By.id("gender")).getText());
    }

    @When("^I enter Name, Age and Genre as table:$")
    public void iEnterDataAsTable(DataTable inputTable) throws Throwable {
        for (Map<String, String> feedbackInput : inputTable.asMaps(String.class, String.class)) {
            if (feedbackInput.containsKey("name")) {
                iSetNameFeedbackPage(feedbackInput.get("name"));
            }
            iSetAgeFeedbackPage(feedbackInput.get("age"));
            driver.findElement(By.xpath("//input[@value='" + feedbackInput.get("genre") + "']")).click();
        }
    }
}
