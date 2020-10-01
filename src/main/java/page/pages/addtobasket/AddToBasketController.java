package page.pages.addtobasket;

import org.openqa.selenium.WebDriver;

public class AddToBasketController implements AddToBasket {

    private final WebDriver webDriver;
    private AddToBasketAction action;

    public AddToBasketController(WebDriver webDriver) {
        this.webDriver = webDriver;
        init();
    }

    @Override
    public void addToBasket() {
        action.clickElementAddToBasket();
    }

    private void init() {
        AddToBasketElementProvider elements = new AddToBasketElementProvider(webDriver);
        action = new AddToBasketAction(elements);
    }
}
