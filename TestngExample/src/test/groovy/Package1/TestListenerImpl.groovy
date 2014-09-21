package Package1

import junit.framework.AssertionFailedError
import junit.framework.Test
import junit.framework.TestListener
import org.testng.ITestContext
import org.testng.ITestListener
import org.testng.ITestResult

/**
 * Created by yusoof on 20/09/14.
 */
class TestListenerImpl implements ITestListener{
    @Override
    void onTestStart(ITestResult result) {

    }

    @Override
    void onTestSuccess(ITestResult result) {

    }

    @Override
    void onTestFailure(ITestResult result) {

    }

    @Override
    void onTestSkipped(ITestResult result) {

    }

    @Override
    void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    void onStart(ITestContext context) {

    }

    @Override
    void onFinish(ITestContext context) {

    }
}
