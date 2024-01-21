package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.logging.Logger;

public class TestStatusListener implements ITestListener {

    private Logger log = Logger.getLogger(this.getClass().getName());

    @Override
    public void onFinish(ITestContext iTestContext) {
    }

    @Override
    public void onStart(ITestContext iTestContext) {
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestContext) {
        log.info("Test " + iTestContext.getName() + " has failed");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        log.info("Test " + iTestResult.getName() + " has failed");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
    }
}
