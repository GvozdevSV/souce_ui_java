package tests.login_tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base_test.BaseTest;

import java.util.concurrent.TimeUnit;

import static constants.Constant.Urls.BASE_URL;

public class LoginTests extends BaseTest {
    @Test
    public void correctLogin(){
        basePage.open(BASE_URL);
        loginPage.logIn();
        Assert.assertTrue(loginPage.checkLogin());
    }
}
