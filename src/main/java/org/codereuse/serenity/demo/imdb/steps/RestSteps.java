package org.codereuse.serenity.demo.imdb.steps;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.Matchers.is;

/**
 * Created by theo on 06.11.17.
 */
public class RestSteps {

    private String ISO_CODE_SEARCH = "http://services.groupkt.com/country/get/iso2code/";
    private Response response;

    @Step("I try to search tghe country by {0} code")
    public void searchCountryByCode(String code) {
        response = SerenityRest.when().get(ISO_CODE_SEARCH + code);
    }

    @Step
    public void searchIsExecutedSuccesfully() {
        response.then().statusCode(200);
    }

    @Step("I should see the country with name {0}")
    public void iShouldFindCountry(String country) {
        response.then().body("RestResponse.result.name", is(country));
    }
}
