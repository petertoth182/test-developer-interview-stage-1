package com.testinterview.serenity.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebDriver;

/**
 * Created by Peter on 21/10/2017
 */
@DefaultUrl("/")
public class CategoryPage extends PageObject{

    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "h1")
    WebElementFacade title;

    public String getTitleOnPage() {
        return title.getText();
    }

}
