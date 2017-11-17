package org.codereuse.serenity.demo.imdb;

import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.codereuse.serenity.demo.imdb.steps.RestSteps;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.hamcrest.Matchers.is;

/**
 * Created by theo on 06.11.17.
 */
@RunWith(SerenityRunner.class)
public class RestTest {

    @Steps
    public RestSteps restSteps;

    @Test
    public void verifyThatWeCanFindUnitedStatesOfAmericaCountryUsingTheCodeUS() {
        restSteps.searchCountryByCode("US");
        restSteps.searchIsExecutedSuccesfully();
        restSteps.iShouldFindCountry("United States of America");
    }

    @Test
    public void verifyThatWeCanFindIndiaCountryUingTheCodeIN(){
        restSteps.searchCountryByCode("IN");
        restSteps.searchIsExecutedSuccesfully();
        restSteps.iShouldFindCountry("India");
    }

    @Test
    public void verifyThatWeCanFindBrazilCountryUsingTheCodeBR(){
        restSteps.searchCountryByCode("BR");
        restSteps.searchIsExecutedSuccesfully();
        restSteps.iShouldFindCountry("Brazil");
    }

    @Test
    public void verifyThatWeCanFindUnitedStatesOfAmericaUsingTheCodeUS(){
        RestAssured.
                when().get("http://services.groupkt.com/country/get/iso2code/US").
                then().assertThat().statusCode(200).
                and().body("RestResponse.result.name", is("United States of America"));
    }
}
