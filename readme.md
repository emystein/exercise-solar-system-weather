# Introduction

Resolución de ejercicios planteados en PDF adjunto 'Examen ML - Nivel 2.pdf'.

# Requerimientos

* JDK 1.8
* Maven 3.x

# Deployment

## Local

```
mvn clean install
```

## Web

```
mvn clean install
cf push galaxy-weather -p target/galaxy-weather-0.0.1-SNAPSHOT.jar
```

# Ejecución

## Unit Tests

```
mvn clean test
```

## Job

Ver SolarSystemReportTest.

## Servicio REST

### Deployado en la web

Run: HTTP GET <http://galaxy-weather.cfapps.io/clima?dia=566>

### Local

```
mvn spring-boot:run
```

Luego HTTP GET <http://localhost:8080/clima?dia=566>
