package pages.login_page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import pages.base_page.BasePage;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    private final By loginField = By.id("user-name");
    private final By passwordField = By.name("password");
    private final By submitButton = By.cssSelector("input[type=\"submit\"]");

    public void logIn(String user_login) {
        waitElementIsVisible(driver.findElement(loginField)).sendKeys(user_login);
        waitElementIsVisible(driver.findElement(passwordField)).sendKeys("secret_sauce");
        waitElementIsVisible(driver.findElement(submitButton)).click();
    }

    public boolean checkLogin() {
        try {
            waitElementIsVisible(driver.findElement(submitButton)).click();
        } catch (NoSuchElementException e) {
            return true;
        }
        return false;
    }
}
