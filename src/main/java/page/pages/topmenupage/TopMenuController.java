package page.pages.topmenupage;

import org.openqa.selenium.WebDriver;
import page.common.BasePage;

public class TopMenuController extends BasePage implements TopMenu {

    private TopMenuAction action;

    public TopMenuController(WebDriver webDriver) {
        super(webDriver);
        init();
    }

    public void clickLogo() {
        action.clickLogo();
    }

    public void openBookCategoryPage() {
        action.openBookCategoryPage();
    }

    public void openEBookCategoryPage() {
        action.openEBookCategoryPage();
    }

    public void openVideoCursesCategoryPage() {
        action.openVideoCursesCategoryPage();
    }

    public void openAudioBookCategoryPage() {
        action.openAudioBookCategoryPage();
    }

    public void openSalePage() {
        action.openSalePage();
    }

    public void openUserAccountPage() {
        action.openUserAccountPage();
    }

    private void init() {
        TopMenuElementProvider elements = new TopMenuElementProvider(webDriver);
        action = new TopMenuAction(elements);
    }
}
