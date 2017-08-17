package com.google.springrest.service;

import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.google.springrest.entity.Weather;

public interface WeatherService {
	public Weather store(@RequestBody Weather weather);
	public List<Weather> findAllCities();
	public Weather findOneCity(@PathVariable("id") String city);
	public Map<String, Double> findOneCityProperty(@PathVariable("id") String city, @PathVariable("property") String property);
	public List<Weather> findHourAverage(@PathVariable("id") String city);
	public List<Weather> findDayAverage(@PathVariable("id") String city);
}
