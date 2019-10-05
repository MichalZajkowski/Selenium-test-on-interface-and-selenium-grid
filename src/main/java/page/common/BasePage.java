package page.common;

import framework.helpers.SeleniumHelper;
import org.openqa.selenium.WebDriver;

public abstract class BasePage<T extends BasePage<T>> {

    private WebDriver webDriver;
    protected SeleniumHelper seleniumHelper;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        seleniumHelper = new SeleniumHelper(webDriver);
    }

    protected abstract T getThis();

    public abstract boolean isLoaded();
}
