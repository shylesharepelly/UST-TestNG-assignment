package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReviewPage extends BasePage {

    @FindBy(id = "finish")
    WebElement finishBtn;

    @FindBy(className = "summary_total_label")
    WebElement totalPrice;

    @FindBy(id = "back-to-products")
    WebElement homebtn;

    public boolean isReviewPageDisplayed() {
        return finishBtn.isDisplayed();
    }
    public String priceDisplayed(){
        return totalPrice.getText();
    }

    public void clickOnFinishBtn() {
        finishBtn.click();
    }

    public void clickOnHomeBtn() {
        homebtn.click();
    }
}
