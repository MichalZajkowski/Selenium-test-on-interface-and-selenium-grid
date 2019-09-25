package page.pages.topmenupage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

class TopMenuElementProvider {

    TopMenuElementProvider(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(css = "p.logo")
    private WebElement logoButton;

    @FindBy(css = "nav.main-menu > ul > li:nth-child(1)")
    private WebElement bookButton;

    @FindBy(css = "nav.main-menu > ul > li:nth-child(2)")
    private WebElement eBookButton;

    @FindBy(css = "nav.main-menu > ul > li:nth-child(3)")
    private WebElement videoCursesButton;

    @FindBy(css = "nav.main-menu > ul > li:nth-child(4)")
    private WebElement audioBookButton;

    @FindBy(css = "nav.main-menu > ul > li:nth-child(5)")
    private WebElement saleButton;

    @FindBy(css = "div.user-tools > div.your-profile > p")
    private WebElement userAccountButton;

    WebElement getLogoButton() {
        return logoButton;
    }

    WebElement getBookButton() {
        return bookButton;
    }

    WebElement getEBookButton() {
        return eBookButton;
    }

    WebElement getVideoCursesButton() {
        return videoCursesButton;
    }

    WebElement getAudioBookButton() {
        return audioBookButton;
    }

    WebElement getSaleButton() {
        return saleButton;
    }

    WebElement getUserAccountButton() {
        return userAccountButton;
    }
}
