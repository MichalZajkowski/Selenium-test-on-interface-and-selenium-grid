package framework.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumHelper {

    private static final Integer DEFAULT_TIMEOUT_IN_SEC = 10;
    private static WebDriver webDriver;

    public SeleniumHelper(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public static boolean isElementVisible(final WebElement element) {
        FluentWait<WebDriver> wait = createWait();
        wait.until(ExpectedConditions.visibilityOf(element));
        return true;
    }

    public static void clearAndSendKey(final WebElement element, final String text) {
        element.clear();
        element.sendKeys(text);
    }

    public static void clickElement(final WebElement element) {
        FluentWait<WebDriver> wait = createWait();
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    private static FluentWait<WebDriver> createFluentWait() {
        return new WebDriverWait(webDriver, DEFAULT_TIMEOUT_IN_SEC);
    }

    private static FluentWait<WebDriver> createWait() {
        return createFluentWait().withTimeout(Duration.ofSeconds(DEFAULT_TIMEOUT_IN_SEC));
    }
}
