package co.com.appgatetest.cesar.utils;

import net.serenitybdd.screenplay.Actor;

public class Constants {

    public static final Actor ACTOR = Actor.named("user");
    public static final String ENDPOINT = "http://api.geonames.org/";
    public static final String USERNAME = "qa_mobile_easy";
    public static final String SERVICE_NAME = "timezoneJSON";
    public static final Integer STATUS_CODE_200 = 200;
    public static final String COUNTRY_CODE_SUBJECT = "countryCode";
    public static final String TIME_ZONE_ID_SUBJECT = "timezoneId";
    public static final String COUNTRY_NAME_SUBJECT = "countryName";
}
