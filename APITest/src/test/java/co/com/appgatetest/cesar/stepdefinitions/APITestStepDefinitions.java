package co.com.appgatetest.cesar.stepdefinitions;

import co.com.appgatetest.cesar.tasks.Connect;
import co.com.appgatetest.cesar.tasks.Consume;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static co.com.appgatetest.cesar.utils.Constants.ACTOR;
import static co.com.appgatetest.cesar.utils.Constants.ENDPOINT;
import static co.com.appgatetest.cesar.utils.Constants.SERVICE_NAME;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class APITestStepDefinitions {

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
    public void theUserGetsTheGeolocalizationInformation() {
        ACTOR.should(

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
                seeThatResponse("Message obtained: "+message, response -> response
                        .statusCode(200)
                        .body("status.message", equalTo(message)))
        );
    }


}


