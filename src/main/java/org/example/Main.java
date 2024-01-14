package org.example;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            //Browser browser = playwright.chromium().launch();
            //playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));


            Browser browser = playwright.chromium().launch();
            BrowserContext context = browser.newContext();

// Start tracing before creating / navigating a page.
            context.tracing().start(new Tracing.StartOptions()
                    .setScreenshots(true)
                    .setSnapshots(true)
                    .setSources(true));

            Page page = context.newPage();
            page.navigate("https://playwright.dev");
            System.out.println(page.title());

// Stop tracing and export it into a zip archive.
            context.tracing().stop(new Tracing.StopOptions()
                    .setPath(Paths.get("trace.zip")));


        }


        System.out.println("Hello world!");
    }
}