/* Verify can create an account in e-Commerce site and can share wishlist to other poeple using email.

Test Steps:

1. Go to http://live.techpanda.org/

2. Click on my account link

3. Click Create an Account link and fill New User information excluding the registered Email ID.

4. Click Register

5. Verify Registration is done. Expected account registration done.

6. Go to TV menu

7. Add product in your wish list - use product - LG LCD

8. Click SHARE WISHLIST

9. In next page enter Email and a message and click SHARE WISHLIST

10.Check wishlist is shared. Expected wishlist shared successfully.*/
package baitap;


import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import POM.RegisterPage;
import org.testng.asserts.Assertion;


@Test
public class testcase5 {
    public static void main() {
        WebDriver driver = driverFactory.getChromeDriver();
        String firstname = "Vo";
        String lastname = "Luan";
        String email = "vomongluan1@gmail.com";
        String password = "luan123456";
        String confirm = "luan123456";

        try {
            // Step 1: Go to link
            RegisterPage page = new RegisterPage(driver);

            // Step 2: Click on my account link
            page.goToMyAccount();
            Thread.sleep(2000);

            // Step 3: Click Create an Account link
            page.createAccount();
            Thread.sleep(2000);

            // fill New User information excluding the registered Email ID.
            page.fillFirstName(firstname);
            page.fillLastName(lastname);
            page.fillEmail(email);
            page.fillPassword(password);
            page.fillConfirm(confirm);
            Thread.sleep(2000);

            // Step 4: Click Register
            page.clickRegister();
            Thread.sleep(2000);

            //S Step 5: Verify Registration is done. Expected account registration done.
            WebElement registration = driver.findElement(By.xpath("//span[normalize-space()='Thank you for registering with Main Website Store.']"));
            String expectedRegistration = "Thank you for registering with Main Website Store.";
            Assert.assertEquals(registration.getText() ,expectedRegistration);
            System.out.println("Registration done!");

            // Step 6: Go to TV menu
            driver.findElement(By.linkText("TV")).click();
            Thread.sleep(2000);

            // Step 7: Add product (e.g., LG LCD) to your wish list
            driver.findElement(By.xpath("//a[contains(text(),'LG LCD')]//following::a[text()='Add to Wishlist']")).click();
            Thread.sleep(2000);

            // Step 8: Click 'SHARE WISHLIST'
            driver.findElement(By.xpath("//span[contains(text(),'Share Wishlist')]")).click();

            // Step 9: Enter Email and a message and click 'SHARE WISHLIST'
            driver.findElement(By.id("email_address")).sendKeys(email);
            driver.findElement(By.id("message")).sendKeys("Share wishlist!");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//button[@title='Share Wishlist']")).click();

            // Step 10: Check wishlist is shared
            WebElement share = driver.findElement(By.xpath("//span[normalize-space()='Your Wishlist has been shared.']"));
            String expectedShare = "Your Wishlist has been shared.";
            Assert.assertEquals(share.getText(), expectedShare);
            System.out.println("Wishlist shared successfully!");
            Thread.sleep(2000);

        } catch (Exception e){
            e.printStackTrace();
        }

        driver.quit();
    }
}
