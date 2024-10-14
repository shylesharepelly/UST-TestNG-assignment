package com.automation.test;

import com.automation.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


//1) Login
//2) Sort product from Z to A
//3) Verify product sorted by z to a



public class Test1  extends BaseTest{


    @Test
    public void verifyItemsSortedAlphabetically() {
        loginPage.openWebsite();
        loginPage.doLogin(ConfigReader.getConfigValue("login.username"), ConfigReader.getConfigValue("login.password"));
        Assert.assertTrue(homePage.isHomePageDisplayed());
        List<String> Items = homePage.getAllItemsNames();
        System.out.println(Items);
        homePage.SortByDescendingOrder();
        List<String> sortedItems = homePage.getAllItemsNames();
        System.out.println(sortedItems);
        List<String> expectedSortedItems = new ArrayList<>(Items);
        expectedSortedItems.sort(Comparator.reverseOrder());

        Assert.assertEquals(sortedItems, expectedSortedItems, "Items are not sorted correctly from Z to A.");


    }
}
