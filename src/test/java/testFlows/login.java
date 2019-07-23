package testFlows;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.loginPage;
import utlilities.device_invoke;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class login extends device_invoke {

    @Test
    public void loginFlow() throws InterruptedException, IOException {

        // Device instance
        AndroidDriver<AndroidElement> driver= device_invoke.Capablities("HealthCareApp");
        System.out.println( "Device is invoked" );
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // login page object class instance
        loginPage lp = new loginPage(driver);

        // Click on continue button
        lp.continueElement.click();

        //Enter email field
        lp.emailElement.sendKeys("sabakhan@yopmail.com");;

        //Enter password field
        lp.passElement.sendKeys("test1234");

        //hide keyboard
        driver.hideKeyboard();

        // Click signin button
        lp.signinElement.click();

        // Verify the dashboard text
        String dashText = lp.dashbrdElement.getText();
        Assert.assertEquals(dashText,"My Appointments");
        System.out.println(dashText);

    }
}
