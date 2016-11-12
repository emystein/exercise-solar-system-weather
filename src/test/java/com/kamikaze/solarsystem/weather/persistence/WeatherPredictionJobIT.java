package com.kamikaze.solarsystem.weather.persistence;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.kamikaze.solarsystem.weather.persistence.DayWeatherRepository;
import com.kamikaze.solarsystem.weather.persistence.WeatherPredictionJob;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherPredictionJobIT {
	
	@Autowired
	private WeatherPredictionJob job;

	@Autowired
	private DayWeatherRepository repository;

	@Test
	public void predict10Years() throws Exception {
		job.predictYears(10);
		
		// verify
		assertThat(repository.findAll().size(), is(3650));
	}
}
