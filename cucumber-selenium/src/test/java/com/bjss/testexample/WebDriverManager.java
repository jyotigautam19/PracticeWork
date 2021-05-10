package com.bjss.testexample;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverManager {
    private WebDriver driver;

    public void start(){
        System.setProperty("webdriver.gecko.driver","./src/Resources/geckodriver");
        driver = new FirefoxDriver();
    }

    public void stop(){
        driver.quit();
    }

    public WebDriver getDriver(){
        return driver;
    }

}
