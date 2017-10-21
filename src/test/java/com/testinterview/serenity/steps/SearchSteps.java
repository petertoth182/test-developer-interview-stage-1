package com.testinterview.serenity.steps;

import com.testinterview.serenity.pages.MainSearchPage;
import com.testinterview.serenity.steplib.SearchUser;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Steps;

/**
 * Created by ongshir on 05/10/2016.
 */
public class SearchSteps {

    @Before
    public void before() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Steps
    SearchUser user;

    MainSearchPage mainSearchPage;

    @Given("^John is viewing the Etsy landing page$")
    public void goto_landing_page() {
        mainSearchPage.open();
    }

    @When("^he searches for a product from the input box$")
    public void search_from_input_box() {
        user.search_from_input_box();
    }

    @When("^he searches for a product from the category icons$")
    public void search_from_category_icons() {
        user.search_from_category_icons();
    }

    @When("^he searches for a product from the drop-down menu like \\\"([^\\\"]*)\\\"$")
    public void search_from_dropdown_menu(String category) {
        user.search_from_dropdown_menu(category);
    }

    @And("^he searches for a product from the subcategory menu like \\\"([^\\\"]*)\\\"$")
    public void search_from_subcategory_menu(String subcategory) {
        user.search_from_subcategory_menu(subcategory);
    }

    @And("^he searches for a product from the subsubcategory menu like \\\"([^\\\"]*)\\\"$")
    public void search_from_subsubcategory_menu(String subsubcategory) {
        user.search_from_subsubcategory_menu(subsubcategory);
    }

    @Then("^the result should be displayed$")
    public void verify_search_result() {
        user.verify_result_for_top_categories();
    }

    @Then("^the result should be displayed for that category$")
    public void verify_search_result_category() {
        user.verify_result_for_categorypage();
    }
}
