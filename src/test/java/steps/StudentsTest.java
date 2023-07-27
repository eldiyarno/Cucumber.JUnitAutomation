package steps;

import io.cucumber.java.en.Then;
import org.openqa.selenium.Keys;
import pages.StudentsPage;
import utilities.AppFlow;


public class StudentsTest {

    StudentsPage studentsPage = new StudentsPage();

    @Then("user navigates to students tab")
    public void user_navigates_to_students_tab() {
        studentsPage.studentsTab.click();

    }

    @Then("user clicks on add student button")
    public void user_clicks_on_add_student_button() {
        studentsPage.addStudentsBtn.click();
        AppFlow.pause(5000);
    }


    @Then("user adds student info with {string},{string},{string},{string},{string},{string},")
    public void user_adds_student_info_with(String name, String lastName, String phoneNum, String email, String string5, String string6) {
        studentsPage.nameInpt.sendKeys(name);
        studentsPage.lastNameInpt.sendKeys(lastName);
        studentsPage.phoneNumbInpt.sendKeys(phoneNum);
        studentsPage.emailInpt.sendKeys(email);
        studentsPage.groupDrpDwn.click();
        studentsPage.groupDrpDwn.sendKeys(Keys.ENTER);
        studentsPage.studyFormatDrpDwn.click();
        studentsPage.studyFormatDrpDwn.sendKeys(Keys.ENTER);
        studentsPage.addBtn.click();
    }


    @Then("verify student with {string},{string},{string},{string},{string},{string} was created")
    public void verify_student_with_was_created(String string, String string2, String string3, String string4, String string5, String string6) {

    }

    @Then("user deletes student with {string}")
    public void user_deletes_student_with(String string) {

    }

    @Then("verify student with {string},{string},{string},{string},{string},{string} was deleted")
    public void verify_student_with_was_deleted(String string, String string2, String string3, String string4, String string5, String string6) {

    }



}
