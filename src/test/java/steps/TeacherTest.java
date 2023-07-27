package steps;


import io.cucumber.java.en.*;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.AnnouncementsPage;
import pages.StudyMateHomePage;
import pages.TeachersPage;
import utilities.AppFlow;
import utilities.Driver;

import java.util.List;

public class TeacherTest {
    StudyMateHomePage studyMateHomePage =new StudyMateHomePage();
    TeachersPage teachersPage = new TeachersPage();
        AnnouncementsPage announcementsPage = new AnnouncementsPage();



    @Then("user navigates to teachers tab")
    public void userNavigatesToTeachersTab() {
        studyMateHomePage.teachersTab.click();
        AppFlow.pause(3000);
        String expectedUrl = "https://codewise.studymate.us/admin/teachers";
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedUrl));
    }
    @Then("verify user changes the number of results per page to")
    public void verify_user_changes_the_number_of_results_per_page_to(io.cucumber.datatable.DataTable dataTable) {

        List<Integer> numbersOfResults = dataTable.asList(Integer.class);
        for (Integer number : numbersOfResults) {
            teachersPage.numberInput.sendKeys(Keys.chord(Keys.CONTROL, "a"));
            teachersPage.numberInput.sendKeys(number.toString() + Keys.ENTER);

            AppFlow.pause(3000);

            Assert.assertTrue("ERROR: The number of teachers did not match the expected number",
                    teachersPage.listOfTeachers.size() == number);


        }
    }

    @Then("user navigates to announcements tab")
    public void user_navigates_to_announcements_tab() {
        announcementsPage.announcementsTab.click();
        AppFlow.pause(3000);
        String expectedUrl = "https://codewise.studymate.us/admin/announcements";
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedUrl));

    }
    @Then("verify user in announcements page user changes the number of results per page to")
    public void verify_user_in_announcements_page_user_changes_the_number_of_results_per_page_to(io.cucumber.datatable.DataTable dataTable) {
        List<Integer> numbersOfResults = dataTable.asList(Integer.class);
        for (Integer number : numbersOfResults) {
            announcementsPage.numberOfPage.sendKeys(Keys.chord(Keys.CONTROL, "a"));
            announcementsPage.numberOfPage.sendKeys(number.toString() + Keys.ENTER);

            AppFlow.pause(3000);

            Assert.assertTrue("ERROR: The number of teachers did not match the expected number",
                    announcementsPage.listOfAnnouncements.size() == number);

        }
    }


}
