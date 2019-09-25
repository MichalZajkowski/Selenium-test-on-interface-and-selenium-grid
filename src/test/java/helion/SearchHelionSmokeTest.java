package helion;


import common.BaseTest;
import framework.dataprovider.SearchItemProvider;
import framework.dataprovider.UrlProvider;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.TestInstance;
import page.pages.addtobasket.AddToBasketPage;
import page.pages.searchbookresultpage.SearchBookResult;
import page.pages.searchbookresultpage.SearchBookResultPage;
import page.pages.searchpage.ToolSearch;
import page.pages.searchpage.ToolSearchPage;
import page.pages.topmenupage.TopMenu;
import page.pages.topmenupage.TopMenuPage;

import static framework.screenshot.ScreenShotMaker.takeErrorScreenShot;
import static org.assertj.core.api.AssertionsForClassTypes.fail;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SearchHelionSmokeTest extends BaseTest {

    private String searchItem;
    private TopMenu topMenu;
    private ToolSearch toolSearch;
    private SearchBookResult searchBookResult;
    private AddToBasketPage addToBasketPage;
    private boolean isCorrectStep = true;

    SearchHelionSmokeTest() {
        topMenu = new TopMenuPage(webDriver);
        toolSearch = new ToolSearchPage(webDriver);
        searchBookResult = new SearchBookResultPage(webDriver);
        addToBasketPage = new AddToBasketPage(webDriver);
    }

    @BeforeEach
    void beforeEachTest() {
        Assumptions.assumeTrue(isCorrectStep);
    }

    @BeforeAll
    void setUp() {
        String url = UrlProvider.HELION.getUrl();
        navigateToPage(url);
        searchItem = SearchItemProvider.JAVA.getSearchItem();
    }

    @AfterAll
    static void treadDown() {
        webDriver.close();
        webDriver.quit();
        tearDownGridIfNeeded();
    }

    @Test
    @Order(1)
    void openBookPageTest() {
        try {
            topMenu.openBookCategoryPage();
            topMenu.clickLogo();
        } catch (Exception e) {
            takeErrorScreenShot(webDriver);
            isCorrectStep = false;
            fail("Open book category page and go back to home page error:" + e);
        }
    }

    @Test
    @Order(2)
    void searchByTestTest() {
        try {
            toolSearch.searchByText(searchItem);
        } catch (Exception e) {
            takeErrorScreenShot(webDriver);
            isCorrectStep = false;
            fail("Search by text error: " + e);
        }
    }

    @Test
    @Order(3)
    void selectFirstBookTest() {
        try {
            searchBookResult.selectBookNumber(1);
        } catch (Exception e) {
            takeErrorScreenShot(webDriver);
            isCorrectStep = false;
            fail("Can not select book from book list: " + e);
        }
    }

    @Test
    @Order(4)
    void addBookToBasket() {
        try {
            addToBasketPage.addToBasket();
        } catch (Exception e) {
            takeErrorScreenShot(webDriver);
            isCorrectStep = false;
            fail("Can not click add to basket: " + e);
        }
    }
}

