package com.mercadolibre.galaxy.weather.report;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.mercadolibre.galaxy.weather.DayWeather;
import com.mercadolibre.galaxy.weather.Weather;

public class MaxRainDayCalculatorTest {

	@Test
	public void calculate() throws Exception {
		List<DayWeather> list= new ArrayList<>();
		list.add(new DayWeather(1, Weather.Rain, 1));
		list.add(new DayWeather(2, Weather.Rain, 5));
		list.add(new DayWeather(3, Weather.Rain, 1));

		MaxRainDayCalculator calculator = new MaxRainDayCalculator();
		
		double maxRainDay = calculator.calculate(list);

		assertThat(maxRainDay, is(2d));
	}
}
