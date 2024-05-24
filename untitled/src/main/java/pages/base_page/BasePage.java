package pages.base_page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static constants.Constant.TimeoutVariable.EXPLICIT_WAIT;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open(String url) {
        driver.get(url);
    }

    public WebElement waitElementIsVisible(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT)).until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public void scrollToElement(WebElement element) throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        Thread.sleep(500);
    }

    public boolean elementIsVisible(By locator) {
        try {
            waitElementIsVisible(driver.findElement(locator));
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }
}

