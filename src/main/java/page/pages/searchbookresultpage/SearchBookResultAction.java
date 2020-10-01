package page.pages.searchbookresultpage;

import framework.helpers.SeleniumHelper;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchBookResultAction {

    private final SearchBookResultElementProvider elements;

    public SearchBookResultAction(SearchBookResultElementProvider elements) {
        this.elements = elements;
    }

    public void selectBookNumber(Integer number) {
        List<WebElement> bookList = elements.getBookList();
        SeleniumHelper.clickElement(bookList.get(number));
    }

    public void findBookByText(String text) {
        List<WebElement> bookList = elements.getBookDescriptionList();
        for (WebElement i : bookList) {
            if (i.getText().contains(text)) {
                i.click();
                break;
            }
        }
    }
}
