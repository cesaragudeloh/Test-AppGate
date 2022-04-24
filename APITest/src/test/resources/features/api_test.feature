#language:en

Feature: Get the geolocalization information


  @HappyPath
  Scenario Outline: Get the properly geolocalization information
    Given the user wants to get the geolocalization information
    When the user put the <longitude> and <latitude>
    Then the user gets the geolocalization information


    Examples:
      | latitude | longitude |
      | -10      | 20        |
      | 45       | 77        |
      | -90      | -180      |
      | 0        | 0         |


  @NonHappyPath
  Scenario Outline: Try to Get the geolocalization information with wrong data
    Given the user wants to get the geolocalization information
    When the user put the wrong <longitude> and <latitude>
    Then the user do not gets the geolocalization information and show <message>


    Examples:
      | longitude | latitude | message                                   |
      | 180       | 90       | no timezone information found for lat/lng |
      | -200      | -100     | invalid lat/lng                           |
      | 200       | 100      | invalid lat/lng                           |
