package tests.login_tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.base_test.BaseTest;
import static constants.Constant.StandardUser.STANDARD_LOGIN;
import static constants.Constant.StandardUser.STANDARD_PASSWORD;
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
    @Test(
            dataProvider="logins",
            description="Корректная авторизация",
            groups="smoke")
    public void correctLogin(String logins){
        basePage.open(BASE_URL);
        loginPage.logIn(logins, STANDARD_PASSWORD);
        Assert.assertFalse(loginPage.checkLogin(), "Пользователь остался на странице авторизации");
    }
    @DataProvider(name = "wrong_creds")
    public static Object[][] wrong_creds(){
        return new Object[][]{
                { STANDARD_LOGIN.substring(0, STANDARD_LOGIN.length() - 1), STANDARD_PASSWORD },
                { STANDARD_LOGIN, STANDARD_PASSWORD.substring(0, STANDARD_PASSWORD.length() - 1) }
        };
    }

    // Авторизация с некорректным логином или паролем
    @Test(dataProvider="wrong_creds",
            description="Авторизация с некорректным логином или паролем",
            groups="smoke")
    public void wrongLoginOrPassword(String logins, String passwords) {
        basePage.open(BASE_URL);
        loginPage.logIn(logins, passwords);
        Assert.assertEquals(
                loginPage.getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service",
                "Сообщение не появилось или не корректно"
        );
    }

}
