package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
            PageFactory.initElements(Driver.get(),this);
        }




        @FindBy(id = "user_login")
        public WebElement loginInput;

        @FindBy(id = "user_password")
        public WebElement passwordInput;

        @FindBy(xpath = "//input[@type='submit']")
        public WebElement loginBtn;

        @FindBy(xpath = "//*[@id=\"login_form\"]/div[1]")
        public WebElement errorMsg;


        public void login(String username,String password){
           loginInput.sendKeys(username);
            passwordInput.sendKeys(password);
            loginBtn.click();
        }





    }
