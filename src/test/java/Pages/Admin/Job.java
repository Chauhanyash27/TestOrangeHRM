package Pages.Admin;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import java.util.List;

public class Job {
    Page page;
    String adminModule = "//span[text()='Admin']";
    String sectionHeading = "//h6[@class ='oxd-text oxd-text--h6 orangehrm-main-title']";
    String recordCount = "//span[@class='oxd-text oxd-text--span']";
    String noOfRecords = "//div[@class='oxd-table-body']/div";
    String allUser ="//div[@role='row']//div[2]//div";
    Boolean flag;
    String addButton ="//button[@class='oxd-button oxd-button--medium oxd-button--secondary']";
    String jobTitleField = "input:below(:text('Job Title'))";
    String jobDescriptionField = "textarea:below(:text('Job Description'))";
    String nameField = "input:below(:text('Name'))";

    public Job(Page page){
        this.page = page;
    }

    public void clickJobSubmodule(){
        page.click(adminModule);
        page.locator("li").filter(new Locator.FilterOptions().setHasText("Job")).click();
    }

    public void navigateToSection(String sectionName){
        clickJobSubmodule();
        page.getByRole(AriaRole.MENUITEM, new Page.GetByRoleOptions().setName(sectionName)).click();
    }

    public Boolean sectionNavigationVerification(String sectionName){
     String headingTitle = page.locator(sectionHeading).textContent();
        return (headingTitle.equals(sectionName));
    }

    public boolean validateRecords(){
        String userCount = page.locator(recordCount).first().textContent();
        int recordsFoundCount = Integer.parseInt(userCount.substring(userCount.indexOf('(')+1,userCount.indexOf(')')));
        int userRecordInTable = page.locator(noOfRecords).count();

        return (recordsFoundCount == userRecordInTable);
    }

    public Boolean deleteUser(){
        String getFirstRowColumnData = page.locator(allUser).nth(2).textContent();
        page.locator("i[class='oxd-icon bi-trash']:right-of(:text('"+ getFirstRowColumnData +"'))");
        Boolean deleteCountStatus = validateRecords();
        Boolean afterDeletion = dataValidityAfterManipulation(getFirstRowColumnData,page.locator(allUser));
        return (deleteCountStatus && afterDeletion);
    }

    public Boolean dataValidityAfterManipulation(String Name, Locator allUser){
        flag=true;
        List<String> allUsersData = allUser.allTextContents();
        for(int i = 2; i< allUsersData.size(); i++){
            if(Name.equalsIgnoreCase(allUsersData.get(i))){
                flag = false; break;
            }
        }
        allUsersData.clear();
        return flag;
    }

    public Boolean addJobTitle(String jobTitle){
        page.click(addButton);
        page.fill(jobTitleField,jobTitle);
        page.fill(jobDescriptionField,"Testing Description");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save")).click();
        return !(dataValidityAfterManipulation(jobTitle,page.locator(allUser)));
    }

    public Boolean addRecord(String Name){
        page.click(addButton);
        page.fill(nameField,Name);
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save")).click();
        return !(dataValidityAfterManipulation(Name,page.locator(allUser)));
    }

    public Boolean editJobTitleRecord(){
        String getFirstRowDataToEdit = page.locator(allUser).nth(2).textContent();
        page.locator("i[class='oxd-icon bi-pencil-fill']:right-of(:text('"+ getFirstRowDataToEdit +"'))");
        page.locator(jobTitleField).clear();
        page.fill(jobTitleField,"Edited");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save")).click();
        return !(dataValidityAfterManipulation("Edited",page.locator(allUser)));
    }

    public Boolean editRecord(){
        String getFirstRowDataToEdit = page.locator(allUser).nth(2).textContent();
        page.locator("i[class='oxd-icon bi-pencil-fill']:right-of(:text('"+ getFirstRowDataToEdit +"'))");
        page.locator(nameField).clear();
        page.fill(nameField,"Edited Record");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save")).click();
        return !(dataValidityAfterManipulation("Edited Record",page.locator(allUser)));
    }
}
