package com.mercadolibre.orbit.query;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.mercadolibre.orbit.SolarSystemEvent;
import com.mercadolibre.orbit.SolarSystemEventType;
import com.mercadolibre.orbit.SolarSystemTestSupport;

public class WeatherQueryTest extends SolarSystemTestSupport {

	@Test
	public void queryDay() throws Exception {
		WeatherQuery query = new WeatherQuery(solarSystem);
		
		SolarSystemEvent event = query.getWeather(566);
		
		assertThat(event.getDay(), is(566));
		assertThat(event.getType(), is(SolarSystemEventType.RAIN));
	}
}
