package page.pages.topmenupage;

import org.openqa.selenium.WebDriver;
import page.common.BasePage;

public class TopMenuPage extends BasePage<TopMenuPage> implements TopMenu {

    private TopMenuElementProvider elements;

    public TopMenuPage(WebDriver webDriver) {
        super(webDriver);
        elements = new TopMenuElementProvider(webDriver);
    }

    public void clickLogo() {
        seleniumHelper.clickElement(elements.getLogoButton());
    }

    public void openBookCategoryPage() {
        seleniumHelper.clickElement(elements.getBookButton());
    }

    public void openEBookCategoryPage() {
        seleniumHelper.clickElement(elements.getEBookButton());
    }

    public void openVideoCursesCategoryPage() {
        seleniumHelper.clickElement(elements.getVideoCursesButton());
    }

    public void openAudioBookCategoryPage() {
        seleniumHelper.clickElement(elements.getAudioBookButton());
    }

    public void openSalePage() {
        seleniumHelper.clickElement(elements.getSaleButton());
    }

    public void openUserAccountPage() {
        seleniumHelper.clickElement(elements.getUserAccountButton());
    }

    @Override
    protected TopMenuPage getThis() {
        return this;
    }

    @Override
    public boolean isLoaded() {
        return seleniumHelper.isElementVisible(elements.getBookButton()) && seleniumHelper.isElementVisible(elements.getLogoButton());
    }
}
