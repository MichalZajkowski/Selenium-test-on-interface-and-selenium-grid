package page.pages.searchbookresultpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import page.common.BasePage;

import java.util.List;

public class SearchBookResultPage extends BasePage<SearchBookResultPage> implements SearchBookResult {

    private SearchBookResultElementProvider elements;

    public SearchBookResultPage(WebDriver webDriver) {
        super(webDriver);
        elements = new SearchBookResultElementProvider(webDriver);
    }

    @Override
    public void selectBookNumber(Integer number) {
        List<WebElement> bookList = elements.getBookList();
        seleniumHelper.clickElement(bookList.get(number));
    }

    @Override
    public void findBookByText(String text) {
        List<WebElement> bookList = elements.getBookDescriptionList();
        for (WebElement i : bookList) {
            if (i.getText().contains(text)) {
                i.click();
                break;
            }
        }
    }

    @Override
    protected SearchBookResultPage getThis() {
        return this;
    }

    @Override
    public boolean isLoaded() {
        return seleniumHelper.isElementVisible(elements.getBookList().get(0));
    }
}
