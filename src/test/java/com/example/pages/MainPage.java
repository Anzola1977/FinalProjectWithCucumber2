package com.example.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends BasePage {
    public MainPage() {
    }

    @FindBy(xpath = "//*[@class='btn m-1'][text()='Filter']")
    public WebElement filter;

    @FindBy(xpath = "//*[@class='input input-bordered input-secondary w-full max-w-xs']")
    public WebElement newTaskInput;

    @FindBy(xpath = "//*[@class='input input-bordered input-secondary w-full max-w-xs schedule-date']")
    public WebElement dateTaskInput;

    @FindBy(xpath = "//*[@class='todo-item'][last()]/td[2]")
    public WebElement dateOfLastTask;

    @FindBy(xpath = "//*[@class='todo-item']")
    public List<WebElement> listOfTasks;

    @FindBy(xpath = "//*[@class='todo-item'][last()]/td[3]")
    public WebElement statusOfLastTask;

    @FindBy(xpath = "//*[@class='todo-item'][last()]/td[1]")
    public WebElement nameOfLastTask;

    @FindBy(xpath = "//*[@class='btn btn-secondary add-task-button']")
    public WebElement submitButton;

    @FindBy(xpath = "//*[@class='btn btn-warning btn-sm']")
    public WebElement changeButton;

    @FindBy(xpath = "//*[@class='btn btn-success btn-sm']")
    public WebElement completeButton;

    @FindBy(xpath = "//*[@class='btn btn-error btn-sm']")
    public WebElement trashButton;

    @FindBy(xpath = "//*[@class='btn btn-secondary delete-all-btn']")
    public WebElement deleteButton;

    @FindBy(xpath = "//*[@class='dropdown-content menu p-2 shadow bg-base-100 rounded-box w-52']//a[text()='Completed']")
    public WebElement filterByCompleted;

@FindBy(xpath = "//div[@class='alert alert-error shadow-lg mb-5 w-full']//span")
    public WebElement errorMessage;

    @FindBy(xpath = "//div[@class='alert alert-success shadow-lg mb-5 w-full']//span")
    public WebElement successMessage;
}
