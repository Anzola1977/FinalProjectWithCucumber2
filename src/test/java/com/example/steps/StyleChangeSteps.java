package com.example.steps;

import com.example.context.Context;
import com.example.pages.InternalPage;
import com.example.pages.MainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StyleChangeSteps {

    @Given("user enter internal page")
    public void userEnterInternalPage() {
        Context.scenario.log("User entered internal page");
    }

    @When("user clicks palette button")
    public void userClicksPaletteButton() {
        new InternalPage().palette.click();
    }

    @And("clicks style change to bumblebee")
    public void clicksStyleChangeToBumblebee() {
        new InternalPage().styleBumblebee.click();
    }

    @Then("theme of internal page is changed")
    public void colorOfInternalPageIsChanged() {
        assertTrue(new InternalPage().nameOfTheme.isEnabled());
    }

    @When("user clicks to author link")
    public void userClicksToAuthorLink() {
        new InternalPage().authorLink.click();

    }

    @Then("user goes to the author's page")
    public void userGoesToTheAuthorSPage() {
        Context.wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        for (String windowHandle : Context.getDriver().getWindowHandles()) {
            Context.getDriver().switchTo().window(windowHandle);
        }
        assertEquals("https://github.com/abdellatif-laghjaj", Context.getDriver().getCurrentUrl());
    }
}
