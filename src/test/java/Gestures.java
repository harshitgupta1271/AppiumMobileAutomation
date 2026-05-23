import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Gestures extends BaseTest {



    public void longPress(WebElement ele) throws InterruptedException {
        Assert.assertNotNull(((RemoteWebElement) ele).getId());
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) ele).getId(),
                "duration",2000
        ));
    }


    @Test
    public void gestureTest() throws InterruptedException {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();

        for (int i = 1; i <= 5; i++) {

            WebElement ele = driver.findElement(
                    By.xpath("(//android.widget.TextView)[" + i + "]")
            );

            System.out.println(ele.getText());
        }
        WebElement ele = driver.findElement(By.xpath("(//android.widget.TextView)[2]"));
        longPress(ele);
        Thread.sleep(3000);
    }

}
