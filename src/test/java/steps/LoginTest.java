package steps;

import io.cucumber.java.en.*;
import org.apache.log4j.Logger;
import org.junit.Assert;
import pages.StudyMateLoginPage;
import utilities.AppFlow;
import utilities.Config;
import utilities.Driver;
import utilities.PasswordEncryptDecryptor;

public class LoginTest {
    final static Logger logger = Logger.getLogger(LoginTest.class);

    public static void main(String[] args) {
        logger.info("test log");
    }
    PasswordEncryptDecryptor passwordEncryptDecryptor = new PasswordEncryptDecryptor();
    StudyMateLoginPage studyMateLoginPage = new StudyMateLoginPage();


    @Given("user is on login page")
    public void user_is_on_login_page() {

        Driver.getDriver().get(Config.getValue("studymateUrl"));
        Assert.assertEquals("StudyMate", Driver.getDriver().getTitle());
        logger.info("User: "+Config.getValue("loginStudymate")+" is on login page");

    }
    @When("user enters email {string}")
    public void user_enters_email(String email) {
        studyMateLoginPage.emailInput.sendKeys(email);

    }
    @When("user enters password {string}")
    public void user_enters_password(String password) {
        studyMateLoginPage.passwordInput.sendKeys(password);

    }
    @Then("user clicks on login button")
    public void user_clicks_on_login_button() {
        studyMateLoginPage.loginBtn.click();

    }
    @Then("user must be logged in")
    public void user_must_be_logged_in() {
        AppFlow.pause(3000);
        String expectedUrl = "https://codewise.studymate.us/admin/analytics";
        Assert.assertEquals(expectedUrl, Driver.getDriver().getCurrentUrl());


    }

    @When("user enters correct email")
    public void userEntersCorrectEmail() {
        studyMateLoginPage.emailInput.sendKeys(Config.getValue("loginStudymate"));
        logger.warn("This is my warn");
        logger.error("error happened!");

    }

    @And("user enters correct password")
    public void userEntersCorrectPassword() {
        studyMateLoginPage.passwordInput.sendKeys(PasswordEncryptDecryptor.decryptPassword(Config.getValue("passwordStudymate")));


    }


}
