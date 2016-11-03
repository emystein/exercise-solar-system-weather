package com.mercadolibre.galaxy.weather;

public class DayWeather {

	private int day;
	private Weather weather;
	private double value;

	public DayWeather(int day, Weather weather, double value) {
		this.day = day;
		this.weather = weather;
		this.value = value;
	}
	
	public DayWeather(int day, Weather weather) {
		this(day, weather, 0);
	}

	public int getDay() {
		return day;
	}

	public Weather getWeather() {
		return weather;
	}

	public double getValue() {
		return value;
	}

}
