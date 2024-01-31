package com.example.steps;

import com.example.pages.MainPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WorkWithTaskSteps {

    @Then("the task is changed to {string}")
    public void theTaskIsChangedTo(String string) {
        assertEquals(string, new MainPage().nameOfLastTask.getText());
    }

    @And("user enters tasks {string} and clicks submit button")
    public void userEntersTasksAndClicksSubmitButton(String tasks) {
        MainPage mainPage = new MainPage();
        mainPage.newTaskInput.sendKeys(tasks);
        mainPage.submitButton.click();
    }

    @And("user clicks delete button")
    public void clicksClearButton() {
        new MainPage().deleteButton.click();
    }

    @Then("a task is deleted")
    public void aMarkedTaskIsDeleted() {
        assertTrue(new MainPage().listOfTasks.isEmpty());
    }

    @When("user clicks a trash icon in the task field")
    public void userClicksATrashIconInTheTaskField() {
        new MainPage().trashButton.click();
    }

    @And("enters following tasks and dates")
    public void entersFollowingTasksAndDates(DataTable dataTable) {
        MainPage mainPage = new MainPage();
        List<Map<String, String>> newTaskList = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> eachTask : newTaskList){
            String task = eachTask.get("tasks");
            mainPage.newTaskInput.sendKeys(task);
            String date = eachTask.get("dates");
            mainPage.dateTaskInput.sendKeys(date);
            mainPage.submitButton.click();
        }
    }

    @When("user clicks change button")
    public void userClicksChangeButton() {
        new MainPage().changeButton.click();
    }

    @When("user clicks complete button")
    public void userClicksCompleteButton() {
        new MainPage().completeButtonList.getLast().click();
    }

    @Then("a status of the task is changed to completed")
    public void aStatusOfTheTaskIsChangedToCompleted() {
        assertEquals("Completed", new MainPage().statusOfLastTask.getText());
    }

    @And("enters following tasks")
    public void entersFollowingTasks(DataTable dataTable) {
        MainPage mainPage = new MainPage();
        List<Map<String, String>> newTaskList = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> eachTask : newTaskList){
            String task = eachTask.get("task");
            mainPage.newTaskInput.sendKeys(task);
            mainPage.submitButton.click();
        }
    }

    @Then("a status of tasks are changed to completed")
    public void aStatusOfTasksAreChangedToCompleted() {
        assertEquals(3, new MainPage().completedStatusOfTask.size());
    }

    @When("user clicks complete button in the first {int} tasks")
    public void userClicksCompleteButtonInTheFirstThreeTasks(Integer times) {
        MainPage mainPage = new MainPage();
        for (int i = 0; i < times; i++) {
            mainPage.completeButtonList.get(i).click();
        }
    }

    @When("user clicks a filter button and select completed")
    public void userClicksAFilterButtonAndSelect() {
        MainPage mainPage = new MainPage();
        mainPage.filter.click();
        mainPage.filterByCompleted.click();
    }

    @Then("Only completed tasks will be displayed")
    public void onlyCompletedTasksWillBeDisplayed() {
        assertEquals(new MainPage().listOfTasks.size(), new MainPage().completedStatusOfTask.size());
    }
}
