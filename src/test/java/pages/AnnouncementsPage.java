package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AnnouncementsPage {
    public AnnouncementsPage (){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//li[.='Announcements']")
    public WebElement announcementsTab;

    @FindBy(xpath = "(//div/input)[5]")
    public WebElement numberOfPage;

    //div[.='ADMIN']
    @FindBy(xpath = "//div[.='For whom:']")
    public List<WebElement> listOfAnnouncements;
}
