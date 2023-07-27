package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class StudyMateHomePage {
    public StudyMateHomePage (){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//li[.='Teachers']")
    public WebElement teachersTab;
    @FindBy(xpath = "(//div/input)[2]")
    public WebElement numberInput;

    @FindBy(xpath = "//tr/td[2]")
    public List<WebElement> listOfTeachers;

}
