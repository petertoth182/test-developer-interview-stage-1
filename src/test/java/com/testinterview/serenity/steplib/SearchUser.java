package com.testinterview.serenity.steplib;

import com.testinterview.serenity.SessionVar;
import com.testinterview.serenity.pages.CategoryPage;
import com.testinterview.serenity.pages.MainSearchPage;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

/**
 * Created by ongshir on 05/10/2016.
 */
public class SearchUser extends ScenarioSteps {

    MainSearchPage mainSearchPage;
    CategoryPage categoryPage;

    String searchText = "craft";

    @Step
    public void search_from_input_box() {
        mainSearchPage.searchFromInputBox(searchText);
    }

    @Step
    public void search_from_category_icons() {
        mainSearchPage.searchFromCategoryIcons("Home & Living");
    }

    public void search_from_dropdown_menu(String category) {
        mainSearchPage.searchFromDropDownMenuCategory(category);
    }

    public void search_from_subcategory_menu(String subcategory){
        mainSearchPage.searchFromSubCategoryMenu(subcategory);
    }

    public void search_from_subsubcategory_menu(String subsubcategory){
        mainSearchPage.searchFromSubSubCategoryMenu(subsubcategory);
    }

    @Step
    public void verify_result_for_top_categories() {
        assertThat(mainSearchPage.getAllCategoriesHeader(), containsString(searchText));
    }

    @Step
    public void verify_result_for_categorypage() {
        assertThat(categoryPage.getTitle(), containsString(Serenity.sessionVariableCalled(SessionVar.CATEGORY).toString()));
        assertThat(categoryPage.getTitleOnPage(), containsString(Serenity.sessionVariableCalled(SessionVar.CATEGORY).toString()));
    }
}
