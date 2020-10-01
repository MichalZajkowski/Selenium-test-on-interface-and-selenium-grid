package page.pages.topmenupage;

import framework.helpers.SeleniumHelper;

public class TopMenuAction {

    private final TopMenuElementProvider elements;

    public TopMenuAction(TopMenuElementProvider elements) {
        this.elements = elements;
    }

    public void clickLogo(){
        SeleniumHelper.clickElement(elements.getLogoButton());
    }

    public void openBookCategoryPage(){
        SeleniumHelper.clickElement(elements.getBookButton());
    }

    public void openEBookCategoryPage(){
        SeleniumHelper.clickElement(elements.getEBookButton());
    }

    public void openVideoCursesCategoryPage(){
        SeleniumHelper.clickElement(elements.getVideoCursesButton());
    }

    public void openAudioBookCategoryPage(){
        SeleniumHelper.clickElement(elements.getAudioBookButton());
    }

    public void openSalePage(){
        SeleniumHelper.clickElement(elements.getSaleButton());
    }

    public void openUserAccountPage(){
        SeleniumHelper.clickElement(elements.getUserAccountButton());
    }
}
