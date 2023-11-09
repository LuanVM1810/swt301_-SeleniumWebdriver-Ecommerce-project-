package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrdersPage {
    private WebDriver driver;

    public OrdersPage(WebDriver driver) {
        this.driver = driver;
    }

    public void inputFill(String orderID, String fromDate, String toDate){
        WebElement orderId = driver.findElement(By.xpath("//input[@id='sales_order_grid_filter_real_order_id']"));
        orderId.clear();
        orderId.sendKeys(orderID);

        WebElement fromDateBtn = driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(5) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > table:nth-child(1) > thead:nth-child(2) > tr:nth-child(2) > th:nth-child(3) > div:nth-child(1) > div:nth-child(1) > input:nth-child(2)"));
        fromDateBtn.clear();
        fromDateBtn.sendKeys(fromDate);

        WebElement toDateBtn = driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(5) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > table:nth-child(1) > thead:nth-child(2) > tr:nth-child(2) > th:nth-child(3) > div:nth-child(1) > div:nth-child(2) > input:nth-child(2)"));
        toDateBtn.clear();
        toDateBtn.sendKeys(toDate);
    }

    public void clickSearch(){
        WebElement searchBtn = driver.findElement(By.xpath("//span[contains(text(),'Search')]"));
        searchBtn.click();
    }
}
