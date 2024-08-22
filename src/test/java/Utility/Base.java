package Utility;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.nio.file.Paths;

public class Base {

    public static Page page;
    public Playwright playwright;
    public BrowserContext browserContext;
    public Browser browser;
    String usernameField = "//input[@name='username']";
    String passwordField = "//input[@name='password']";
    String loginButton = "//button[@type='submit']";

    @BeforeMethod
    public void browserInitiator() {
        playwright = Playwright.create();
        browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
        browserContext = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("myvideos/")));
        page = browserContext.newPage();
        page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        page.locator(usernameField).fill("Admin");
        page.locator(passwordField).fill("admin123");
        page.locator(loginButton).click();
    }

    @AfterMethod
    public void tearDown() {
        browserContext.close();
        browser.close();
    }


}

