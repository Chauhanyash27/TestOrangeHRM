package Pages.Admin;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import java.util.List;
import java.util.Random;

public class Organization {

    Page page;
    String adminModule = "//span[text()='Admin']";
    String sectionHeading = "//h6[@class ='oxd-text oxd-text--h6 orangehrm-main-title']";
    String orgNameField = "input:below(:text('Organization Name'))";
    String registrationNoField = "input:below(:text('Registration Number'))";
    String notesField = "input:below(:text('Notes'))";
    String allUser ="//div[@role='row']//div[2]//div";
    String searchNameField = "input:below(:text('Name'))";
    Boolean flag;
    String addButton ="//button[@class='oxd-button oxd-button--medium oxd-button--secondary']";
    String nameField = "input:below(:text('Name'))";
    String recordCount = "//span[@class='oxd-text oxd-text--span']";
    String noOfRecords = "//div[@class='oxd-table-body']/div";

    public Organization(Page page){
        this.page = page;
    }

    public void clickOrganizationSubmodule(){
        page.click(adminModule);
        page.locator("li").filter(new Locator.FilterOptions().setHasText("Organization")).click();
    }

    public void navigateToSection(String sectionName){
        clickOrganizationSubmodule();
        page.getByRole(AriaRole.MENUITEM, new Page.GetByRoleOptions().setName(sectionName)).click();
    }

    public Boolean sectionNavigationVerification(String sectionName){
        String headingTitle = page.locator(sectionHeading).textContent();
        return (headingTitle.equals(sectionName));
    }

    public void editGeneralInformation(){
        page.locator("label").filter(new Locator.FilterOptions().setHasText("Edit")).locator("span").click();
        page.locator(orgNameField).clear();
        page.locator(orgNameField).fill("Infostride");
        page.locator(registrationNoField).clear();
        page.locator(registrationNoField).fill("1234");
        page.locator(notesField).clear();
        page.locator(notesField).fill("Edited notes");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save")).click();
    }

    public Boolean verifyGeneralInformation(){
        page.locator("label").filter(new Locator.FilterOptions().setHasText("Edit")).locator("span").click();
        String orgName = page.locator(orgNameField).textContent();
        String regNo = page.locator(registrationNoField).textContent();
        String notes = page.locator(notesField).textContent();
        return ((orgName.equals("Infostride"))&&(regNo.equals("1234"))&&(notes.equals("Edited notes")));
    }

    public Boolean fieldEnabledCheck(){
        return (page.isDisabled(orgNameField) && page.isDisabled(registrationNoField));
    }

    public String getRandomUser(List<String> users) {
        if (users == null || users.isEmpty()) {
            return null;
        }
        Random random = new Random();
        int index = random.nextInt(users.size());
        return users.get(index);
    }

    public Boolean editRecord(){
        List<String> allUsers = page.locator(allUser).allTextContents();
        String randomUser = getRandomUser(allUsers);
        page.locator("i[class='oxd-icon bi-pencil-fill']:right-of(:text('"+ randomUser +"'))");
        page.locator(nameField).clear();
        page.fill(nameField,"Edited Record");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save")).click();
        return !(dataValidityAfterManipulation("Edited Record",page.locator(allUser)));
    }

    public Boolean performSearch(){
        List<String> allUsers = page.locator(allUser).allTextContents();
        String randomUser = getRandomUser(allUsers);
        page.locator(searchNameField).first().fill(randomUser);
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Search")).click();
        return (dataValidityAfterManipulation(randomUser,page.locator(allUser)));
    }

    public Boolean dataValidityAfterManipulation(String Name, Locator allUser){
        flag=false;
        List<String> allUsersData = allUser.allTextContents();
        for(int i = 2; i< allUsersData.size(); i++){
            if(Name.equals(allUsersData.get(i))){
                flag = true;
            }
            else {flag=false;}
        }
        allUsersData.clear();
        return flag;
    }

    public Boolean addRecord(String Name) {
        page.click(addButton);
        page.fill(nameField, Name);
        page.getByText("-- Select --").click();
        page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("India")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save")).click();
        return !(dataValidityAfterManipulation(Name, page.locator(allUser)));
    }

    public boolean validateRecords(){
        String userCount = page.locator(recordCount).first().textContent();
        int recordsFoundCount = Integer.parseInt(userCount.substring(userCount.indexOf('(')+1,userCount.indexOf(')')));
        int userRecordInTable = page.locator(noOfRecords).count();
        return (recordsFoundCount == userRecordInTable);
    }

    public Boolean deleteUser(){
        List<String> allUsers = page.locator(allUser).allTextContents();
        String randomUser = getRandomUser(allUsers);
        page.locator("i[class='oxd-icon bi-trash']:right-of(:text('"+ randomUser +"'))").first().click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Yes, Delete")).click();
        Boolean deleteCountStatus = validateRecords();
        Boolean afterDeletion = dataValidityAfterManipulation(randomUser,page.locator(allUser));
        return (deleteCountStatus && afterDeletion);
    }


}
