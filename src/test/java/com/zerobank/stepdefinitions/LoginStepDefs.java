package com.zerobank.stepdefinitions;

import com.zerobank.pages.BasePage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {


    @Given("Users should be able to login to the application")
    public void users_should_be_able_to_login_to_the_application() {
        String url=ConfigurationReader.get("url");
        Driver.get().get(url);
    }


    @When("Users login with valid username and password")
    public void users_login_with_valid_username_and_password() {

        LoginPage loginPage=new LoginPage();
       new BasePage().signBtn.click();

        String username= ConfigurationReader.get("username");
        String password=ConfigurationReader.get("password");

        loginPage.login(username,password);



    }
    @Then("Account summary page should be displayed")
    public void account_summary_page_should_be_displayed() {
        BrowserUtils.waitFor(1);
        String actualTitle=Driver.get().getTitle();
        String expectedTitle="Account Summary";

        Assert.assertTrue(actualTitle.contains(expectedTitle));
        System.out.println("expectedTitle = " + expectedTitle);
        System.out.println("actualTitle = " + actualTitle);




    }

    @When("Users login with not valid {string} and {string}")
    public void users_login_with_not_valid_and(String actualUsername, String actualPassword) {

        LoginPage loginPage=new LoginPage();
        new BasePage().signBtn.click();


        loginPage.login(actualUsername,actualPassword);

    }

    @Then("Error message {string} display")
    public void error_message_display(String expectedMsg) {

        String actualMsg=new LoginPage().errorMsg.getText();

        System.out.println("actualMsg = " + actualMsg);
        System.out.println("expectedMsg = " + expectedMsg);
        Assert.assertEquals(expectedMsg,actualMsg);




    }





}
