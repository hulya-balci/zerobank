package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSummaryPage {

  @FindBy(xpath = "//a[text()='Savings']")
    public WebElement savings1;

    @FindBy(xpath = "//a[text()='Savings']")
    public WebElement savings2;


   public AccountSummaryPage() {
    PageFactory.initElements(Driver.get(), this);
  }

}
