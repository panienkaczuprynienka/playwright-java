package attachments;

import com.microsoft.playwright.Page;
import io.qameta.allure.Attachment;

public class CaptureAttachment {

    @Attachment(value = "Screenshot of failed test", type = "image/png")
    public static byte[] createScreenshot(Page page) {
        return page.screenshot();
    }

    @Attachment(value = "Current url of failed test")
    public static String logUrl(Page page) {
        return "Current url of failed test is " + page.url();
    }

}
