package pageobjects;
import helpers.Log;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
public class AutomationAccountPage extends BaseClass{

    public AutomationAccountPage(WebDriver driver){
        super(driver);
    }


    @FindBy(how=How.LINK_TEXT, using="Sign in")
    public static WebElement sign_in;

    @FindBy(how=How.LINK_TEXT, using="Contact us")
    public static WebElement contact_us;

    @FindBy(how=How.LINK_TEXT, using="Sign out")
    public static WebElement sign_out;

    @FindBy(how=How.XPATH, using="//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a" )

    //*[@id="header"]/div[2]/div/div/nav/div[1]/a

    public static WebElement my_account;

    public static class HeaderPage
    {

        @FindBy(how=How.LINK_TEXT, using="Women")
        public static WebElement menu_women;

        @FindBy(how=How.XPATH, using="//*a[@title='Dresses']")
        public static WebElement menu_dresses;

        @FindBy(how=How.XPATH, using="//*a[@title='T-shirts']")
        public static WebElement menu_tshirts;

    }

    public class MyAccountPanel
    {

    }

}