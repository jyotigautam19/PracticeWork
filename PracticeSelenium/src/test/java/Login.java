import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Login {
     private WebDriver driver;

     @Given("the user is on stackflow homepage")
     public void the_user_is_on_stackflow_homepage() {
          System.setProperty("webdriver.chrome.driver","./src/Resources/chromedriver");
          driver = new ChromeDriver();
          driver.navigate().to("https://stackoverflow.com");
     }
     @When("the user clicks on the Login button in the top navigation")
     public void the_user_clicks_on_the_login_button_in_the_top_navigation() {
          driver.findElement(By.className("login-link")).click();
     }
     @When("user enters email as {string} and password as {string}")
     public void user_enters_email_as_and_password_as(String email, String pass) {
          driver.findElement(By.id("email")).sendKeys(email);
          driver.findElement(By.id("password")).sendKeys(pass);
     }
     @When("user clicks Log in")
     public void user_clicks() {
         driver.findElement(By.id("submit-button")).submit();
         driver.findElement(By.xpath("/html/body/div[4]/div/button[1]")).click();
     }
     @Then("the user is navigated to the correct page")
     public void the_user_is_navigated_to_the_correct_page() {
        WebElement page = driver.findElement(By.id("mainbar"));
        Boolean expected = page.getText().contains("Top Questions");
        Assert.assertTrue("Text Not there",expected);
        driver.quit();

     }


}
