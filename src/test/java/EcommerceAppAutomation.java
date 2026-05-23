import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EcommerceAppAutomation extends BaseTest{


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

    @Test
    public void addToCartProduct() throws InterruptedException {
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
}
