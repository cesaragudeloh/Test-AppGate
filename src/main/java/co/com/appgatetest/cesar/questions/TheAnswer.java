package co.com.appgatetest.cesar.questions;

import co.com.appgatetest.cesar.models.Response;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;


public class TheAnswer implements Question<Response> {


    @Override
    public Response answeredBy(Actor actor) {
       return SerenityRest.lastResponse().getBody().as(Response.class);
    }

    public static TheAnswer is(){
        return Instrumented.instanceOf(TheAnswer.class).withProperties();
    }
}
