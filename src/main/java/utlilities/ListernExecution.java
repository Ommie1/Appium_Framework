package utlilities;

import org.testng.IExecutionListener;

public class ListernExecution implements IExecutionListener {
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
