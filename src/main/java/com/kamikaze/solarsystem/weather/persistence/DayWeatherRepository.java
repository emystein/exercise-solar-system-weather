package com.kamikaze.solarsystem.weather.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kamikaze.solarsystem.weather.DayWeather;

public interface DayWeatherRepository extends JpaRepository<DayWeather, Integer> {

}
