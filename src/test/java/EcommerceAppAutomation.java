import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class EcommerceAppAutomation extends BaseTest{


    public void longPress(WebElement ele) throws InterruptedException {
        Assert.assertNotNull(((RemoteWebElement) ele).getId());
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) ele).getId(),
                "duration",2000
        ));
    }

    public void fillFormHelper(boolean flag) throws InterruptedException {
        System.out.println("executing cases ....");
        if(flag)driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Apple");
      //  driver.hideKeyboard();
        driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector()).scrollIntoView(" +
                        "new UiSelector().text(\"Argentina\"));"
        ));
        driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

        // it is mandatory in android that toast will be caught via this xpath, for multiple toasts use indexes
        // we can't capture using appium and also value can be caught using name attribute. It's fixed in android.

        if(!flag){
            String toastMsg = driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name");
            Assert.assertEquals(toastMsg,"Please enter your name");
        }
        Thread.sleep(3000);

    }

    @Test
    public void fillForm() throws InterruptedException {

        System.out.println("executing positive cases ....");
        fillFormHelper(true);
        System.out.println("positive passed");
    }

    @Test
    public void fillFormToasterError() throws InterruptedException {
        System.out.println("executing Negative cases ....");
        fillFormHelper(false);
        System.out.println("negative passed");
    }


    public void addToCartProductHelper() throws InterruptedException {
        fillFormHelper(true);
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\"Jordan Lift Off\"));"
        ));

        int countOfProductDisplayed = driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productName")).size();

        for(int i = 0;i<countOfProductDisplayed;i++){

            String productName = driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productName")).get(i).getText();
            if(productName.equals("Jordan Lift Off")){
                driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
                driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
            }
        }

        String IsJordanDisplayed = String.valueOf(driver.findElement(By.xpath("//android.widget.TextView[@text='Jordan Lift Off']")).isDisplayed());
        Assert.assertTrue(Boolean.parseBoolean(IsJordanDisplayed));
        Thread.sleep(3000);
    }

   @Test
    public void addToCartProduct() throws InterruptedException {
        addToCartProductHelper();
    }

    @Test
    public void verifyAddProductThenTotalCorrectAmountForProductsThenSubmit() throws InterruptedException {

        fillFormHelper(true);
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\"Jordan 6 Rings\"));"
        ));
      // After clicking on "ADD TO CART", the button text changes to "ADDED TO CART".
      // So if we use index-based selection, the indexes will change dynamically.
      // For example, after clicking the button at index 0,
      // that button is no longer part of the "ADD TO CART" list.
       // As a result, the next "ADD TO CART" button shifts to index 0.
        driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
        driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement  element = driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title"));
        wait.until(ExpectedConditions.visibilityOf(element));
        double totalAmount = 0;
        List<WebElement> list = driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productPrice"));
        for (int i = 0; i < list.size(); i++) {
            totalAmount += Double.parseDouble(list.get(i).getText().substring(1));
        }
        String expectedAmountText = driver.findElement(
                        By.id("com.androidsample.generalstore:id/totalAmountLbl"))
                .getText()
                .substring(1);

        double expectedAmount = Double.parseDouble(expectedAmountText);
        Assert.assertEquals(totalAmount, expectedAmount);
        WebElement ele = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
        longPress(ele);
        driver.findElement(By.id("android:id/button1")).click();
        driver.findElement(By.xpath("//android.widget.CheckBox[@text='Send me e-mails on discounts related to selected products in future']")).click();
        driver.findElement(By.xpath("//android.widget.Button[@text='Visit to the website to complete purchase']")).click();
        Thread.sleep(2000);

    }



}
