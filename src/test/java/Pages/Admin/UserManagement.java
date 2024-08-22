package Pages.Admin;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import java.util.List;

public class UserManagement {

    Page page;
    String recordCount = "//span[@class='oxd-text oxd-text--span']";
    String adminModule = "//span[text()='Admin']";
    String noOfRecords = "//div[@class='oxd-table-body']/div";
    String addButton = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']";
    String dropdownFields = "//label[text()='User Role']//following::i";
    String employeeNameField = "input:below(:text('Employee Name'))";
    String usernameField = "input:below(:text('Username'))";
    String passwordField = "input:below(:text('Password'))";
    String confirmPasswordField = "input:below(:text('Confirm Password'))";
    String allUserName = "//div[@role='row']//div[2]//div";
    Boolean flag;

    public UserManagement(Page page) {
        this.page = page;
    }

    public boolean userCountVerification() {
        page.click(adminModule);
        String userCount = page.locator(recordCount).first().textContent();
        int recordsFoundCount = Integer.parseInt(userCount.substring(userCount.indexOf('(') + 1, userCount.indexOf(')')));
        int userRecordCount = page.locator(noOfRecords).count();

        return (recordsFoundCount == userRecordCount);
    }

    public void addUser() {
        page.click(adminModule);
        page.click(addButton);
        page.locator(dropdownFields).first().click();
        page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Admin")).click();
        page.locator(dropdownFields).last().click();
        page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Enabled")).click();
        page.locator(employeeNameField).first().fill("Yash");
        page.locator(usernameField).first().fill("UserYash");
        page.locator(passwordField).first().fill("password");
        page.locator(confirmPasswordField).first().fill("password");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save")).click();
    }

    public Boolean deleteUser(String userName) {
        page.click(adminModule);
        flag = false;
        Boolean validity = usernameValidityBefore(userName, page.locator(allUserName));
        if (validity) {
            page.locator("i[class='oxd-icon bi-trash']:right-of(:text('" + userName + "'))");
            Boolean deleteCountStatus = userCountVerification();
            Boolean afterDeletion = usernameValidityAfter(userName, page.locator(allUserName));
            return (deleteCountStatus && afterDeletion);
        } else {
            System.out.println("User with this username does not exists in the record");
            return false;
        }
    }

    public Boolean usernameValidityBefore(String userName, Locator allUserName) {
        List<String> allUserNames = allUserName.allTextContents();
        for (int i = 2; i < allUserNames.size(); i++) {
            if (userName.equalsIgnoreCase(allUserNames.get(i))) {
                flag = true;
                break;
            }
        }
        allUserNames.clear();
        return flag;
    }

    public Boolean usernameValidityAfter(String userName, Locator allUserName) {
        List<String> allUserNames = allUserName.allTextContents();
        for (int i = 2; i < allUserNames.size(); i++) {
            if (userName.equalsIgnoreCase(allUserNames.get(i))) {
                flag = false;
                break;
            }
        }
        allUserNames.clear();
        return flag;
    }

}
