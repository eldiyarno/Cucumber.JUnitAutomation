package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class StudyMateLoginPage {
    public StudyMateLoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(name = "email")
    public WebElement emailInput;
    @FindBy(name = "password")
    public WebElement passwordInput;
    @FindBy(xpath = "(//button)[3]")
    public WebElement loginBtn;

}
