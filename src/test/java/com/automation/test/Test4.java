package com.automation.test;

import com.automation.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;


//1) Login
//2) Add all items into cart
//3) Verify cart icon quantity is equals to items you added in the cart
//4) Navigate to Cart Page
//5) Navigate to Checkout page
//6) Verify total price is correct (it is equals to each item total and tax)

public class Test4  extends BaseTest {

    @Test
    public void verifyUserCanPlaceOrder() {
        loginPage.openWebsite();
        loginPage.doLogin(ConfigReader.getConfigValue("login.username"), ConfigReader.getConfigValue("login.password"));

        Assert.assertTrue(homePage.isHomePageDisplayed());
        homePage.clickOnAddToCartAllItems();
        homePage.clickOnShoppingCartLink();

        Assert.assertTrue(cartPage.isCartPageDisplayed());

        cartPage.clickOnCheckoutBtn();

        Assert.assertTrue(checkoutPage.isCheckoutPageDisplayed());
        checkoutPage.fillShippingInfo();
        checkoutPage.clickOnContinueBtn();

        Assert.assertTrue(reviewPage.isReviewPageDisplayed());

        String price = reviewPage.priceDisplayed();

        String totalPrice = price.replaceAll("[^\\d.]", ""); // Removes all non-numeric characters except for '.'

        double totalAmount = Double.parseDouble(totalPrice);
        Assert.assertEquals(totalAmount , 140.34);
    }

}
