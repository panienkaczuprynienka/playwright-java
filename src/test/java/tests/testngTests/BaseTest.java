package tests.testngTests;

import attachments.CaptureAttachment;
import com.microsoft.playwright.*;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.nio.file.Paths;


public class BaseTest {
    // Shared between all tests in this class.
    Playwright playwright;
    Browser browser;

    // New instance for each test method.
    BrowserContext context;
    Page page;

    @BeforeClass
    void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
    }

    @AfterClass
    void closeBrowser() {
        playwright.close();
    }

    @BeforeMethod
    void createContextAndPage() {
        context = browser.newContext();
        context.tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true)
                .setSources(true));
        page = context.newPage();
    }

    @AfterMethod
    void closeContext() {
        String name = new Object() {}.getClass().getName();
        context.tracing().stop(new Tracing.StopOptions()
                .setPath(Paths.get(name + "_" + "trace.zip")));
        context.close();
    }

    @AfterMethod(alwaysRun = true)
    public void afterTestMethod(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus() || ITestResult.SUCCESS_PERCENTAGE_FAILURE == result.getStatus()
                || ITestResult.SKIP == result.getStatus()) {
            CaptureAttachment.createScreenshot(page);
            CaptureAttachment.logUrl(page);
        }
    }

}