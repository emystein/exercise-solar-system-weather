package com.kamikaze.solarsystem.weather.report;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.kamikaze.solarsystem.weather.DayWeather;
import com.kamikaze.solarsystem.weather.Weather;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
// for avoiding other integration tests to fail
@DirtiesContext
public class WeatherQueryControllerIT {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void test() {
		ResponseEntity<DayWeather> response = this.restTemplate.getForEntity("/clima?dia={day}", DayWeather.class, 566);

		DayWeather expectedWeather = new DayWeather(566, Weather.Rain);
		
		assertThat(response.getBody(), is(expectedWeather));
	}

}
