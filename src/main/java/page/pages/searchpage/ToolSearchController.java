package page.pages.searchpage;

import org.openqa.selenium.WebDriver;
import page.common.BasePage;

public class ToolSearchController extends BasePage implements ToolSearch {

    private ToolSearchAction action;

    public ToolSearchController(WebDriver webDriver) {
        super(webDriver);
        init();
    }

    @Override
    public void searchByText(String text) {
        action.searchByText(text);
    }

    @Override
    public void openBasket() {
        action.openBasket();
    }

    private void init(){
        ToolSearchElementProvider elements = new ToolSearchElementProvider(webDriver);
        action = new ToolSearchAction(elements);
    }
}
