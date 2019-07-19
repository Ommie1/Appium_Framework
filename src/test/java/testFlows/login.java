package testFlows;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.Test;
import utlilities.device_invoke;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class login extends device_invoke {

    @Test
    public void loginFlow() throws InterruptedException, IOException {

        AndroidDriver<AndroidElement> driver= device_invoke.Capablities("HealthCareApp");
        System.out.println( "Device is invoked" );
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }
}
