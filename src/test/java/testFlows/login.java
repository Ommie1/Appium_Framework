package testFlows;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;
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

        // Click on continue button
        MobileElement contBtn = (MobileElement) driver.findElementByXPath("//android.widget.Button[@text='CONTINUE']");
        contBtn.click();

        //Enter email field
        MobileElement emailField = (MobileElement) driver.findElementById("com.sehatkahani.app.qa:id/editTxtEmail");
        emailField.sendKeys("sabakhan@yopmail.com");

        //Enter password field
        MobileElement passField = (MobileElement) driver.findElementById("com.sehatkahani.app.qa:id/editTxtPassword");
        passField.sendKeys("test1234");

        //hide keyboard
        driver.hideKeyboard();

        // Click signin button
        MobileElement signInbtn = (MobileElement) driver.findElementById("com.sehatkahani.app.qa:id/btnLogin");
        signInbtn.click();

        // Verify the dashboard text
        MobileElement dashBrd = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView");
        String dashText = dashBrd.getText();
        Assert.assertEquals(dashText,"My Appointments");
    }
}
