# Introducción

Solución al ejercicio planteado en PDF adjunto [Examen ML - Nivel 2.pdf](Examen ML - Nivel 2.pdf).

# Requerimientos para compilar el proyecto

* JDK 1.8
* Maven 3.x

# Solución a las consignas del ejercicio

## Reporte con resúmen de condiciones climáticas en los próximos 10 años

Ver [WeatherSummaryReport](src/main/java/com/mercadolibre/galaxy/weather/report/WeatherSummaryReport.java) y  [WeatherSummaryReportTest](src/test/java/com/mercadolibre/galaxy/weather/report/WeatherSummaryReportTest.java).


## Bonus

Aplicación Spring Boot que utiliza los siguientes componentes:

* Spring IOC
* Spring Web services
* Spring Data JPA para persistencia

### Job para predicción del clima por 10 años

Ver [WeatherPredictionJob](src/main/java/com/mercadolibre/galaxy/weather/persistence/WeatherPredictionJob.java)


#### Ejecución del job en startup de la aplicación

Ver [WeatherPredictionJobStartupRunner](src/main/java/com/mercadolibre/galaxy/WeatherPredictionJobStartupRunner.java)


### API REST para consultar el clima para un día en particular

Ver [WeatherQueryController](src/main/java/com/mercadolibre/galaxy/weather/report/WeatherQueryController.java).

#### Cloud Hosting

El servicio REST está hosteado en la URL: <http://galaxy-weather.cfapps.io/clima>

Request de ejemplo: <http://galaxy-weather.cfapps.io/clima?dia=566>

#### Ejecución Local

Para ejecutar el servicio REST localmente:

```
mvn clean spring-boot:run
```

Luego HTTP GET <http://localhost:8080/clima?dia=566>
