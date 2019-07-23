package pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class loginPage {

    public loginPage(AndroidDriver<AndroidElement> driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath="//android.widget.Button[@text='CONTINUE']")
    public AndroidElement continueElement;

    @AndroidFindBy(id = "com.sehatkahani.app.qa:id/editTxtEmail")
    public AndroidElement emailElement;

    @AndroidFindBy(id = "com.sehatkahani.app.qa:id/editTxtPassword")
    public AndroidElement passElement;

    @AndroidFindBy(id = "com.sehatkahani.app.qa:id/btnLogin")
    public AndroidElement signinElement;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView")
    public AndroidElement dashbrdElement;

    //-----------------------------------------------------------------------------------------------
    // Page object will work without this return method but for the purpose of logging we defined it
    //-----------------------------------------------------------------------------------------------

    public AndroidElement getContinueElement() {
        System.out.println("Taping on continue button");
        return continueElement;
    }

    public AndroidElement getEmailElement(){
        System.out.println("Entering email on login form");
        return emailElement;
    }

    public AndroidElement getPassElement(){
        System.out.println("Entering password on login form");
        return passElement;
    }

    public AndroidElement getSigninElement()
    {
        System.out.println("Clicking on sign in button on login form");
        return signinElement;
    }

    public AndroidElement getDashbrdElement()
    {
        System.out.println("Verifying text on dashboard after login");
        return dashbrdElement;
    }
}
