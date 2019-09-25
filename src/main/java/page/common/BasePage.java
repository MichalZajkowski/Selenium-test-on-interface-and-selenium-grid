package page.common;

import framework.helpers.SeleniumHelper;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BasePage<T extends BasePage<T>> {

    private WebDriver webDriver;
    protected SeleniumHelper seleniumHelper;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        seleniumHelper = new SeleniumHelper(webDriver);
    }

    protected abstract T getThis();

    public abstract boolean isLoaded();

    public T makeElementScaled(WebElement uploadButton) {
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].style.transform='scale(1)';", uploadButton);
        return getThis();
    }

    public BasePage loadPage(String url) {
        webDriver.get(url);
        return this;
    }
}
