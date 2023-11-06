package baitap;

import driver.driverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.io.File;

public class Login {
    private String email;
    private String password;

    private WebDriver driver;

    public Login(){
        this.email = "vomongluan@gmail.com";
        this.password = "luan123456";
        this.driver = driverFactory.getChromeDriver();
    }

    public void goChromeLink(String url){
        driver.get(url);
    }
    public void clickMyAccount(){
        WebElement account = driver.findElement(By.xpath("//a[@class='skip-link skip-account']"));
        account.click();
        WebElement myAccount = driver.findElement(By.xpath("//div[@id='header-account']//a[@title='My Account'][normalize-space()='My Account']"));
        myAccount.click();
    }

    public void fillInforLogin(){
        WebElement txtEmail = driver.findElement(By.xpath("//input[@id='email']"));
        txtEmail.clear();
        txtEmail.sendKeys(this.email);
        WebElement txtPassword = driver.findElement(By.xpath("//input[@id='pass']"));
        txtPassword.clear();
        txtPassword.sendKeys(this.password);
        WebElement btnLogin = driver.findElement(By.xpath("//button[@id='send2']"));
        btnLogin.click();
    }

    public void clickWishlist(){
        WebElement btnWishlist = driver.findElement(By.xpath("//div[@class='block-content']//a[normalize-space()='My Wishlist']"));
        btnWishlist.click();
    }

    public void addToCart(){
        WebElement btnAddToCart = driver.findElement(By.xpath("//span[contains(text(),'Add to Cart')]"));
        btnAddToCart.click();
    }

    public void enterToShipping() {
        WebElement countryDropdown = driver.findElement(By.xpath("//select[@id='country']"));
        Select selectOption = new Select(countryDropdown);
        //select options in dropdown list by Text
        selectOption.selectByVisibleText("United States");

        WebElement stateDropdown = driver.findElement(By.xpath("//select[@id='region_id']"));
        Select selectState = new Select(stateDropdown);
        selectState.selectByVisibleText("Florida");

        WebElement zip = driver.findElement(By.xpath("//input[@id='postcode']"));
        zip.clear();
        zip.sendKeys("2000");
    }
    public void clickEstimate(){
        WebElement btnEstimate = driver. findElement(By.xpath("//span[contains(text(),'Estimate')]"));
        btnEstimate.click();

        WebElement flatRate = driver.findElement(By.xpath("//label[@for='s_method_flatrate_flatrate']"));
        flatRate.click();

        WebElement updateTotal = driver.findElement(By.xpath("//span[contains(text(),'Update Total')]"));
        updateTotal.click();
    }

    public void clickCheckout(){
        WebElement checkout = driver.findElement(By.xpath("//li[@class='method-checkout-cart-methods-onepage-bottom']//button[@title='Proceed to Checkout']//span//span[contains(text(),'Proceed to Checkout')]"));
        checkout.click();
    }

    public void enterBillInfor(){

//        WebElement dropdownElement = driver.findElement(By.xpath("//select[@id='billing-address-select']"));
//        //4. Init a Select Option instance
//        Select selectOption = new Select(dropdownElement);
//
//        //select options in dropdown list by Text
//        selectOption.selectByVisibleText("New Address");
//
//
//
//
//        WebElement address = driver.findElement(By.xpath("//input[@id='billing:street1']"));
//        address.clear();
//        address.sendKeys(address1);
//
//        WebElement city = driver.findElement(By.xpath("//input[@id='billing:city']"));
//        city.clear();
//        city.sendKeys(city1);
//
//        WebElement stateDropdown = driver.findElement(By.xpath("//select[@id='billing:region_id']"));
//        Select stateOption = new Select(stateDropdown);
//        //select options in dropdown list by Text
//        stateOption.selectByVisibleText("Florida");
//
//        WebElement countryDropdown = driver.findElement(By.xpath("//select[@id='billing:country_id']"));
//        Select countryOption = new Select(countryDropdown);
//        //select options in dropdown list by Text
//        countryOption.selectByVisibleText("United States");
//
//        WebElement telephone = driver.findElement(By.xpath("//input[@id='billing:telephone']"));
//        telephone.clear();
//        telephone.sendKeys(telephone1);
//
//        WebElement btnContinue = driver.findElement(By.xpath("//button[@onclick='billing.save()']//span//span[contains(text(),'Continue')]"));
//        btnContinue.click();

        WebElement btnContinue = driver.findElement(By.xpath("//button[@onclick='billing.save()']//span//span[contains(text(),'Continue')]"));
        btnContinue.click();
        try {
            Thread.sleep(2000);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void clickContinueShippingMethod(){
        WebElement btnContinueShipping = driver.findElement(By.xpath("//button[@onclick='shippingMethod.save()']//span//span[contains(text(),'Continue')]"));
        btnContinueShipping.click();
        try {
            Thread.sleep(2000);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void checkMoneyOrder(){
        WebElement checkMoney = driver.findElement(By.xpath("//label[@for='p_method_checkmo']"));
        checkMoney.click();

        WebElement btnContinue = driver.findElement(By.xpath("//button[@onclick='payment.save()']"));
        btnContinue.click();
        try {
            Thread.sleep(2000);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void clickPlaceOrder(){
        WebElement btnPlaceOrder = driver.findElement(By.xpath("//span[contains(text(),'Place Order')]"));
        btnPlaceOrder.click();
        try {
            Thread.sleep(2000);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void noteOrderNumber(){
        WebElement orderNumber = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/p[1]/a[1]"));
        System.out.println(orderNumber.getText());

        int scc=1;
        try{
            File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            String png = ("C:\\Users\\Anh Luan\\Pictures\\Screenshots\\verifyOrderNumber") + scc + ".png";
            FileUtils.copyFile(srcFile, new File(png));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void clickMyOrders(){
        WebElement myOrder = driver.findElement(By.xpath("//a[normalize-space()='My Orders']"));
        myOrder.click();
    }

    public void clickViewOrders(){
        WebElement viewOrder = driver.findElement(By.xpath("//a[normalize-space()='View Order']"));
        viewOrder.click();
    }

    public void printOrders(){
        WebElement printOrders = driver.findElement(By.xpath("//a[@class='link-print']"));
        printOrders.click();
    }

    public void clickReorder(){
        WebElement clickReorder = driver.findElement(By.xpath("//a[@class='link-reorder']"));
        clickReorder.click();

        WebElement changeQTY = driver.findElement(By.xpath("//input[@title='Qty']"));
        changeQTY.clear();
        changeQTY.sendKeys("10");

        WebElement btnUpdate = driver.findElement(By.xpath("//button[@title='Update']"));
        btnUpdate.click();
    }

    public void verifyChangeTotal(){
        int scc=1;
        try{
            File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            String png = ("C:\\Users\\Anh Luan\\Pictures\\Screenshots\\verifyChangeGTotal") + scc + ".png";
            FileUtils.copyFile(srcFile, new File(png));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}


