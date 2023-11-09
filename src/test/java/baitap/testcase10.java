package baitap;

import POM.AdminPage;
import POM.OrdersPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.annotations.Test;
import driver.driverFactory;


import java.io.File;



/*
1. Go to http://live.techpanda.org/index.php/backendlogin
2. Login the credentials provided
3. Go to Sales-> Orders menu
4. Input OrderId and FromDate -> ToDate
5. Click Search button
6. Screenshot capture.

*/
@Test
public class testcase10 {
    public void testcase10() {
        String username = "user01";

        String password = "guru99com";
        String orderID = "100021185";
        String fromDate = "11/7/2023";
        String toDate = "11/9/2023";
        WebDriver driver = driverFactory.getChromeDriver();

        AdminPage admin = new AdminPage(driver);
        admin.loginAdminRole(username,password);
        admin.clearScreen();
        admin.gotoOrderMenu();

        OrdersPage orders = new OrdersPage(driver);
        orders.inputFill(orderID, fromDate, toDate);


        try {
            orders.clickSearch();
            Thread.sleep(3000);
            TakesScreenshot screenshot =((TakesScreenshot)driver);
            File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
            String png = ("C:\\Users\\Anh Luan\\Pictures\\Screenshots\\testcase10.png");
            FileUtils.copyFile(srcFile, new File(png));
        }catch (Exception e){
            e.printStackTrace();
        }
        driver.quit();
    }
}
