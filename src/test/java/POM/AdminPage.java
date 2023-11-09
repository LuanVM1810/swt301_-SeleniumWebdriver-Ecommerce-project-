package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminPage {
    private WebDriver driver;

    public AdminPage(WebDriver driver) {
        this.driver = driver;
        driver.get("http://live.techpanda.org/index.php/backendlogin");
    }

    public void loginAdminRole(String username, String password){
        WebElement usernameButton = driver.findElement(By.xpath("//input[@id='username']"));
        usernameButton.clear();
        usernameButton.sendKeys(username);

        WebElement passButton = driver.findElement(By.xpath("//input[@id='login']"));
        passButton.clear();
        passButton.sendKeys(password);

        WebElement loginButton = driver.findElement(By.xpath("//input[@title='Login']"));
        loginButton.click();
    }

    public void clearScreen(){
        WebElement clrs = driver.findElement(By.xpath("//span[normalize-space()='close']"));
        clrs.click();
    }

    public void gotoOrderMenu(){
        WebElement sales = driver.findElement(By.xpath("//span[normalize-space()='Sales']"));
        sales.click();

        WebElement orders = driver.findElement(By.xpath("//span[normalize-space()='Orders']"));
        orders.click();
    }
}
