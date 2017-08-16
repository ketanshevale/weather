package com.google.weather.service;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.google.weather.entity.Weather;

public interface UserService {
//	public List<User> findAll();
//	public User findOne(@PathVariable("id") String userId);
//	public User create(@RequestBody User user);
//	public User update(@PathVariable("id") String id, @RequestBody User user);
//	public void delete(@PathVariable("id") String id);
	
	public Weather store(@RequestBody Weather weather);
	public List<String> findAllCities();
	public Weather findOneCity(@PathVariable("id") String city);
	public String findOneCityProperty(@PathVariable("id") String city, @PathVariable("property") String property);
	public List<Weather> findHourAverage(@PathVariable("id") String city);
	public List<Weather> findDayAverage(@PathVariable("id") String city);
}