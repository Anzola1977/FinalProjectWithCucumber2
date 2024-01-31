package com.example.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InternalPage extends BasePage{
    public InternalPage() {
    }

    @FindBy(xpath = "//*[@class='bx bxs-palette bx-sm']")
    public WebElement palette;

    @FindBy(xpath = "//div[@class='author-text']//a")
    public WebElement authorLink;

    @FindBy(xpath = "//*[@class='dropdown-content menu p-2 shadow bg-base-100 rounded-box w-52']//a[text()='bumblebee']")
    public WebElement styleBumblebee;

}
