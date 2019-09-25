package page.pages.addtobasket;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

class AddToBasketElementProvider {

    AddToBasketElementProvider(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(id = "addToBasket_vjavse_w")
    private WebElement addToBasketButton;

    WebElement getAddToBasketButton() {
        return addToBasketButton;
    }
}
