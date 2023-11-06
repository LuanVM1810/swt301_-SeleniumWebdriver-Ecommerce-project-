package baitap;
/*  Verify you are able to change or reorder previously added product

        *  Test Data = QTY = 10

        Test Steps:

        1. Go to http://live.techpanda.org/

        2. Click on my account link

        3. Login in application using previously created credential

        4. Click on 'REORDER' link , change QTY & click Update

        5. Verify Grand Total is changed

        6. Complete Billing & Shipping Information

        7. Verify order is generated and note the order number

        Expected outcomes:

        1) Grand Total is Changed

        2) Order number is generated*/

import org.testng.annotations.Test;

@Test
public class testcase8 {
    public static void main() {
        Login login = new Login();
        login.goChromeLink("http://live.techpanda.org/");
        login.clickMyAccount();
        login.fillInforLogin();
        login.clickReorder();
        login.verifyChangeTotal();
        login.clickCheckout();
        login.enterBillInfor();
        login.clickContinueShippingMethod();
        login.checkMoneyOrder();
        login.clickPlaceOrder();
        login.noteOrderNumber();
    }
}
