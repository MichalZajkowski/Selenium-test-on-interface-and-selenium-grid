package page.pages.searchpage;

import org.openqa.selenium.WebDriver;
import page.common.BasePage;

public class ToolSearchPage extends BasePage<ToolSearchPage> implements ToolSearch {

    private ToolSearchElementProvider elements;

    public ToolSearchPage(WebDriver webDriver) {
        super(webDriver);
        elements = new ToolSearchElementProvider(webDriver);
    }

    @Override
    public void searchByText(String text) {
        seleniumHelper.clearAndSendKey(elements.getSearchInput(), text);
        seleniumHelper.clickElement(elements.getSearchButton());
    }

    @Override
    public void openBasket() {
        seleniumHelper.clickElement(elements.getBasket());
    }

    @Override
    protected ToolSearchPage getThis() {
        return this;
    }

    @Override
    public boolean isLoaded() {
        return seleniumHelper.isElementVisible(elements.getSearchInput());
    }
}
