package com.mercadolibre.galaxy.weather.persistence;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mercadolibre.galaxy.weather.DayWeather;
import com.mercadolibre.galaxy.weather.Weather;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DayWeatherRepositoryIT {

	@Autowired
	private DayWeatherRepository repository;
	
	@Test
	public void persist() throws Exception {
		DayWeather dayWeather = new DayWeather(1, Weather.None);
		
		repository.save(dayWeather);
		
		// verify
		List<DayWeather> all = repository.findAll();
		assertFalse(all.isEmpty());
		DayWeather retrievedWeather = all.get(0);
		assertDayWeather(retrievedWeather, dayWeather);
	}
	
	@Test
	public void findByDay() throws Exception {
		DayWeather dayWeather = new DayWeather(1, Weather.None);
		
		repository.save(dayWeather);
		
		DayWeather retrievedWeather = repository.findOne(1);

		// verify
		assertDayWeather(retrievedWeather, dayWeather);
	}

	private void assertDayWeather(DayWeather actual, DayWeather expected) {
		assertThat(actual.getDay(), is(expected.getDay()));
		assertThat(actual.getWeather(), is(expected.getWeather()));
	}
}
