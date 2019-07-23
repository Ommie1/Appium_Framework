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

        // Verifying login flow
        System.out.println("Verifying login flow");

        // login page object class instance
        loginPage loginPageobject = new loginPage(driver);

        // Click on continue button
        loginPageobject.getContinueElement().click();

        //Enter email field
        loginPageobject.getEmailElement().sendKeys("sabakhan@yopmail.com");

        //Enter password field
        loginPageobject.getPassElement().sendKeys("test1234");

        //hide keyboard
        System.out.println("Closing the keyboard");
        driver.hideKeyboard();

        // Click signin button
        loginPageobject.getSigninElement().click();

        // Verify the dashboard text
        String dashText = loginPageobject.getDashbrdElement().getText();
        Assert.assertEquals(dashText,"My Appointments");
        System.out.println(dashText);

        // Login flow verified
        System.out.println("User has successfully log in to the system");
    }
}
