package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import java.util.logging.Logger;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int countOfRetires = 0;
    private int MAX_RETRIES = 3;
    private Logger log = Logger.getLogger(this.getClass().getName());

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()) {
            if (countOfRetires < MAX_RETRIES) {
                countOfRetires++;
                log.info("Test with name: " + iTestResult.getName() + " has been retried for the " + countOfRetires + "th time");
                return true;
            }
        }
        return false;
    }

}
