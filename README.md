# Test AppGate

Se realiza la automatización de la API-Rest http://api.geonames.org/timezoneJSON

### Escenarios automatizados:

	Get the geolocation information with valid data
    Try to Get the geolocalization information with wrong data


## Estrategia de automatización

Se propone la automatización del camino exitoso (consumo de la API con datos válidos) y el camino no exitoso, en donde se consume la API con datos de longitud y latitud NO válidos, estos indicados en el archivo api_test.feature



## Herramientas utilizadas

    Serenity 3.0.5
    Screenplay 3.0.5
    Screenplay Rest 3.0.5
    Cucumber 6
    Junit 5.8.2 (jupiter api & engine)
    Hamcrest 1.3
    Slf4j 1.7.36
    Postman 9.16.0
    Intellij IDEA 2022.1
    Jenkins 2.332.2

## Requerimientos
Para ejecutar el proyecto de automatización se requiere:

 	Java JDK 11
 	Gradle versión 7.1.1 o superior

## Ejecución del proyecto

Normalmente el proyecto se puede ejecutar desde cualquier IDE que soporte JAVA (Intellij IDEA, Eclipse, Netbeans, etc), desde las opciones de ejecución que éste posea. Sin embargo, si se desea ejecutar
desde un pipeline o desde una línea de comandos, podemos usar las siguientes instrucciones:

	gradlew clean test aggregate --info


Al ejecutar los tests, las evidencias de la ejecución de las pruebas quedarán en el directorio:

    $(Repository.Name)/target/site/serenity