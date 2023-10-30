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
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

@Test
public class testcase5 {
    public static void main() {
        // Create instance of Chrome Driver
        WebDriver driver = driverFactory.getChromeDriver();
        // Step 1. Go to the URL
        driver.get("http://live.techpanda.org/");
        // Step 2: Click on My Account link
        WebElement myAccount = driver.findElement(By.xpath("//span[@class='label'][normalize-space()='Account']"));
        myAccount.click();
        WebElement myAccountDetails = driver.findElement(By.xpath("//div[@id='header-account']//a[@title='My Account'][normalize-space()='My Account']"));
        myAccountDetails.click();
        // Step 3: Click Create an Account link and fill New User information excluding the registered Email ID.
        WebElement createAccount = driver.findElement(By.xpath("//a[@title='Create an Account']"));
        createAccount.click();

        //Create user
        User luan = new User("Vo", "Mong", "Luan",
                "vomongluan@gmail.com","luan123456","luan123456");

        WebElement firstName = driver.findElement(By.xpath("//input[@id='firstname']"));
        firstName.click();
        firstName.sendKeys(luan.getFirstName());

        WebElement middleName = driver.findElement(By.xpath("//input[@id='middlename']"));
        middleName.click();
        middleName.sendKeys(luan.getMiddleName());

        WebElement lastName = driver.findElement(By.xpath("//input[@id='lastname']"));
        lastName.click();
        lastName.sendKeys(luan.getLastName());

        WebElement email = driver.findElement(By.xpath("//input[@id='email_address']"));
        email.click();
        email.sendKeys(luan.getEmail());

        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.click();
        password.sendKeys(luan.getPassword());

        WebElement confirmPassword = driver.findElement(By.xpath("//input[@id='confirmation']"));
        confirmPassword.click();
        confirmPassword.sendKeys(luan.getConfirmPassword());

        WebElement newSletter = driver.findElement(By.xpath("//label[@for='is_subscribed']"));
        newSletter.click();

        // Step 4: Click Register
        WebElement registerButton = driver.findElement(By.xpath("//button[@title='Register']"));
        registerButton.click();

        // Step 5: Verify Registration is done. Expected account registration done.
        String expectedRegistration = "Thank you for registering with Main Website Store.";
        String actualRegistration = driver.findElement(By.xpath("//span[normalize-space()='Thank you for registering with Main Website Store.']")).getText();
        AssertJUnit.assertEquals(expectedRegistration,actualRegistration);

        // Step 6: Go to TV menu
        WebElement tvMenu = driver.findElement(By.xpath("//a[normalize-space()='TV']"));
        tvMenu.click();

        // Step 7: Add product in your wish list - use product - LG LCD
        WebElement addWishlist = driver.findElement(By.xpath("//li[1]//div[1]//div[3]//ul[1]//li[1]//a[1]"));
        addWishlist.click();
        // Step 8: Click SHARE WISHLIST
        WebElement shareWishlist = driver.findElement(By.xpath("//span[contains(text(),'Share Wishlist')]"));
        shareWishlist.click();
        // Step 9: In next page enter Email and a message and click SHARE WISHLIST
        WebElement enterEmail = driver.findElement(By.xpath("//textarea[@id='email_address']"));
        enterEmail.click();
        enterEmail.sendKeys("Vomongluan@gmail.com");
        WebElement message = driver.findElement(By.xpath("//textarea[@id='message']"));
        message.click();
        message.sendKeys("This is a LG LCD, I want to share for you");
        // Step 10: Check wishlist is shared. Expected wishlist shared successfully
        WebElement shareButton = driver.findElement(By.xpath("//span[contains(text(),'Share Wishlist')]"));
        shareButton.click();

        String expectedShareWishList = "Your Wishlist has been shared.";
        String actualShareWishlist = driver.findElement(By.xpath("//span[normalize-space()='Your Wishlist has been shared.']")).getText().trim();
    }
}
