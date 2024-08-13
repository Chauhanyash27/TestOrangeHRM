package Pages;

import com.microsoft.playwright.Page;

public class Home {

    Page page;
    String adminModule = "//span[text()='Admin']";
    String adminText = "//h6[text()='Admin']";

    public Home(Page page){
     this.page = page;
    }

    public Boolean navigateToAdminModule(){
    page.click(adminModule);
    Boolean status = page.locator(adminText).isVisible();
    return status;
    }
}
