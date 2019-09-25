package page.pages.addtobasket;

import org.openqa.selenium.WebDriver;
import page.common.BasePage;

public class AddToBasketPage extends BasePage<AddToBasketPage> implements AddToBasket {

    private AddToBasketElementProvider elements;

    public AddToBasketPage(WebDriver webDriver) {
        super(webDriver);
        elements = new AddToBasketElementProvider(webDriver);
    }

    @Override
    public void addToBasket() {
        seleniumHelper.clickElement(elements.getAddToBasketButton());
    }

    @Override
    protected AddToBasketPage getThis() {
        return this;
    }

    @Override
    public boolean isLoaded() {
        return seleniumHelper.isElementVisible(elements.getAddToBasketButton());
    }
}
