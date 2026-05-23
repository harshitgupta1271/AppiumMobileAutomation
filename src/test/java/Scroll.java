import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class Scroll extends BaseTest {


    public void scrollTestHelper(String elementText){

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector()).scrollIntoView(" +
                        "new UiSelector().text(\"" + elementText + "\"));"
        ));
    }

    public void scrollByCoordinatesHelper(){

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        boolean canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                "left", 100, "top", 100, "width", 200, "height", 200,
                "direction", "down",
                "percent", 1.0
        ));

        // it returns false when there is no space for scrolling and util it returns true if space is there
    }


    @Test
    public void scrollTest(){

        scrollTestHelper("WebView");
    }

    @Test
    public void scrollByCoordinatesTest(){
        scrollByCoordinatesHelper();
    }
}