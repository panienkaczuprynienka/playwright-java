package tests.testngTests;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class PatkaTest extends BaseTest {

    @Test
    public void patkaTest() {
        page.navigate("https://www.google.pl/");
        Assertions.assertThat(page.title()).contains("Google");
       // Assertions.assertThat(1).isEqualTo(2);
    }
}
