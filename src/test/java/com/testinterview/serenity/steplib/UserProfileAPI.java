package com.testinterview.serenity.steplib;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.when;

import io.restassured.response.Response;
import static org.hamcrest.Matchers.is;

import static com.testinterview.serenity.ETSYAPI_USERS.*;


public class UserProfileAPI {

    private Response response;

    public void saveUserID(String userID) {
        Serenity.getCurrentSession().put("userID", userID);
    }

    @Step
    public void findUserProfile() {
        String userID = (String) Serenity.getCurrentSession().get("userID");
        response = when().get(ETSY_USERS  + userID + ETSY_USERS_FINDUSERPROFILE);
    }

    @Step
    public void verify_findUserProfile_response(String username){
        String userID = (String) Serenity.getCurrentSession().get("userID");
        response.then().assertThat().statusCode(200).
                and().body("RestResponse.result.name", is(username)).and().body("RestResponse.result.userid", is(userID));
    }
}
