package com.mercadolibre.galaxy.weather.report;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mercadolibre.galaxy.SolarSystemTestSupport;
import com.mercadolibre.galaxy.weather.analysis.MaxRainDayCalculator;
import com.mercadolibre.galaxy.weather.report.WeatherReport;
import com.mercadolibre.galaxy.weather.report.WeatherReportResult;

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

		Assert.assertThat(reportResult.getEvents().size(), Matchers.is(eventCollector.getEvents().size()));
	}

}
