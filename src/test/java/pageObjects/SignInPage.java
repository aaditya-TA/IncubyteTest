package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import resources.Base;

public class SignInPage extends Base {

    @FindBy(css = "input[type='email']")
    public WebElement emailField;

    @FindBy(css = "div[id='identifierNext'] button")
    public WebElement nextButton;

    @FindBy(css = "input[type='password']")
    public WebElement passwordField;

    @FindBy(css="div[id='passwordNext'] button")
    public WebElement loginBtn;

    public SignInPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }







}
