import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import java.net.MalformedURLException;

public class login extends device_invoke {

    public static void main(String[] args) throws MalformedURLException {

        AndroidDriver<AndroidElement> driver= Capablities();
        System.out.println( "Device is invoked" );

    }

}
