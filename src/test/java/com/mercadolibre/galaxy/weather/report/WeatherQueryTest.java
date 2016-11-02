package com.mercadolibre.galaxy.weather.report;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.mercadolibre.galaxy.SolarSystemTestSupport;
import com.mercadolibre.galaxy.event.SolarSystemEvent;
import com.mercadolibre.galaxy.event.SolarSystemEventType;
import com.mercadolibre.galaxy.weather.report.WeatherQuery;

public class WeatherQueryTest extends SolarSystemTestSupport {

	@Test
	public void queryDay() throws Exception {
		WeatherQuery query = new WeatherQuery(solarSystem);
		
		SolarSystemEvent event = query.getWeather(566);
		
		assertThat(event.getDay(), is(566));
		assertThat(event.getType(), is(SolarSystemEventType.RAIN));
	}
}
