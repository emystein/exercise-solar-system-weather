package com.mercadolibre.galaxy.weather.report;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mercadolibre.galaxy.SolarSystemTestSupport;
import com.mercadolibre.galaxy.weather.DayWeather;

public class WeatherDetailedReportTest extends SolarSystemTestSupport {
	private static final Logger logger = LoggerFactory.getLogger(WeatherDetailedReportTest.class);
	
	private static final int TEN_YEARS_IN_DAYS = 3650;
	
	private WeatherDetailedReport report;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		report = new WeatherDetailedReport(solarSystem);
	}

	@Test
	public void report() throws Exception {
		List<DayWeather> reportResult = report.execute(TEN_YEARS_IN_DAYS);
		
		printReportResult(reportResult);

		assertThat(reportResult.size(), is(TEN_YEARS_IN_DAYS));
	}

	private void printReportResult(List<DayWeather> reportResult) {
		StringBuilder builder = new StringBuilder();
		
		builder.append("\n");
		
		for (DayWeather dayWeather : reportResult) {
			builder.append(dayWeather.toString()).append("\n");
		}

		logger.debug(builder.toString());
	}

}
