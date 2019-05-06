package com.sophiasstyle.tests;

import com.sophiasstyle.page_factory.HomepagePage;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.Test;

public class GuestCheckoutTest extends HomepagePage {

    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void guestCheckoutTest() throws InterruptedException {
        openHomePage();
        openCategoryGirlsAccessories();
        selectItem(1);
        addToCart();
        openShoppingCart();
        checkCartPage();
        checkItemsTotal("1");
        goToCheckoutPage();
        fillOutBillingAddress("Anna", "Test",
                "test7.user7@gmail.com", "0956785432",
                "517 Test street", "United States", "Test",
                "Nebraska", "69101");
        chooseShippingMethod();
        choosePaymentMethod();
        placeOrderByGuest();
        checkOrderConfirmationPage();
    }
}
