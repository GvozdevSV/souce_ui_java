package tests.login_tests;

import org.testng.annotations.Test;
import tests.base_test.BaseTest;

public class LoginTests extends BaseTest {
    @Test
    public void correctLogin() {
        basePage.open("https://www.saucedemo.com/");
    }
}
