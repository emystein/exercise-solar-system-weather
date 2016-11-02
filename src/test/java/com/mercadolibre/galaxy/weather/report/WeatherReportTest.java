package com.mercadolibre.galaxy.weather.report;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mercadolibre.galaxy.SolarSystemTestSupport;
import com.mercadolibre.galaxy.weather.analysis.MaxRainDayCalculator;

public class WeatherReportTest extends SolarSystemTestSupport {
	private static final Logger logger = LoggerFactory.getLogger(WeatherReportTest.class);
	
	private static final int TEN_YEARS_IN_DAYS = 3650;
	
	private WeatherReport report;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		report = new WeatherReport(solarSystem, new MaxRainDayCalculator());
	}

	@Test
	public void report() throws Exception {
		WeatherReportResult reportResult = report.execute(TEN_YEARS_IN_DAYS);
		
		logger.debug(reportResult.toString());

		assertThat(reportResult.getEvents().size(), is(eventCollector.getEvents().size()));
	}

}
