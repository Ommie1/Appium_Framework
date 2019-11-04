package FrameworkUtilities.ExecutionListners;

import FrameworkUtilities.JiraIntegration.Constants;
import FrameworkUtilities.JiraIntegration.JiraServiceProvider;
import FrameworkUtilities.JiraIntegration.ScriptMetaData;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerWhileTestExecution implements ITestListener {
    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {

        // first letst get the annotation value from the filed test case.
        ScriptMetaData meta = iTestResult.getMethod().getConstructorOrMethod().getMethod().getAnnotation(ScriptMetaData.class);

        // get the annotation parameter value as a boolean
        boolean isProductionReady = meta.productionReady();
        // Check if the annotation attribute value is productionReady=true
        if (isProductionReady) {
            System.out.println("IS PRODUCTION READY : "+isProductionReady);
            JiraServiceProvider jiraSP = new JiraServiceProvider(Constants.JIRA_URL, Constants.JIRA_USERNAME, Constants.JIRA_PASSWORD, Constants.JIRA_PROJECT);
            // Add the failed method name as the issue summary
            String issueSummary = iTestResult.getMethod().getConstructorOrMethod().getMethod().getName() + " was failed due to an exception";
            // get the error message from the exception to description
            String issueDescription = "Exception details : "+  iTestResult.getThrowable().getMessage() + "\n";
            // Append the full stack trace to the description.
            issueDescription.concat(ExceptionUtils.getStackTrace(iTestResult.getThrowable()));
//            issueDescription.concat(ExceptionUtils.getFullStackTrace(iTestResult.getThrowable()));
            jiraSP.createJiraIssue("Bug", issueSummary, issueDescription, Constants.JIRA_USERNAME);
        }

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
