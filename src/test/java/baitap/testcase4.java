/*

Test Steps:

1. Go to http://live.techpanda.org/

2. Click on �MOBILE� menu

3. In mobile products list , click on �Add To Compare� for 2 mobiles (Sony Xperia & Iphone)

4. Click on �COMPARE� button. A popup window opens

5. Verify the pop-up window and check that the products are reflected in it

Heading "COMPARE PRODUCTS" with selected products in it.

6. Close the Popup Windows

*/
package baitap;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

@Test
public class testcase4 {
    public static void main() {
        // Create instance of Chrome Driver
        WebDriver driver = driverFactory.getChromeDriver();
        // Step 1. Go to the URL
        driver.get("http://live.techpanda.org/");
        // Step 2: Click on Mobile menu
        WebElement mobileMenu = driver.findElement(By.linkText("MOBILE"));
        mobileMenu.click();
        // Step 3: In mobile products list , click on �Add To Compare� for 2 mobiles (Sony Xperia & Iphone)
        // Click compare Sony Xperia
        WebElement compareSony = driver.findElement(By.xpath("//li[2]//div[1]//div[3]//ul[1]//li[2]//a[1]"));
        compareSony.click();
        //Click compare Iphone
        WebElement compareIphone = driver.findElement(By.xpath("//li[3]//div[1]//div[3]//ul[1]//li[2]//a[1]"));
        compareIphone.click();
        // Step 4: Click on �COMPARE� button. A popup window opens
        WebElement compareTwoProducts = driver.findElement(By.xpath("//button[@title='Compare']//span//span[contains(text(),'Compare')]"));
        compareTwoProducts.click();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        // Step 5: Verify the pop-up window and check that the products are reflected in it
        //Heading "COMPARE PRODUCTS" with selected products in it.
        String expectedTitle = "COMPARE PRODUCTS";
        WebElement actualTitle = driver.findElement(By.xpath("//h1[normalize-space()='Compare Products']"));
        AssertJUnit.assertEquals(expectedTitle,actualTitle.getText());
        // Step 6: Close the Popup Windows
        WebElement closePopup = driver.findElement(By.xpath("//span[contains(text(),'Close Window')]"));
        closePopup.click();
    }
}
