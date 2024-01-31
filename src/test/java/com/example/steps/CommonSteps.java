package com.example.steps;

import com.example.context.Context;
import com.example.pages.MainPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CommonSteps {
        @Given("user enter main page")
        public void user_enter_main_page() {
            Context.scenario.log("User entered main page");
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
}
