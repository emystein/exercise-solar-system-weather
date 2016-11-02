package com.mercadolibre.galaxy.weather.report;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.mercadolibre.galaxy.SolarSystemTestSupport;
import com.mercadolibre.galaxy.event.SolarSystemEvent;
import com.mercadolibre.galaxy.event.SolarSystemEventType;

public class WeatherQueryTest extends SolarSystemTestSupport {

	private WeatherQuery query;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		query = new WeatherQuery(this.solarSystem, this.eventCollector);
	}
	
	@Test
	public void queryRainyDay() throws Exception {
		SolarSystemEvent event = query.getWeather(566);

		assertThat(event.getDay(), is(566));
		assertThat(event.getType(), is(SolarSystemEventType.RAIN));
	}

	@Test
	public void queryNoEventsDay() throws Exception {
		SolarSystemEvent event = query.getWeather(1);

		assertThat(event.getDay(), is(1));
		assertThat(event.getType(), is(SolarSystemEventType.NO_EVENT));
	}
}
