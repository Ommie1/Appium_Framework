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

}
