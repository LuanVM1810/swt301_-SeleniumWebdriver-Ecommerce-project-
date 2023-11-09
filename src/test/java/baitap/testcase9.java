package baitap;

import POM.CartPage;
import POM.LoginPage;
import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
/*  Verify Discount Coupon works correctly

Test Case Description:

1. Go to http://live.techpanda.org/

2. Go to Mobile and add IPHONE to cart

3. Enter Coupon Code

4. Verify the discount generated

TestData:  Coupon Code: GURU50

Expected result:

1) Price is discounted by 5%

*/
@Test
public class testcase9 {
    public void testcase9() {
        WebDriver driver = driverFactory.getChromeDriver();

        LoginPage login = new LoginPage(driver);
        login.clickMobile();
        login.addToCard();

        CartPage cart = new CartPage(driver);
        cart.enterCoupon();

        // Verify the discount generated
        WebElement subTotal = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/span[1]"));
        WebElement grandTotal = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/table[1]/tfoot[1]/tr[1]/td[2]/strong[1]/span[1]"));
//        if(subTotal.getText().equalsIgnoreCase(grandTotal.getText())){
//
//        }
//        AssertJUnit.assertEquals(subTotal.getText(),grandTotal.getText());
        Assert.assertNotEquals(subTotal.getText(),grandTotal.getText());
    }
}
