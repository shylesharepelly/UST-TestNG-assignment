package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage{

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    WebElement shoppingCartLink;

    @FindBy(className = "product_sort_container")
    WebElement filterOptions;

    @FindBy(xpath = "//button[contains(@id,'add-to-cart')]")
    List<WebElement> addToCartBtnList;

    @FindBy(xpath = "//button[contains(text(), 'Remove')]\n")
    List<WebElement> removeBtns;

    @FindBy(className = "inventory_item_name")
    List<WebElement> aLLItemsNames;

    @FindBy(className = "inventory_item_price")
    List<WebElement> allItemPrices;

    public boolean isHomePageDisplayed() {
        return shoppingCartLink.isDisplayed();
    }

    public void clickOnAddToCartOfFirstItem() {
        addToCartBtnList.get(0).click();
    }

    public void clickOnAddToCartAllItems() {

        for (WebElement button : addToCartBtnList) {
            button.click();
        }
    }

    public List<String> getAllItemsNames() {

        List<String> itemNames = new ArrayList<>();
        for (WebElement item : aLLItemsNames) {
            itemNames.add(item.getText());
        }
        return itemNames;
    }

    public List<String> getAllItemsPrices() {

        List<String> itemPrices = new ArrayList<>();
        for (WebElement item : allItemPrices) {
            itemPrices.add(item.getText());
        }
        return itemPrices;
    }




    public void clickOnShoppingCartLink() {
        shoppingCartLink.click();
    }

    public String shoppingCartItemsCount() {
        return  shoppingCartLink.getText();
    }


    public void SortByDescendingOrder(){
        Select options = new Select(filterOptions);
        options.selectByVisibleText("Name (Z to A)");

    }
    public void SortByHighPrice(){
        Select options = new Select(filterOptions);
        options.selectByVisibleText("Price (high to low)");

    }

    public boolean areRemoveButtonsNotDisplayed() {
        return removeBtns.isEmpty();
    }




}
