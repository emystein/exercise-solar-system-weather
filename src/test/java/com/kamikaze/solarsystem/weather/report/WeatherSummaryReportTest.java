package com.kamikaze.solarsystem.weather.report;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kamikaze.solarsystem.SolarSystemTestSupport;
import com.kamikaze.solarsystem.weather.report.MaxRainDayCalculator;
import com.kamikaze.solarsystem.weather.report.WeatherSummary;
import com.kamikaze.solarsystem.weather.report.WeatherSummaryReport;

public class WeatherSummaryReportTest extends SolarSystemTestSupport {
	private static final Logger logger = LoggerFactory.getLogger(WeatherSummaryReportTest.class);
	
	private static final int TEN_YEARS_IN_DAYS = 3650;
	
	private WeatherSummaryReport report;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		report = new WeatherSummaryReport(solarSystem, new MaxRainDayCalculator());
	}

	@Test
	public void report() throws Exception {
		WeatherSummary reportResult = report.execute(TEN_YEARS_IN_DAYS);
		
		logger.debug(reportResult.toString());

		assertThat(reportResult.getDroughtCount(), is(18L));
		assertThat(reportResult.getRainCount(), is(1187L));
		assertThat(reportResult.getMaxRainDay(), is(72L));
		assertThat(reportResult.getOptimalPreasureAndTemperatureCount(), is(24L));
	}

}
