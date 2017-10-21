package com.testinterview.serenity.pages;

import com.testinterview.serenity.SessionVar;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

/**
 * Created by ongshir on 05/10/2016.
 */
@DefaultUrl("/")
public class MainSearchPage extends PageObject {

    @FindBy(id = "search-query")
    WebElementFacade inputBox;

    @FindBy(css = "button.btn.btn-primary")
    WebElementFacade searchButton;

    @FindBy(css = ".vesta-hp-category-default")
    WebElementFacade categoryIconContainer;

    public MainSearchPage(WebDriver driver) { super(driver); }

    public void searchFromInputBox(String searchText) {
        inputBox.waitUntilPresent().sendKeys(searchText);
        searchButton.click();
    }

    /**
     * Clicking on the given category under the "Shop by category" section
     * @param category
     */
    public void searchFromCategoryIcons(String category) {
        Serenity.setSessionVariable(SessionVar.CATEGORY).to(category);
        List<WebElement> categoryIcons = categoryIconContainer.findElements(By.cssSelector(".vesta-hp-category-card"));
        for (WebElement e : categoryIcons) {
            if (e.isDisplayed() && e.getText().contains(category)) {
                e.click();
                return;
            }
        }
    }

    /**
     * Clicking on a given category in the dropdown list
     * @param category
     */
    public void searchFromDropDownMenuCategory(String category) {
        //Setting the session variable in case we stay on this level and we have to verify the result page for that category
        Serenity.setSessionVariable(SessionVar.CATEGORY).to(category);

        //iterating top categories and clicking on the matching one
        List<WebElementFacade> categories = findAll(By.cssSelector(".top-nav-item"));
        for (WebElementFacade e : categories) {
            if (e.getText().contains(category)) {
                e.click();
                break;
            }
        }
    }

    /**
     * Clicking on a subcategory after we clicked on a category
     * @param subcategory
     */
    public void searchFromSubCategoryMenu(String subcategory) {
        if (subcategory.equals("na")) {
            return;
        }

        //Setting the session variable in case we stay on this level and we have to verify the result page for that category
        Serenity.setSessionVariable(SessionVar.CATEGORY).to(subcategory);

        //displayed subcategory section:
        WebElementFacade subcategoriesContainerElement =  find(By.cssSelector("*[aria-hidden='false']"));

        //finding subcategory elements
        List<WebElement> subcategories = subcategoriesContainerElement.findElements(By.cssSelector(".side-nav-item"));
        for (WebElement el : subcategories) {
            if (el.getText().contains(subcategory)) {
                el.click();
                break;
            }
        }
    }

    /**
     * Clicking on a subsubcategory after we clicked on a category and a subcategory
     * @param subsubcategory
     */
    public void searchFromSubSubCategoryMenu(String subsubcategory) {
        if (subsubcategory.equals("na")) {
            return;
        }

        //Setting the session variable in case we stay on this level and we have to verify the result page for that category
        Serenity.setSessionVariable(SessionVar.CATEGORY).to(subsubcategory);

        //displayed subcategory section:
        WebElementFacade subcategoriesContainerElement = find(By.cssSelector("*[aria-hidden='false']"));

        //finding subsubcategory elements on the displayed subcategory section
        List<WebElement> subsubcategoriesContainer = subcategoriesContainerElement.findElements(By.tagName("li"));
        for (WebElement ee : subsubcategoriesContainer) {
            try{
                if (ee.findElement(By.tagName("a")).isDisplayed() && ee.findElement(By.tagName("a")).getText().contains(subsubcategory)) {
                    ee.click();
                    break;
                }
            } catch (NoSuchElementException e) {

            }
        }
    }

    /**
     * Return with the all categories header
     * @return
     */
    public String getAllCategoriesHeader() {
        return $(".clearfix.pb-xs-1-5").getText();
    }
}
