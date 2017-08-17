package com.google.weather.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.google.weather.entity.Weather;

public interface WeatherRepository {
	public Weather store(Weather weather);
	public List<String> findAllCities();
	public Optional<Weather> findOneCity(String city);
	public Optional<Map<String, String>> findOneCityProperty(String city, String property);
	public Optional<List<Weather>> findHourAverage(String city);
	public Optional<List<Weather>> findDayAverage(String city);
}