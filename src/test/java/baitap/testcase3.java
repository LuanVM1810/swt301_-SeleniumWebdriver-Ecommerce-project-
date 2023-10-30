//        1. Go to http://live.techpanda.org/
//
//        2. Click on �MOBILE� menu
//
//        3. In the list of all mobile , click on �ADD TO CART� for Sony Xperia mobile
//
//        4. Change �QTY� value to 1000 and click �UPDATE� button. Expected that an error is displayed
//
//        "The requested quantity for "Sony Xperia" is not available.
//
//        5. Verify the error message
//
//        6. Then click on �EMPTY CART� link in the footer of list of all mobiles. A message "SHOPPING CART IS EMPTY" is shown.
//
//        7. Verify cart is empty
package baitap;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

@Test
public class testcase3 {
    public static void main() {
        // Create instance of Chrome Driver
        WebDriver driver = driverFactory.getChromeDriver();
        // Step 1. Go to the URL
        driver.get("http://live.techpanda.org/");
        // Step 2: Click on Mobile menu
        WebElement mobileMenu = driver.findElement(By.linkText("MOBILE"));
        mobileMenu.click();
        // Step 3: In the list of all mobile , click on �ADD TO CART� for Sony Xperia mobile
        WebElement addToCart = driver.findElement(By.xpath("//li[2]//div[1]//div[3]//button[1]//span[1]//span[1]"));
        addToCart.click();
        // Step 4: Change �QTY� value to 1000 and click �UPDATE� button. Expected that an error is display
        // "The requested quantity for "Sony Xperia" is not available.
        WebElement qty = driver.findElement(By.xpath("//input[@title='Qty']"));
        qty.click();
        qty.clear();
        qty.sendKeys("1000");
        WebElement udateButton = driver.findElement(By.xpath("//button[@title='Update']//span//span[contains(text(),'Update')]"));
        udateButton.click();

        // Step 5: Verify error message
        String expected1000QTY = "\"The requested quantity for \"Sony Xperia\" is not available";
        String actual1000QTY = driver.findElement(By.xpath("//p[@class='item-msg error']")).getText().trim();
        AssertJUnit.assertEquals(expected1000QTY, actual1000QTY);

        // Step 6:Then click on �EMPTY CART� link in the footer of list of all mobiles. A message "SHOPPING CART IS EMPTY" is shown.
        WebElement emptyCart = driver.findElement(By.xpath("//span[contains(text(),'Empty Cart')]"));
        emptyCart.click();

        // Step 7: Verify cart is empty
        String expectedCart = "SHOPPING CART IS EMPTY";
        String actualCart = driver.findElement(By.xpath("//h1[normalize-space()='Shopping Cart is Empty']")).getText().trim();
        AssertJUnit.assertEquals(expectedCart, actualCart);

    }

}
