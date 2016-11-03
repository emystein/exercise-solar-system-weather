package com.mercadolibre.galaxy.weather.persistence;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mercadolibre.galaxy.WeatherPredictionJobStartupRunner;

/**
 * Verifies {@link WeatherPredictionJob} runs on application startup.
 * @author emenendez
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherPredictionJobStartupRunnerIT {
	
	@Autowired
	private DayWeatherRepository weatherRepository;

	@Autowired
	private WeatherPredictionJobStartupRunner jobRunner;
	
	@Test
	public void runWeatherPredictionJobOnStartup() throws Exception {
		// Spring should automatically run the job, so we only verify job created data.
		
		int expectedPrecalculatedDays = jobRunner.getNumberOfYearsToPredict() * 365;
		
		Assert.assertThat(weatherRepository.findAll().size(), Matchers.is(expectedPrecalculatedDays));
	}
}
