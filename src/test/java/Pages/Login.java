package Pages;

import com.microsoft.playwright.Page;

public class Login {

    Page page;
    String usernameField = "//input[@name='username']";
    String passwordField = "//input[@name='password']";
    String loginButton = "//button[@type='submit']";
    String accountDropdown = "//span[@class='oxd-userdropdown-tab']";
    String logoutOption = "//a[text()='Logout']";

    public Login(Page page){
        this.page= page;
    }

    public void userLogin() throws InterruptedException {
      page.locator(usernameField).fill("Admin");
      page.locator(passwordField).fill("admin123");
      page.locator(loginButton).click();
    }

    public Boolean verifySuccessfullLogin(){
        page.locator(accountDropdown).click();
        Boolean status = page.locator(logoutOption).isVisible();
        return status;
    }
}
