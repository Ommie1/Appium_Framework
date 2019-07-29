package utlilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class device_invoke{

    public static AndroidDriver<AndroidElement> Capablities(String appName) throws IOException, InterruptedException {

        // Open Appium and Emulator
//        appiumEmulatorsession aes = new appiumEmulatorsession();
//        aes.openEmulator();
//        aes.startAppium();

        // Properties file configuration
        FileInputStream fis = new FileInputStream("src/main/config.properties");
        Properties prop = new Properties();
        prop.load(fis);
        prop.get(appName);

        // Get value from properties file
        File appDir = new File("src");
        File app = new File(appDir, (String) prop.get(appName));
        String Device=(String)  prop.get("Device") ;
        String ServerInstance=(String) prop.get("ServerInstance");

        // Set device configuration
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("avd","Nexus5");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, Device);
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL(ServerInstance), capabilities);

        // Get session information
        System.out.println(driver.currentActivity());
        System.out.println(driver.getSessionId().toString());

        return driver;
    }
}
