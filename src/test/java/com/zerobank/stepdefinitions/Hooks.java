package com.zerobank.stepdefinitions;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public void setUp(){
        String url= ConfigurationReader.get("url");
        Driver.get().get(url);
    }

    @After
    public void tearDown(Scenario scenario) throws InterruptedException {
        if(scenario.isFailed()){
            final byte[] screenshot=((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");
            //for taking screenshot run with maven verify
        }
        Thread.sleep(2000);
        Driver.closeDriver();

    }

    @Before("@database")
    public void setUpDB(){
        System.out.println("This is  connecting to database");
    }

    @After("@database")
    public void tearDownDB(){
        System.out.println("This is  disconnecting from database");
    }


}

