package co.com.appgatetest.cesar.stepdefinitions;

import co.com.appgatetest.cesar.models.Response;
import co.com.appgatetest.cesar.questions.TheAnswer;
import co.com.appgatetest.cesar.tasks.Connect;
import co.com.appgatetest.cesar.tasks.Consume;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.Map;

import static co.com.appgatetest.cesar.utils.Constants.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.equalTo;

public class APITestStepDefinitions {


    @DataTableType
    public Response responseEntry(Map<String, String> entry) {
        return new Response(
                entry.get("countryCode"),
                entry.get("timezoneId"),
                entry.get("countryName")
        );
    }


    @Given("the user wants to get the geolocalization information")
    public void theUserWantsToGetTheGeolocalizationInformation() {
        ACTOR.wasAbleTo(
                Connect.withTheEndpoint(ENDPOINT)
        );
    }


    @When("the user put the {double} and {double}")
    public void theUserPutLngAndLat(Double longitude, Double latitude) {
        ACTOR.attemptsTo(
                Consume.theServiceWith(SERVICE_NAME, longitude, latitude)
        );
    }

    @Then("the user gets the geolocalization information")
    public void theUserGetsTheGeolocalizationInformation(Response expected) {
        Response response = TheAnswer.is().answeredBy(ACTOR);
        ACTOR.should(
                seeThat(COUNTRY_CODE_SUBJECT, ACTOR->response.getCountryCode(), equalTo(expected.getCountryCode())),
                seeThat(TIME_ZONE_ID_SUBJECT, ACTOR->response.getTimezoneId(), equalTo(expected.getTimezoneId())),
                seeThat(COUNTRY_NAME_SUBJECT, ACTOR->response.getCountryName(), equalTo(expected.getCountryName()))
        );
    }

    @When("the user put the wrong {double} and {double}")
    public void theUserPutWrongLngAndLat(Double longitude, Double latitude) {
        ACTOR.attemptsTo(
                Consume.theServiceWith(SERVICE_NAME, longitude, latitude)
        );
    }

    @Then("^the user do not gets the geolocalization information and show (.+)$")
    public void theUserDoNotGetsTheGeolocalizationInformationAndShow(String message) {
        ACTOR.should(
                seeThatResponse("Message obtained: " + message, response -> response
                        .statusCode(STATUS_CODE_200)
                        .body("status.message", equalTo(message)))
        );
    }


}


