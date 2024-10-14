package com.automation.test;

import com.automation.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

//1) Login
//2) Add all items into cart
//3) Navigate to Cart Page
//4) Navigate to Checkout page
//5) Confirm the order
//6) Click on back home
//7) Verify remove button is not displayed on the homepage


public class Test5  extends BaseTest{


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
        reviewPage.clickOnFinishBtn();
        Assert.assertTrue(orderConfirmationPage.isOrderConfirmationMsgDisplayed());

        reviewPage.clickOnHomeBtn();
        Assert.assertTrue(homePage.areRemoveButtonsNotDisplayed());
    }
}
