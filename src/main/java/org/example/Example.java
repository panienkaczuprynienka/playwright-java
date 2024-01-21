package org.example;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class Example {

    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("https://www.medicover.pl/");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Akceptuj dodatkowe")).click();
            Page page1 = page.waitForPopup(() -> {
                page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Zaloguj się")).click();
            });
            Page page2 = page1.waitForPopup(() -> {
                page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Zaloguj")).click();
            });
            page2.getByPlaceholder("np.").click();
            page2.getByPlaceholder("np.").fill("2290081");
            page2.getByLabel("Hasło").click();
            page2.getByLabel("Hasło").fill("jKWzwF.rNg76b6A");
            page2.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Zaloguj")).click();
            page2.close();
            page1.navigate("https://mol.medicover.pl/persondataupdate?v=1");
            page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Zapisz")).click();
            page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Rozumiem")).click();
            page1.locator("#content input[type=\"text\"]").click();
            page1.locator("#content input[type=\"text\"]").fill("endokrynolog");
            page1.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Endokrynolog").setExact(true)).click();
            page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Szukaj")).click();
            page1.locator("app-generic-option").getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Umów")).click();
            page1.locator("div:nth-child(4) > div:nth-child(3) > .form-group > .form-control").selectOption("102792");
            page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Szukaj")).click();
            page1.getByText("W wybranych kryteriach wizyty").click();
        }
    }

}
