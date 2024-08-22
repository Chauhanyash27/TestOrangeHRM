package Pages.Leave;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import java.util.regex.Pattern;

public class Apply {

    Page page;
    String leaveModule = "//span[text()='Leave']";
    String applySubmodule = "//a[text()='Apply']";
    String leaveTypeField = "//div[@class='oxd-select-text-input']";
    String sectionHeading = "//h6[@class ='oxd-text oxd-text--h6 orangehrm-main-title']";

    public Apply(Page page) {
        this.page = page;
    }

    public void clickApplySubmodule() {
        page.click(leaveModule);
        page.click(applySubmodule);
    }

    public Boolean sectionNavigationVerification(String sectionName) {
        String headingTitle = page.locator(sectionHeading).textContent();
        return (headingTitle.equals(sectionName));
    }

    public void applyLeave() {
        clickApplySubmodule();
        page.click(leaveTypeField);
        page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^-- Select --$"))).nth(2);
        page.getByText("CAN - FMLA").click();
        page.getByPlaceholder("yyyy-dd-mm").first().click();
        page.getByText("21").click();
        page.getByPlaceholder("yyyy-dd-mm").nth(1).click();
        page.getByText("22").click();
        page.locator("textarea").click();
        page.locator("textarea").fill("Personal Reason");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Apply")).click();
    }
}
