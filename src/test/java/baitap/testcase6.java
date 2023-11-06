package baitap;

/* Verify user is able to purchase product using registered email id (USE CHROME BROWSER)

Test Steps:

1. Go to http://live.techpanda.org/

2. Click on my account link

3. Login in application using previously created credential

4. Click on MY WISHLIST link

5. In next page, Click ADD TO CART link

6. Enter general shipping country, state/province and zip for the shipping cost estimate

7. Click Estimate

8. Verify Shipping cost generated

9. Select Shipping Cost, Update Total

10. Verify shipping cost is added to total

11. Click "Proceed to Checkout"

12a. Enter Billing Information, and click Continue

12b. Enter Shipping Information, and click Continue

13. In Shipping Method, Click Continue

14. In Payment Information select 'Check/Money Order' radio button. Click Continue

15. Click 'PLACE ORDER' button

16. Verify Oder is generated. Note the order number*/

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

@Test
public class testcase6 {
    public static void main() {
        // Step 1: Go to http://live.techpanda.org/
       Login newLogin = new Login();
       newLogin.goChromeLink("http://live.techpanda.org/");
        // Step 2: Click on my account link
        newLogin.clickMyAccount();
        // Step 3: Login in application using previously created credential
        newLogin.fillInforLogin();
        // Step 4: Click on MY WISHLIST link
        newLogin.clickWishlist();
        // Step 5: In next page, Click ADD TO CART link
        newLogin.addToCart();
        // Step 6: Enter general shipping country, state/province and zip for the shipping cost estimate
        newLogin.enterToShipping();
        // Step 7: Click estimate
        newLogin.clickEstimate();
        // Step 8: Verify Shipping cost generated
        // Step 9: Select Shipping Cost, Update Total
        // Step 10: Verify shipping cost is added to total
        // Step 11: Click "Proceed to Checkout"
        newLogin.clickCheckout();
        // Step 12a: Enter Billing Information, and click Continue
        // Step 12b: Enter Shipping Information, and click Continue
        newLogin.enterBillInfor();
        // Step 13: In Shipping Method, Click Continue
        newLogin.clickContinueShippingMethod();
        // Step 14: In Payment Information select 'Check/Money Order' radio button. Click Continue
        newLogin.checkMoneyOrder();
        // Step 15: Click 'PLACE ORDER' button
        newLogin.clickPlaceOrder();
        // Step 16: Verify Oder is generated. Note the order number*/
        newLogin.noteOrderNumber();
    }
}
