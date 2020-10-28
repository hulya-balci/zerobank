package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.BasePage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.jsoup.Connection;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

public class AccountActivitiyNavigationStepDefs {

    @Given("the user is logged in")
    public void the_user_is_logged_in() {

       new BasePage().signBtn.click();

        String username= ConfigurationReader.get("username");
        String password=ConfigurationReader.get("password");

        new LoginPage().login(username,password);

    }

    @When("the user clicks on Savings link on the Account Summary page")
    public void the_user_clicks_on_Savings_link_on_the_Account_Summary_page() {
        BrowserUtils.waitFor(3);

       AccountSummaryPage accountSummaryPage= new AccountSummaryPage();
       accountSummaryPage.savings1.click();
    }

    @And("Account drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String expectedOption) {

        AccountActivityPage accountActivityPage=new AccountActivityPage();

        Select options=accountActivityPage.AccountList();
        String actualOption =options.getFirstSelectedOption().getText();
             Assert.assertEquals(expectedOption, actualOption);


    }

    @Then("the {string} page should be displayed")
    public void the_page_should_be_displayed(String expectedTitle) {

      String actualTitle=new BasePage().getPageTitle();
     Assert.assertTrue(actualTitle.contains(expectedTitle));
        System.out.println("actualTitle = " + actualTitle);
        System.out.println("expectedTitle = " + expectedTitle);

    }

}
