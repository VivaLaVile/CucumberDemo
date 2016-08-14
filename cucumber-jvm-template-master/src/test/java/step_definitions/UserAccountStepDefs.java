package step_definitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import modules.SignInAction;
import modules.SignoutAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pageobjects.AutomationAccountPage;
import pageobjects.AutomationHomePage;
import pageobjects.LoginPage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class UserAccountStepDefs {
    public WebDriver driver;
//    public List<HashMap<String,String>> datamap = DataHelper.data();
    public static List<HashMap<String,String>> datamap = null;
    private String emailAddress;
    private String password;

    public UserAccountStepDefs()
    {
    	driver = Hooks.driver;

    	datamap = new ArrayList<HashMap<String,String>>();
    	HashMap<String,String> sampleData = new HashMap<String,String>();
    	sampleData.put("username","cucumber@xyz.com");
    	sampleData.put("password","cucumber123");
    	System.out.println("Current data" +sampleData);
    	datamap.add(sampleData);
    }
    
    @When("^I open automationpractice website$")
    public void i_open_automationpractice_website() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    	driver.get("http://automationpractice.com");
    }

    @When("^I attempt to log in using correct credentials$")
    public void iAttemptToLogInUsingCorrectCredentials() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        PageFactory.initElements(driver, AutomationHomePage.class);
        PageFactory.initElements(driver, LoginPage.class);

        SignInAction.Execute(driver,datamap.get(0));
    }

    @Then("^I should log in successfully$")
    public void iShouldLogInSuccessfully() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
       PageFactory.initElements(driver, AutomationAccountPage.class);
       Assert.assertEquals(AutomationAccountPage.my_account.getText(),"Clive Cucumber");

    }

    @And("^I have an email address of ([^\"]*)$")
    public void iHaveAnEmailAddressOfEmail(String usersEmail) throws Throwable {
        emailAddress = usersEmail;
    }

    @And("^I have a password of ([^\"]*)$")
    public void iHaveAPasswordOfPassword(String usersPassword) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        password = usersPassword;
    }

    @When("^I attempt to log in using my email address only$")
    public void iAttemptToLogInUsingMyEmailAddressOnly() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        PageFactory.initElements(driver, AutomationHomePage.class);
        PageFactory.initElements(driver, LoginPage.class);

        AutomationHomePage.sign_in.click();
        LoginPage.email.sendKeys(emailAddress);
        LoginPage.signin_button.click();
    }

    @Then("^I should receive an error$")
    public void iShouldReceiveAnError() throws Throwable {
        PageFactory.initElements(driver, LoginPage.class);

        Assert.assertTrue(LoginPage.error_bar.isDisplayed());
    }

    @When("^I attempt to log in using my password only$")
    public void iAttemptToLogInUsingMyPasswordOnly() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        PageFactory.initElements(driver, AutomationHomePage.class);
        PageFactory.initElements(driver, LoginPage.class);

        AutomationHomePage.sign_in.click();
        LoginPage.password.sendKeys(password);
        LoginPage.signin_button.click();
    }
}