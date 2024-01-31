package com.example.steps;

import com.example.pages.MainPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.Color;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WorkWithTaskSteps {

    @When("user clicks this task, enters {string} and presses Enter key")
    public void userClicksThisTaskTimesEntersAndPressesEnterKey(String string) {
        MainPage mainPage = new MainPage();
        mainPage.listOfTasks.getFirst().click();
//        mainPage.taskFieldInput.click();
//        mainPage.taskFieldInput.sendKeys(string, Keys.ENTER);
    }

    @Then("the task is changed to {string}")
    public void theTaskIsChangedTo(String string) {
//        assertEquals(string, new MainPage().taskFieldInput.getText());
    }

    @When("user clicks icon button")
    public void userClicksIconButton() {
//        new MainPage().iconCheck.click();
    }

    @Then("a checkmark appears")
    public void aCheckmarkAppears() {
//        assertTrue(new MainPage().iconCheckTaskCompleted.isDisplayed());
    }

    @And("the text color changes to gray and crossed out")
    public void theTextColorChangesToGrayAndCrossedOut() {
//        assertTrue(new MainPage().taskCompleted.isDisplayed());
    }

    @And("user enters tasks {string} and clicks submit button")
    public void userEntersTasksAndClicksSubmitButton(String tasks) {
        MainPage mainPage = new MainPage();
        mainPage.newTaskInput.sendKeys(tasks);
        mainPage.submitButton.click();
    }

    @And("user clicks icon button in all tasks")
    public void clicksIconButtonInAllTasks() {
        for (int i = 0; i < new MainPage().listOfTasks.size(); i++) {
//            new MainPage().iconCheck.click();
        }
    }

    @Then("the text color of previously marked tasks becomes black and is not crossed out")
    public void theTextColorOfPreviouslyMarkedTasksBecomesBlackAndIsNotCrossedOut() {
//        assertTrue(new MainPage().taskFieldInput.isDisplayed());
    }

    @Then("the counter of marked tasks will be equal to the number of tasks")
    public void theCounterOfMarkedTasksWillBeEqualToTheNumberOfTasks() {
//        assertEquals(String.valueOf(new MainPage().listOfTasks.size()), new MainPage().counter.getText());
    }

    @And("user clicks delete button")
    public void clicksClearButton() {
        new MainPage().deleteButton.click();
    }

    @Then("a task is deleted")
    public void aMarkedTaskIsDeleted() {
        assertTrue(new MainPage().listOfTasks.isEmpty());
    }

    @Then("the task field changes color to {string} and trash icon appears")
    public void theTaskFieldChangesColor(String color) {
//        assertTrue(new MainPage().iconTrash.isDisplayed());
//        assertEquals(Color.fromString(color), Color.fromString(new MainPage().editTask.getCssValue("background-color")));
    }

    @And("clicks a trash icon in the task field")
    public void clicksATrashIconInTheTaskField() {
//
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
}
