package tests.testngTests;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class MainTestTestNg extends BaseTest {

    @Test
    public void mainTest() {
        page.navigate("https://playwright.dev");
        System.out.println(page.title());
        System.out.println("Hello world!");
    }
}