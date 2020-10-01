package page.pages.addtobasket;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.common.BasePage;

class AddToBasketElementProvider extends BasePage {

    public AddToBasketElementProvider(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(id = "addToBasket_vjavse_w")
    private WebElement addToBasketButton;

    public WebElement getAddToBasketButton() {
        return addToBasketButton;
    }
}
