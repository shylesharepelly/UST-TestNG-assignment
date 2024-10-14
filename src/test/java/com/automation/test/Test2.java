package com.automation.test;

import com.automation.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

//1) Login
//2) Sort product from price high to low
//3) Verify product sorted by price


public class Test2  extends BaseTest{


    @Test
    public void verifyItemsSorted() {
        loginPage.openWebsite();
        loginPage.doLogin(ConfigReader.getConfigValue("login.username"), ConfigReader.getConfigValue("login.password"));

        Assert.assertTrue(homePage.isHomePageDisplayed());


        List<Double> prices = homePage.getAllItemsPrices().stream()
                .map(price -> Double.parseDouble(price.replace("$", "").trim())) // Adjust this if your price format is different
                .collect(Collectors.toList());
        System.out.println(prices);

        homePage.SortByHighPrice();
        List<Double> sortedPrices = homePage.getAllItemsPrices().stream()
                .map(price -> Double.parseDouble(price.replace("$", "").trim())) // Adjust this if needed
                .collect(Collectors.toList());
        System.out.println(sortedPrices);

        List<Double> expectedSortedPrices = new ArrayList<>(prices);
        expectedSortedPrices.sort(Comparator.reverseOrder());

        Assert.assertEquals(sortedPrices, expectedSortedPrices, "Items are not sorted correctly from Z to A.");




    }
}
