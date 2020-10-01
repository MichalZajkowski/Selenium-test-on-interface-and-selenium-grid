package page.pages.searchpage;

import framework.helpers.SeleniumHelper;

public class ToolSearchAction {

    ToolSearchElementProvider elements;

    public ToolSearchAction(ToolSearchElementProvider elements) {
        this.elements = elements;
    }

    public void searchByText(String text){
        SeleniumHelper.clearAndSendKey(elements.getSearchInput(), text);
        SeleniumHelper.clickElement(elements.getSearchButton());
    }

    public void openBasket(){
        SeleniumHelper.clickElement(elements.getBasket());
    }

}
