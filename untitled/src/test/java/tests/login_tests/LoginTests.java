package tests.login_tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.base_test.BaseTest;


import static constants.Constant.Urls.BASE_URL;

public class LoginTests extends BaseTest {

    // Параметризация теста с помощью DataProvider
    @DataProvider(name = "logins")
    public static Object[][] logins(){
        return new Object[][] {
                { "standard_user" },
                { "problem_user" },
                { "performance_glitch_user" },
                { "error_user" },
                { "visual_user" }
        };
    }
    // Тест корректная авторизация
    @Test(dataProvider="logins")
    public void correctLogin(String param){
        basePage.open(BASE_URL);
        loginPage.logIn(param);
        Assert.assertTrue(loginPage.checkLogin());
    }
}
