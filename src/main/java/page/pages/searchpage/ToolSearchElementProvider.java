package page.pages.searchpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

class ToolSearchElementProvider {

    ToolSearchElementProvider(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(id = "inputSearch")
    private WebElement searchInput;

    @FindBy(css = "fieldset > a > button")
    private WebElement searchButton;

    @FindBy(className = "hideFixed")
    private WebElement basket;

    WebElement getSearchInput() {
        return searchInput;
    }

    WebElement getSearchButton(){
        return searchButton;
    }

    WebElement getBasket(){ return basket; }
}
