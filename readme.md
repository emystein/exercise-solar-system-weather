# Introduction

Resolución de ejercicios planteados en PDF adjunto 'Examen ML - Nivel 2.pdf'.

# Requerimientos del sistema

* JDK 1.8
* Maven 3.x

# Build

```
mvn clean install
```
# Deployment cloud usando Cloudfoundry

```
mvn clean install
cf push galaxy-weather -p target/galaxy-weather-0.0.1-SNAPSHOT.jar
```

## Tests

```
mvn clean test
```

## Job de pronóstico de 10 años

Se ejecuta en [WeatherReportTest](src/test/java/com/mercadolibre/galaxy/weather/report/WeatherReportTest).

# Ejecución

## Cloud

HTTP GET <http://galaxy-weather.cfapps.io/clima?dia=566>

## Local

```
mvn spring-boot:run
```

Luego HTTP GET <http://localhost:8080/clima?dia=566>
