package framework.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumHelper {

    private static final int DEFAULT_TIMEOUT_IN_SEC = 10;
    private final WebDriver webDriver;

    public SeleniumHelper(WebDriver driver) {
        this.webDriver = driver;
    }

    private FluentWait<WebDriver> createFluentWait() {
        return new WebDriverWait(webDriver, DEFAULT_TIMEOUT_IN_SEC);
    }

    private FluentWait<WebDriver> createWait() {
        return createFluentWait().withTimeout(Duration.ofSeconds(SeleniumHelper.DEFAULT_TIMEOUT_IN_SEC));
    }

    public boolean isElementVisible(final WebElement element) {
        FluentWait<WebDriver> wait = createWait();
        wait.until(ExpectedConditions.visibilityOf(element));
        return true;
    }

    public void clearAndSendKey(final WebElement element, final String text) {
        element.clear();
        element.sendKeys(text);
    }

    public void clickElement(final WebElement element) {
        FluentWait<WebDriver> wait = createWait();
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    public String getText(final WebElement element) {
        String text = null;
        text = element.getText();
        return text;
    }

    public boolean isElementPresent(final By locator) {
        FluentWait<WebDriver> wait = createWait();
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return true;
    }
}
