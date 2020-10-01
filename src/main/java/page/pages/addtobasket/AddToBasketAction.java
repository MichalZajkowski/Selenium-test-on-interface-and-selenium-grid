package page.pages.addtobasket;

import framework.helpers.SeleniumHelper;

public class AddToBasketAction {

    private final AddToBasketElementProvider elements;

    public AddToBasketAction(AddToBasketElementProvider elements) {
        this.elements = elements;
    }

    public void clickElementAddToBasket() {
        SeleniumHelper.clickElement(elements.getAddToBasketButton());
    }
}
