package pages.login_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base_page.BasePage;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    private final By loginField = By.id("user-name");
    private final By passwordField = By.name("password");
    private final By submitButton = By.cssSelector("input[type=\"submit\"]");

    // Заполнение полей авторизации
    public void logIn(String user_login, String password) {
        waitElementIsVisible(driver.findElement(loginField)).sendKeys(user_login);
        waitElementIsVisible(driver.findElement(passwordField)).sendKeys(password);
        waitElementIsVisible(driver.findElement(submitButton)).click();
    }
    //
    public boolean checkLogin() {
        return elementIsVisible(submitButton);
    }

}
