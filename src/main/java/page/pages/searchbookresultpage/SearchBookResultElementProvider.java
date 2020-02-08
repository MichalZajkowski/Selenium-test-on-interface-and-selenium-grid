package page.pages.searchbookresultpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

class SearchBookResultElementProvider {

    SearchBookResultElementProvider(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//*[@id='right-big-col']//ul//img")
    private List<WebElement> bookList;

    //example how selector should not look like
    @FindBy(css = "#right-big-col > div.book-list-container.multi-line.padding-top.padding-top-search > div > ul > li> div > h3 > a")
    private List<WebElement> bookDescriptionList;

    List<WebElement> getBookList() {
        return bookList;
    }

    List<WebElement> getBookDescriptionList() {
        return bookDescriptionList;
    }
}
