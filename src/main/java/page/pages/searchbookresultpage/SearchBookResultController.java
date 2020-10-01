package page.pages.searchbookresultpage;

import org.openqa.selenium.WebDriver;

public class SearchBookResultController implements SearchBookResult {

    private final WebDriver webDriver;
    private SearchBookResultAction action;

    public SearchBookResultController(WebDriver webDriver) {
        this.webDriver = webDriver;
        init();
    }

    @Override
    public void selectBookNumber(Integer number) {
        action.selectBookNumber(number);
    }

    @Override
    public void findBookByText(String text) {
        action.findBookByText(text);
    }

    private void init() {
        SearchBookResultElementProvider elements = new SearchBookResultElementProvider(webDriver);
        action = new SearchBookResultAction(elements);
    }
}
