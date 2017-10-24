package com.testinterview.serenity.steps;

import com.testinterview.serenity.steplib.EtsyAPI;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import com.testinterview.serenity.steplib.UserProfileAPI;

/**
 * Created by Peter on 24/10/2017
 */
public class UserProfileAPISteps {

    @Steps
    private UserProfileAPI userProfileAPI;
    private EtsyAPI etsyAPI;

    @Given("^I have a user's id: \\\"([^\\\"]*)\\\"$")
    public void saveUserID(String userID) {
        etsyAPI.verify_api();
        userProfileAPI.saveUserID(userID);
    }

    @When("^I request Etsy api to find the users profile$")
    public void findUserProfile() {
        userProfileAPI.findUserProfile();
    }

    @Then("^I should get the users profile: \\\"([^\\\"]*)\\\"$")
    public void verify_findUserProfile_response(String username) {
        userProfileAPI.verify_findUserProfile_response(username);
    }
}
