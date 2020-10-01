package page.pages.searchbookresultpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.common.BasePage;

import java.util.List;

class SearchBookResultElementProvider extends BasePage {

    SearchBookResultElementProvider(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//*[@id='right-big-col']//ul//img")
    private List<WebElement> bookList;

    //example how selector should not look like
    @FindBy(css = "#right-big-col > div.book-list-container.multi-line.padding-top.padding-top-search > div > ul > li> div > h3 > a")
    private List<WebElement> bookDescriptionList;

    public List<WebElement> getBookList() {
        return bookList;
    }

    public List<WebElement> getBookDescriptionList() {
        return bookDescriptionList;
    }
}
