package com.example.steps;

import com.example.pages.MainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class DeleteTaskSteps {

    @And("user clicks delete button")
    public void clicksClearButton() {
        new MainPage().deleteButton.click();
    }

    @When("user clicks a trash icon in the task field")
    public void userClicksATrashIconInTheTaskField() {
        new MainPage().trashButton.click();
    }
}
