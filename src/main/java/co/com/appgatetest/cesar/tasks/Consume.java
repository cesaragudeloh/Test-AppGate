package co.com.appgatetest.cesar.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class Consume implements Task
{

    private String service;
    private Double longitude;
    private Double latitude;


    public Consume(String service, Double longitude, Double latitude) {
        this.service = service;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(service).with(
                        requestSpecification -> requestSpecification
                                .param("formatted","true")
                                .param("username","qa_mobile_easy")
                                .param("style","full")
                                .param("lng", longitude)
                                .param("lat", latitude)
                )
        );
    }


    public static Consume theServiceWith(String service, Double longitude, Double latitude){
        return Instrumented.instanceOf(Consume.class).withProperties(service, longitude, latitude);
    }
}
