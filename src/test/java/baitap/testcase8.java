package baitap;
/*  Verify you are able to change or reorder previously added product

        *  Test Data = QTY = 10

        Test Steps:

        1. Go to http://live.techpanda.org/

        2. Click on my account link

        3. Login in application using previously created credential

        4. Click on 'REORDER' link , change QTY & click Update

        5. Verify Grand Total is changed

        6. Complete Billing & Shipping Information

        7. Verify order is generated and note the order number

        Expected outcomes:

        1) Grand Total is Changed

        2) Order number is generated*/

import org.testng.annotations.Test;
import POM.CartPage;
import POM.CheckOutPage;
import POM.LoginPage;
import driver.driverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.sql.SQLOutput;

@Test
public class testcase8 {
    public static void main() {
        WebDriver driver = driverFactory.getChromeDriver();
        String email = "vomongluan@gmail.com";
        String password = "luan123456";
        String country = "United States";
        String state = "Florida";
        String zip = "2000";
        String firstname = "Vo";
        String lastname = "Luan";
        String address = "hcm123";
        String city = "HCM";
        String telephone = "0123456789";

        try {
            LoginPage login = new LoginPage(driver);
            login.goToMyAccount();
            login.Login(email, password);
            login.clickLogin();
            Thread.sleep(2000);

            WebElement reorder = driver.findElement(By.xpath("//tr[@class='first odd']//a[@class='link-reorder'][normalize-space()='Reorder']"));
            reorder.click();

            WebElement qtyInput = driver.findElement(By.xpath("//input[@title='Qty']"));
            qtyInput.clear();
            qtyInput.sendKeys("10");
            Thread.sleep(2000);
            WebElement update = driver.findElement(By.xpath("//button[@title='Update']//span//span[contains(text(),'Update')]"));
            update.click();
            Thread.sleep(2000);

//            WebElement grandTotal = driver.findElement(By.xpath("//strong//span[@class='price'][normalize-space()='$1,050.00']"));
//            String expectedTotal = "$1,050.00";
//            Assert.assertEquals(expectedTotal, grandTotal.getText());
//            System.out.println("Grand Total is Changed");

            CartPage cart = new CartPage(driver);
            cart.clickCheckout();

            CheckOutPage checkout = new CheckOutPage(driver);
            checkout.newBillingAddress();
            checkout.fillForm1(firstname, lastname, address, city);
            checkout.fillForm2(state, zip, country, telephone);
            checkout.chooseDifferentAddress();
            checkout.clickBillingContinue();
            Thread.sleep(2000);

            checkout.newShippingAddress();
            checkout.fillForm3(firstname, lastname, address, city);
            checkout.fillForm4(state, zip, country, telephone);
            checkout.clickShippingContinue();
            Thread.sleep(2000);

            checkout.clickShippingMethod();
            Thread.sleep(2000);

            checkout.selectCheck();
            checkout.clickPaymentContinue();
            Thread.sleep(2000);

            checkout.clickPlaceOrder();
            Thread.sleep(2000);

            checkout.verifyOrder();
            Thread.sleep(2000);

            checkout.getOrderId();

            TakesScreenshot screenshot =((TakesScreenshot)driver);
            File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
            String png = ("C:\\Users\\Anh Luan\\Pictures\\Screenshots\\testcase8.png");
            FileUtils.copyFile(srcFile, new File(png));

        }
        catch (Exception e){
            e.printStackTrace();
        }

        driver.quit();
    }
}
