package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;

public class TaskSteps {
    private WebDriver driver;

    public TaskSteps() {
        this.driver = Hooks.driver;
    }

    @Given("^I am on People with jobs page$")
    public void iAmOnThePeoplePage() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/list_of_people_with_jobs.html");
    }

    @When("^I click Add person button$")
    public void iClickAddPerson() throws Throwable {
        driver.findElement(By.xpath("//*[text()='Add person']")).click();
    }

    @And("^I set name on Add page: \"([^\"]*)\"$")
    public void iSetNamePeoplePage(String name) throws Throwable {
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(name);
    }

    @And("^I set job on Add page: \"([^\"]*)\"$")
    public void iSetJobPeoplePage(String job) throws Throwable {
        driver.findElement(By.id("job")).clear();
        driver.findElement(By.id("job")).sendKeys(job);
    }

    @Then("^I click Add button$")
    public void iClickAddButton() throws Throwable {
        driver.findElement(By.xpath("//*[text()='Add']")).click();
    }

    @Then("^I check new person added with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iCheckNewPersonAdded(String name, String job) throws Throwable {
        assertEquals(name, driver.findElement(By.xpath("//*[text()='" + name + "']")).getText());
        assertEquals(job, driver.findElement(By.xpath("//*[text()='" + job + "']")).getText());
    }

    @Then("^I reset list$")
    public void iResetList() throws Throwable {
        driver.findElement(By.xpath("//*[text()='Reset List']")).click();
    }

    @Then("^I click Edit person button$")
    public void iClickEditButton(Map<String, String> name) throws Throwable {
        System.out.println(name.get("name"));
        int i = 0;
        List<WebElement> nameElements = driver.findElements(By.className("name"));
        for (WebElement nameElement : nameElements) {
            if (nameElement.getText().contains(name.get("name"))) {
                driver.findElement(By.xpath("//span[@onclick='openModalForEditPersonWithJob(" + i + ")']")).click();
            }
            i++;
        }
    }

    @And("^I set new name and job on Edit page$")
    public void iSetNameEditPage(Map<String, String> values) throws Throwable {
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(values.get("name"));
        driver.findElement(By.id("job")).clear();
        driver.findElement(By.id("job")).sendKeys(values.get("job"));
    }

    @Then("^I click Edit button$")
    public void iClickEditButton() throws Throwable {
        driver.findElement(By.xpath("//*[text()='Edit']")).click();
    }

    @Then("^I check person data changed$")
    public void iCheckPersonEdited(Map<String, String> values) throws Throwable {
        assertEquals(values.get("name"), driver.findElement(By.xpath("//*[text()='" + values.get("name") + "']")).getText());
        assertEquals(values.get("job"), driver.findElement(By.xpath("//*[text()='" + values.get("job") + "']")).getText());
    }

    @When("^I click Delete person button$")
    public void iClickDeleteButton(List<String> values) throws Throwable {
        int i = 0;
        List<WebElement> nameElements = driver.findElements(By.className("name"));
        for (WebElement nameElement : nameElements) {
            for (String value : values) {
                if (nameElement.getText().contains(value)) {
                    driver.findElement(By.xpath("//span[@onclick='deletePerson(" + i + ")']")).click();
                }
                i++;
            }
        }
    }

    @Then("^I check person is deleted$")
    public void iCheckPersonDeleted(List<String> values) throws Throwable {
        List<WebElement> nameElements = driver.findElements(By.className("name"));
        for (WebElement nameElement : nameElements) {
            for (String value : values) {
                assertNotEquals(value, nameElement.getText());
            }
        }
    }

    @Then("^I click Clear all Fields button$")
    public void iCClickClearButton() throws Throwable {
        driver.findElement(By.xpath("//*[text()='Clear all fields']")).click();
    }

    @Then("^I check all fields are empty$")
    public void iCheckAllFieldsAreEmpty() throws Throwable {
        assertEquals("", driver.findElement(By.id("name")).getText());
        assertEquals("", driver.findElement(By.id("job")).getText());
    }
}