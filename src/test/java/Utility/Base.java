package Utility;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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
        browserContext = browser.newContext();
        page = browserContext.newPage();
        page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        page.locator(usernameField).fill("Admin");
        page.locator(passwordField).fill("admin123");
        page.locator(loginButton).click();
    }
//new Browser.NewContextOptions().setStorageStatePath(Paths.get("AutomaticLogin.json"))
    @AfterTest
    public void tearDown(){
        browserContext.close();
        browser.close();
    }
}
