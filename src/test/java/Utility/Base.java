package Utility;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.nio.file.Paths;

public class Base {

    public  Playwright playwright;
    public BrowserContext browserContext;
    public Browser browser;
    public static Page page;
    String usernameField = "//input[@name='username']";
    String passwordField = "//input[@name='password']";
    String loginButton = "//button[@type='submit']";

    @BeforeTest
    public  void browserInitiator(){
        playwright = Playwright.create();
        browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
        browserContext = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("myvideos/")));
        page = browserContext.newPage();
        page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        page.locator(usernameField).fill("Admin");
        page.locator(passwordField).fill("admin123");
        page.pause();
        page.locator(loginButton).click();
    }

    @AfterTest
    public void tearDown(){
        browserContext.close();
        browser.close();
    }
}

