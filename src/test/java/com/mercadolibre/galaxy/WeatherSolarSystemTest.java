package com.mercadolibre.galaxy;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.mercadolibre.galaxy.weather.DayWeather;
import com.mercadolibre.galaxy.weather.Weather;

public class WeatherSolarSystemTest extends SolarSystemTestSupport {
	
	@Test
	public void whenAdvancing1DayThenTheWeatherShouldNotBeAvailable() throws Exception {
		// exercise
		DayWeather dayWeather = solarSystem.getWeatherForDay(1);
		
		// verify
		assertThat(dayWeather.getDay(), is(1));
		assertThat(dayWeather.getWeather(), is(Weather.NONE));
	}
	
	@Test
	public void whenAdvancing566DaysThenTheWeatherShouldBeRain() throws Exception {
		// exercise
		DayWeather dayWeather = solarSystem.getWeatherForDay(566);
		
		// verify
		assertThat(dayWeather.getDay(), is(566));
		assertThat(dayWeather.getWeather(), is(Weather.RAIN));
	}
}

