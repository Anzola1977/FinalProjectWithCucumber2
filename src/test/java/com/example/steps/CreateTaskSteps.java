package com.example.steps;

import com.example.pages.MainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.*;

public class CreateTaskSteps {

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

    @When("user clicks in the task input field")
    public void user_clicks_in_the_task_input_field() {
        new MainPage().newTaskInput.click();
    }

    @When("user inputs task {string} and clicks the submit button {int} times")
    public void user_clicks_the_submit_button_times(String task, Integer times) {
        MainPage mainPage = new MainPage();
        for (int i = 0; i < times; i++) {
            mainPage.newTaskInput.sendKeys(task);
            mainPage.submitButton.click();
        }
    }

    @Then("tasks are added to task list")
    public void empty_tasks_are_added_to_task_list() {
        assertEquals(13, new MainPage().listOfTasks.size());
    }

    @Then("the task input field is no longer available")
    public void the_task_input_field_is_no_longer_available() {
        assertFalse(new MainPage().newTaskInput.isDisplayed());
    }

    @Then("user's task is not added to his task list")
    public void userSTaskIsNotAddedToHisTaskList() {
        assertTrue(new MainPage().listOfTasks.isEmpty());
    }

    @And("an error message appears")
    public void anErrorMessageAppears() {
        assertTrue(new MainPage().errorMessage.isDisplayed());
    }
}

