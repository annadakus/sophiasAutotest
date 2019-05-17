package com.sophiasstyle.page_factory;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.sophiasstyle.configure.BaseTest;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.*;

public class HomepagePage extends BaseTest {

    private final String ADD_TO_CART = "#product-addtocart-button";
    private SelenideElement popup = $(".add-confirm-btn");

    protected void openCategoryGirlsAccessories() {
        $x("//*[@class='dropdown-left level0 level-top dropdown'][last()-1]").click();
        System.out.println("Category is opened");
    }

    protected void selectItem(int number) {
        $x("//*[@class='category-item'][" + number + "]").click();
        $x("//*[@class='category-item'][" + number + "]//h2[@class='product-name']").click();
        System.out.println("Product page is opened");
    }


    @Step
    protected void openHomePage() {
        open("https://sophiasstyle.com/");
    }

    @Step
    protected void addToCart() {
        $(ADD_TO_CART).shouldBe(Condition.visible);
        $(ADD_TO_CART).click();
    }

    @Step
    protected void openShoppingCart() {
        $(".add-confirm-btn").waitUntil(Condition.visible, 15000).click();
    }

    @Step
    protected void checkCartPage() {
        $(".cart>h1").shouldHave(Condition.text("My Cart"));
        System.out.println("My Cart text is shown");
    }

    @Step
    protected void checkItemsTotal(String num) {
        $(".cart-items-total").shouldHave(Condition.text(num));
    }

    @Step
    protected void goToCheckoutPage() {
        $x("//button[@class=\'button btn-proceed-checkout btn-checkout\']").click();
    }

//    @Step
//    protected void fillOutGuestBillingAddress(String firstName, String lastName, String email,
//                                              String telephone, String address, String country,
//                                              String city, String state, String zipcode) {
//        $x("//input[@name='billing[firstname]']").setValue(firstName);
//        $x("//input[@name='billing[lastname]']").setValue(lastName);
//        $x("//input[@name='billing[email]']").setValue(email);
//        $x("//input[@name='billing[telephone]']").setValue(telephone);
//        $x("//*[@id='billing:street1']").setValue(address);
//        $x("//select[@name='billing[country_id]']").selectOption(country);
//        $x("//input[@name='billing[city]']").setValue(city);
//        $x("//input[@name='billing[city]']").scrollTo().$(".footer-left");
//        $x("//select[@name='billing[region_id]']").selectOption(state);
//        $x("//input[@name='billing[postcode]']").setValue(zipcode);
//    }

//    @Step
//    protected void fillOutLoggedBillingAddress(String firstName, String lastName,
//                                               String telephone, String address, String country,
//                                               String city, String state, String zipcode) {
//        $x("//input[@name='billing[firstname]']").setValue(firstName);
//        $x("//input[@name='billing[lastname]']").setValue(lastName);
//        $x("//input[@name='billing[telephone]']").setValue(telephone);
//        $x("//*[@id='billing:street1']").setValue(address);
//        $x("//select[@name='billing[country_id]']").selectOption(country);
//        $x("//input[@name='billing[city]']").setValue(city);
//        $x("//input[@name='billing[city]']").scrollTo().$(".footer-left");
//        $x("//select[@name='billing[region_id]']").selectOption(state);
//        $x("//input[@name='billing[postcode]']").setValue(zipcode);
//    }

    @Step
    protected void chooseShippingMethod() {
        $x("//label[@for='s_method_udropship_ne-expedited']").click();
    }

    @Step
    protected void choosePaymentMethod() throws InterruptedException {
        Thread.sleep(4000);
        $x("//label[@for='p_method_checkmo']").click();
    }

    @Step
    protected void placeOrderByGuest() {
        $x("//button[@class='button btn-checkout opc-btn-checkout']").shouldBe(Condition.visible);
        $x("//button[@class='button btn-checkout opc-btn-checkout']").click();
    }

    @Step
    protected void checkOrderConfirmationPage() {
        $(".modal-title").shouldHave(Condition.text("Love your items? Tell us why you bought them!"));
        $("#closeModalButton").click();
        $(".page-title").shouldHave(Condition.text("Your order has been received."));

    }

    @Step
    protected void login(String email, String password) {
        $x("//li[@class='dropdown account-nav']/a").waitUntil(Condition.visible, 15000).click();
        $("#mini-login").setValue(email);
        $("#mini-password").setValue(password);
        $x("//div[@class='actions']//button").click();
    }

    @Step
    protected void fillOutBillingAddress(String...strings) {
        $x("//input[@name='billing[firstname]']").setValue(strings[0]);
        $x("//input[@name='billing[lastname]']").setValue(strings[1]);

        int x = strings.length;
        if ( x == 9) {
            $x("//input[@name='billing[email]']").setValue(strings[2]);
            $x("//input[@name='billing[telephone]']").setValue(strings[3]);
            $x("//*[@id='billing:street1']").setValue(strings[4]);
            $x("//select[@name='billing[country_id]']").selectOption(strings[5]);
            $x("//input[@name='billing[city]']").setValue(strings[6]);
            $x("//input[@name='billing[city]']").scrollTo().$(".footer-left");
            $x("//select[@name='billing[region_id]']").selectOption(strings[7]);
            $x("//input[@name='billing[postcode]']").setValue(strings[8]);
        }else{
            $x("//input[@name='billing[telephone]']").setValue(strings[2]);
            $x("//*[@id='billing:street1']").setValue(strings[3]);
            $x("//select[@name='billing[country_id]']").selectOption(strings[4]);
            $x("//input[@name='billing[city]']").setValue(strings[5]);
            $x("//input[@name='billing[city]']").scrollTo().$(".footer-left");
            $x("//select[@name='billing[region_id]']").selectOption(strings[6]);
            $x("//input[@name='billing[postcode]']").setValue(strings[7]);
        }


    }
}

