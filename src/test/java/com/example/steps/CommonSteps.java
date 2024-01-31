package com.example.steps;

import com.example.context.Context;
import com.example.pages.MainPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CommonSteps {

    @Given("user enter main page")
    public void user_enter_main_page() {
        Context.scenario.log("User entered main page");
    }

    @Given("user enter internal page")
    public void userEnterInternalPage() {
        Context.scenario.log("User entered internal page");
    }

    @When("enters task {string} and presses Enter key")
    public void user_enters_task(String string) {
        MainPage mainPage = new MainPage();
        mainPage.newTaskInput.sendKeys(string, Keys.ENTER);
    }

    @When("user clicks this task")
    public void user_clicks_this_task() {
        new MainPage().listOfTasks.getFirst().click();
    }

    @Then("user's task is added to his task list")
    public void user_s_task_is_added_to_his_task_list_last() {
        Context.wait.until(ExpectedConditions.visibilityOfAllElements(new MainPage().listOfTasks));
        assertTrue(new MainPage().successMessage.isDisplayed());
        assertEquals(1, new MainPage().listOfTasks.size());
    }

    @Then("a task is deleted")
    public void aMarkedTaskIsDeleted() {
        assertTrue(new MainPage().listOfTasks.isEmpty());
    }

    @And("enters following tasks")
    public void entersFollowingTasks(DataTable dataTable) {
        MainPage mainPage = new MainPage();
        List<Map<String, String>> newTaskList = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> eachTask : newTaskList) {
            String task = eachTask.get("task");
            mainPage.newTaskInput.sendKeys(task);
            mainPage.submitButton.click();
        }
    }

    @When("user clicks complete button in the first {int} tasks")
    public void userClicksCompleteButtonInTheFirstThreeTasks(Integer times) {
        MainPage mainPage = new MainPage();
        for (int i = 0; i < times; i++) {
            mainPage.completeButtonList.get(i).click();
        }
    }

    @When("user enters tasks {string} and date {string}")
    public void user_enters_tasks(String task, String date) {
        MainPage mainPage = new MainPage();
        mainPage.newTaskInput.sendKeys(task);
        mainPage.dateTaskInput.sendKeys(date);
    }

    @When("clicks submit button")
    public void clicks_submit_button() {
        new MainPage().submitButton.click();
    }
}
