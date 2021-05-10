package com.bjss.testexample;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BjssSteps {

    private WebDriverManager webDriverManager;
    Actions actions ;

    public BjssSteps(WebDriverManager webDriverManager){
        this.webDriverManager = webDriverManager;
    }

    @Given("^the user is on the BJSS home page$")
    public void navigateToBjss() {
        webDriverManager.start();
        webDriverManager.getDriver().navigate().to("https://www.bjss.com");
    }
    @When("^they click the menu$")
    public void clickMenu() {
        actions = new Actions(webDriverManager.getDriver());
        WebElement aboutMenu = webDriverManager.getDriver().findElement(By.linkText("About BJSS"));
        actions.moveToElement(aboutMenu).perform();
       // driverManager.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        new WebDriverWait(webDriverManager.getDriver(), 5000).until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Our Work")));

    }
    @Then("^the menu is expanded$")
    public void assertMenuExpanded() {
        boolean linkIsDisplayed = webDriverManager.getDriver().findElement(By.linkText("Our Work")).isDisplayed();
        Assert.assertTrue("our work link was not displayed", linkIsDisplayed);
        webDriverManager.stop();
    }

}
