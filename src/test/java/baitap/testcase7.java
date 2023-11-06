package baitap;

import org.testng.annotations.Test;

/*Verify that you will be able to save previously placed order as a pdf file

Test Steps:

1. Go to http://live.techpanda.org/

2. Click on My Account link

3. Login in application using previously created credential

4. Click on 'My Orders'

5. Click on 'View Order'

6. Click on 'Print Order' link*/
@Test
public class testcase7 {
    public static void main() {
        Login login = new Login();
        login.goChromeLink("http://live.techpanda.org/");
        login.clickMyAccount();
        login.fillInforLogin();
        login.clickMyOrders();
        login.clickViewOrders();
        login.printOrders();
    }
}
