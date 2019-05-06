package com.sophiasstyle.tests;

import com.codeborne.selenide.SelenideElement;
import com.sophiasstyle.page_factory.HomepagePage;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.$;

public class LoggedInCheckoutTest extends HomepagePage {

    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void loggedInUserCheckout() throws InterruptedException {
        openHomePage();
        openCategoryGirlsAccessories();
        login("test7.user7@gmail.com", "1111abcd1111Q");
        openCategoryGirlsAccessories();
        selectItem(1);

        addToCart();
        openShoppingCart();
        goToCheckoutPage();
        SelenideElement address = $("#billing-address-select");
        Thread.sleep(5000);
        if (!address.exists()) {
            fillOutBillingAddress("Anna", "Test",
                    "0956785432",
                    "517 Test street", "United States", "Test",
                    "Nebraska", "69101");
        }
        chooseShippingMethod();
        choosePaymentMethod();
        placeOrderByGuest();
        checkOrderConfirmationPage();


    }
}
