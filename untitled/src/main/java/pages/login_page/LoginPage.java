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
    private final By errorMessage = By.xpath("//h3[@data-test=\"error\"]");

    // Заполнение полей авторизации
    public void logIn(String user_login, String password) {
        waitElementIsVisible(driver.findElement(loginField)).sendKeys(user_login);
        waitElementIsVisible(driver.findElement(passwordField)).sendKeys(password);
        waitElementIsVisible(driver.findElement(submitButton)).click();
    }
    // Проверка наличия кнопки SUBMIT
    public boolean checkLogin() {
        return elementIsVisible(submitButton);
    }
    // Получение текста ошибки
    public String getErrorMessage() {
        return waitElementIsVisible(driver.findElement(errorMessage)).getText();

    }


}
