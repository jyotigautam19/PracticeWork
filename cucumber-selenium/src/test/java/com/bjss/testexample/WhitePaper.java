package com.bjss.testexample;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class WhitePaper {

    private WebDriverManager webDriverManager;

    public WhitePaper(WebDriverManager webDriverManager){
        this.webDriverManager = webDriverManager;
    }


    @When("they click for more information about the BJSS whitepaper")
    public void they_click_for_more_information_about_the_bjss_whitepaper() {
        webDriverManager.getDriver().findElement(By.xpath("//*[@id=\"post-223462\"]/div/div/div/div[1]/div/div[1]/div[2]/a")).click();
    }

    @Then("they are shown more information about the BJSS whitepaper")
    public void they_are_shown_more_information_about_the_bjss_whitepaper() {

    }

}
