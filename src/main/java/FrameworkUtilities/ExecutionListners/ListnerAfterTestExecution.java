package FrameworkUtilities.ExecutionListners;

import org.testng.IExecutionListener;
import FrameworkUtilities.GmailIntegration.SendingEmail;

public class ListnerAfterTestExecution implements IExecutionListener {
    @Override
    public void onExecutionStart() {

    }

    @Override
    public void onExecutionFinish() {

        SendingEmail se = new SendingEmail();
        try {
            se.SendReport();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
