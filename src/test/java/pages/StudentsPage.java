package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class StudentsPage {
    public StudentsPage (){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//li[.='Students']")
    public WebElement studentsTab;

    @FindBy(xpath = "//button[.='Add student']")
    public WebElement addStudentsBtn;

    @FindBy(xpath = "//input[@name = 'name']")
    public WebElement nameInpt;


    @FindBy(xpath = "//input[@name = 'lastName']")
    public WebElement lastNameInpt;
    @FindBy(xpath = "//input[@name = 'phoneNumber']")
    public WebElement phoneNumbInpt;


    @FindBy(xpath = "//input[@name = 'email']")
    public WebElement emailInpt;


    @FindBy(xpath = "(//div[@role= 'button'])[1]")
    public WebElement groupDrpDwn;


    @FindBy(xpath = "(//div[@role= 'button'])[2]")
    public WebElement studyFormatDrpDwn;


    @FindBy(xpath = "(//button[@type= 'submit'])")
    public WebElement addBtn;
}
