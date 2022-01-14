package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import resources.Base;

import java.nio.file.WatchEvent;

public class InboxPage extends Base {

    @FindBy(css = "div[id]>div>[role='button'][jscontroller]")
    public WebElement composeBtn;

    @FindBy(css = "[aria-label='New Message']")
    public WebElement newMessageSection;

    @FindBy (css = "form[method='post']>div[id]:nth-of-type(2)")
    public WebElement recipientsField;

    @FindBy(css = "[aria-label='To']")
    public WebElement to;

    @FindBy (css = "input[name='subjectbox']")
    public WebElement subjectField;

    @FindBy (css = "div[aria-label='Message Body']")
    public WebElement bodyField;

    @FindBy (css = "div[role='button'][aria-label*='Send']")
    public WebElement sendBtn;

    @FindBy(xpath = "//*[contains(text(),\"Message sent\")]")
    public WebElement sentMsgTxt;


    public InboxPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

}
