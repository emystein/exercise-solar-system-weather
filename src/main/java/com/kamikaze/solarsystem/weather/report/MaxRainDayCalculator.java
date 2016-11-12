package com.kamikaze.solarsystem.weather.report;

import java.util.List;

import com.kamikaze.solarsystem.weather.DayWeather;

public class MaxRainDayCalculator {

	public int calculate(List<DayWeather> rainyDays) {
		double maxRain = 0;
		int dayWithMaxRain = 0;

		for (DayWeather rainyDayWeather : rainyDays) {
			if (rainyDayWeather.getValue() > maxRain) {
				maxRain = rainyDayWeather.getValue();
				dayWithMaxRain = rainyDayWeather.getDay();
			}
		}

		return dayWithMaxRain;
	}

}
