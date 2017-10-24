package com.testinterview.serenity.steplib;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static com.testinterview.serenity.ETSYAPI.ETSY_API;
import static net.serenitybdd.rest.SerenityRest.given;

public class EtsyAPI extends ScenarioSteps {

    @Step
    public void verify_api() {
        given().when().get(ETSY_API).then().statusCode(200);
    }
}
