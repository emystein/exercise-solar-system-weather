package com.mercadolibre.galaxy.weather.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercadolibre.galaxy.weather.DayWeather;

public interface DayWeatherRepository extends JpaRepository<DayWeather, Integer> {

}
