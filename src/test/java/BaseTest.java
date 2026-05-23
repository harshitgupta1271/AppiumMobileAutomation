import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.Capabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;


public class BaseTest {

    protected AndroidDriver driver;
    private AppiumDriverLocalService service;

    @BeforeClass
    public void startAppiumServer() {

        System.out.println("TestNG Test Executed Successfully");
        service = new AppiumServiceBuilder()
                .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();
    }

    @BeforeMethod
    public void configureAppium() throws MalformedURLException, URISyntaxException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Pixel 4 API 37.0");
//        options.setApp("/Users/harshit/automation/src/resources/ApiDemos-debug.apk");
        options.setApp("/Users/harshit/automation/src/resources/General-Store.apk");
        driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), (Capabilities) options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterClass
    public void stopAppiumServer() {
        if (service != null) {
            service.stop();
        }
    }
}
