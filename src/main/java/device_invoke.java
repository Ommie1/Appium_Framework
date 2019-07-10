import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class device_invoke {

    public static AndroidDriver<AndroidElement> Capablities() throws MalformedURLException{

        // Set application path
        File appDir = new File("src");
        File app = new File(appDir, "SehatKahani.apk");

        // Set device configuration
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus5");
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        // Get session information
        System.out.println(driver.currentActivity());
        System.out.println(driver.getSessionId().toString());

        return driver;
    }
}
