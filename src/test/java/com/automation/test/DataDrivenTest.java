package com.automation.test;

import com.automation.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTest extends BaseTest {

    @Test(dataProvider = "LoginData")
    public void verifyUserCanLogin(String username ,String password) {
        loginPage.openWebsite();
        loginPage.doLogin(username , password);

        Assert.assertTrue(homePage.isHomePageDisplayed());
    }

    @DataProvider(name = "LoginData")
    public Object[]  LoginDataProvider(){
        return new Object[][]{
                {       "standard_user" ,"secret_sauce"  },
                {       "problem_user"  ,"secret_sauce"  },
                {      "performance_glitch_user"  ,"secret_sauce" },
                {       "error_user" ,"secret_sauce"  },
                {       "visual_user" ,"secret_sauce" },

        };
    }
}
