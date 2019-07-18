import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import java.io.IOException;

public class login extends device_invoke {

    public static void main(String[] args) throws InterruptedException, IOException {

        AndroidDriver<AndroidElement> driver= Capablities("HealthCareApp");
        System.out.println( "Device is invoked" );

    }
}
