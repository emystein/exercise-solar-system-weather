package com.mercadolibre.galaxy.weather.report;

import java.util.List;

import com.mercadolibre.galaxy.weather.DayWeather;
import com.mercadolibre.galaxy.weather.Weather;

public class WeatherReportResult {

	private long numberOfDays;
	private List<DayWeather> dailyWeather;
	private long maxRainDay;
	private long droughtCount;
	private long rainCount;
	private long optimalPreasureAndTemperatureCount;
	
	public WeatherReportResult(long numberOfDays, List<DayWeather> dailyWeather, long maxRainDay) {
		this.numberOfDays = numberOfDays;
		this.dailyWeather = dailyWeather;
		this.maxRainDay = maxRainDay;
		this.droughtCount = countDayWeatherByType(dailyWeather, Weather.DROUGHT);
		this.rainCount = countDayWeatherByType(dailyWeather, Weather.RAIN);
		this.optimalPreasureAndTemperatureCount = countDayWeatherByType(dailyWeather, Weather.OPTIMAL_PREASSURE_AND_TEMPERATURE);
	}

	private long countDayWeatherByType(List<DayWeather> dailyWeather, Weather type) {
		return dailyWeather.stream().filter(dayWeather -> dayWeather.getWeather().equals(type)).count();
	}

	public List<DayWeather> getDailyWeather() {
		return dailyWeather;
	}

	public long getDroughtCount() {
		return droughtCount;
	}

	public long getRainCount() {
		return rainCount;
	}

	public long getMaxRainDay() {
		return maxRainDay;
	}

	public long getOptimalPreasureAndTemperatureCount() {
		return optimalPreasureAndTemperatureCount;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\n");
		builder.append("=====================").append("\n");
		builder.append("Galaxy Weather Report").append("\n");
		builder.append("=====================").append("\n");
		builder.append("Number of days: ").append(numberOfDays).append("\n");
		builder.append("Drought Count: ").append(droughtCount).append("\n");
		builder.append("Rain Count: ").append(rainCount).append("\n");
		builder.append("Day of maximum rain: ").append(maxRainDay).append("\n");
		builder.append("Optimal Preasure and Temperature Count: ").append(optimalPreasureAndTemperatureCount).append("\n");
		return builder.toString();
	}
	
	
}
