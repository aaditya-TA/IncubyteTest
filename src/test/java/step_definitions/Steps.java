package step_definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObjects.*;
import resources.Base;

import java.io.IOException;
import java.time.Duration;

public class Steps extends Base {



    SignInPage signInPageObj;
    InboxPage inboxPageObj;


    @Given("^Initialize the browser with chrome$")
    public void initializeTheBrowserWithChrome() throws IOException {
        driver = initializeDriver();
    }

    @And("^User navigate to \"([^\"]*)\"$")
    public void userNavigateTo(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.get(arg0);
    }


    @And("^User enters (.+) and (.+)$")
    public void userEntersEmailAndPassword(String email, String password) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        signInPageObj = new SignInPage(driver);
        wait.until(ExpectedConditions.visibilityOf(signInPageObj.emailField));

        //Entering the email
        Assert.assertTrue(signInPageObj.emailField.isDisplayed(), "Email field box is displayed");
        signInPageObj.emailField.sendKeys(email);

        //Clicking on the next and entering the password
        Assert.assertTrue(signInPageObj.nextButton.isDisplayed());
        signInPageObj.nextButton.click();

        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(signInPageObj.passwordField));
        signInPageObj.passwordField.sendKeys(password);


        //Signing in
        signInPageObj.loginBtn.click();

    }


    @And("^User is logged into the system$")
    public void userIsLoggedIntoTheSystem() {
        //Wait for the compose button to be available
        inboxPageObj = new InboxPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(inboxPageObj.composeBtn));
        Assert.assertTrue(inboxPageObj.composeBtn.isDisplayed());

    }

    @When("^User click on compose button$")
    public void userClickOnComposeButton() {
        //clicking on the compose button
        inboxPageObj.composeBtn.click();
    }

    @Then("^The new message section should be available where the required fields are present$")
    public void theNewMessageSectionShouldBeAvailableWhereTheRequiredFieldsArePresent() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(inboxPageObj.newMessageSection));

        //Verifying  the section and the fields
        Assert.assertTrue(inboxPageObj.newMessageSection.isDisplayed());
        Assert.assertTrue(inboxPageObj.subjectField.isDisplayed(), "Subject field is displayed");
        Assert.assertTrue(inboxPageObj.bodyField.isDisplayed());
    }


    @When("^User enters (.+) In recipients section$")
    public void userEntersToEmailInRecipientsSection(String To_Email) {

        //Entering the email in to section
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", inboxPageObj.recipientsField);
        inboxPageObj.to.sendKeys(To_Email);
    }


    @And("^enters (.+) in Subject section$")
    public void entersSubjectInSubjectSection(String subject) {
        //Entering the subject
        inboxPageObj.subjectField.sendKeys(subject);
    }


    @And("^enters (.+) in Body section and clicks on the send button$")
    public void entersBodyInBodySection(String body) {
        //clicking on the send button
        inboxPageObj.bodyField.sendKeys(body);
        inboxPageObj.sendBtn.click();
    }


    @Then("^Message is sent$")
    public void messageIsSent() throws InterruptedException {
        //verifying that the message is sent
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(inboxPageObj.sentMsgTxt));
        Assert.assertTrue(inboxPageObj.sentMsgTxt.isDisplayed());
    }


    @And("^User closes the browser$")
    public void userClosesTheBrowser() {
        driver.quit();
    }
}
