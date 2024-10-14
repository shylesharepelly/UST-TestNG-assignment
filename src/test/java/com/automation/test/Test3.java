package com.automation.test;

import com.automation.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLOutput;

//1) Login
//2) Add all items into cart
//3) Verify cart icon quantity is equals to items you added in the cart
//4) Navigate to Cart Page
//5) Verify on cart page total items equals to items you added in the cart


public class Test3  extends BaseTest{


    @Test
    public void verifyCartCount() {
        loginPage.openWebsite();
        loginPage.doLogin(ConfigReader.getConfigValue("login.username"), ConfigReader.getConfigValue("login.password"));

        Assert.assertTrue(homePage.isHomePageDisplayed());
        homePage.clickOnAddToCartAllItems();
        String count = homePage.shoppingCartItemsCount();
        int expectedItemCount = Integer.parseInt(count.trim());
        homePage.clickOnShoppingCartLink();

        Assert.assertTrue(cartPage.isCartPageDisplayed());
        cartPage.cartItemsCount();
        int actualItemCount = cartPage.cartItemsCount();
        Assert.assertEquals(actualItemCount, expectedItemCount, "The cart should contain 6 items.");

    }
}
