package utlilities;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.IOException;

import static java.lang.Runtime.getRuntime;

public class appiumEmulatorsession {

    public void startAppium()
    {
        AppiumDriverLocalService service = new AppiumServiceBuilder().usingPort(4723).build();
        service.start();
    }

    public void openEmulator() throws IOException, InterruptedException {
        getRuntime().exec("adb -s Nexus5 shell strace -p 871");
        Thread.sleep(6000);
    }

    public void stopAppium()
    {
        AppiumDriverLocalService service = new AppiumServiceBuilder().usingPort(4725).build();
        service.stop();

    }
    public void closeEmulator() throws IOException {
        Runtime.getRuntime().exec("adb -s Nexus5 emu kill");

    }
}
