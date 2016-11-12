package com.kamikaze.solarsystem.weather.report;

import java.util.List;

import com.kamikaze.solarsystem.weather.DayWeather;
import com.kamikaze.solarsystem.weather.Weather;

public class WeatherSummary {

	private long numberOfDays;
	private List<DayWeather> dailyWeather;
	private long maxRainDay;
	private long droughtCount;
	private long rainCount;
	private long optimalPreasureAndTemperatureCount;
	
	public WeatherSummary(long numberOfDays, List<DayWeather> dailyWeather, long maxRainDay) {
		this.numberOfDays = numberOfDays;
		this.dailyWeather = dailyWeather;
		this.maxRainDay = maxRainDay;
		this.droughtCount = countDayWeatherByType(dailyWeather, Weather.Drought);
		this.rainCount = countDayWeatherByType(dailyWeather, Weather.Rain);
		this.optimalPreasureAndTemperatureCount = countDayWeatherByType(dailyWeather, Weather.OptimalPreasureAndTemperature);
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
