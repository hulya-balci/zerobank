package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "signin_button")
    public WebElement signBtn;

    @FindBy(id = "account_summary_tab")
    public WebElement accountSummary;

    @FindBy(id = "account_activity_tab")
    public WebElement accountActivity;

    @FindBy(id = "transfer_funds_tab")
    public WebElement transferFunds;

    @FindBy(id = "pay_bills_tab")
    public WebElement payBills;


    @FindBy(id = "money_map_tab")
    public WebElement myMoneyMap;


    @FindBy(id = "online_statements_tab")
    public WebElement onlineStatements;

    public String getPageTitle(){
       BrowserUtils.waitFor(2000);
        String title=Driver.get().getTitle();
        return title;




    }











}
