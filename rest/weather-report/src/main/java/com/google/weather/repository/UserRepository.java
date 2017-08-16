package com.google.weather.repository;

import java.util.List;
import java.util.Optional;

import com.google.weather.entity.Weather;

public interface UserRepository {
//	public List<User> findAll();
//	public Optional<User> findOne(String userId);
//	public Optional<User> findByEmail(String email);
//	public User create(User user);
//	public User update(User user);
//	public void delete(User user);
	
	public Weather store(Weather weather);
	public List<String> findAllCities();
	public Optional<Weather> findOneCity(String city);
	public Optional<String> findOneCityProperty(String city, String property);
	public Optional<List<Weather>> findHourAverage(String city);
	public Optional<List<Weather>> findDayAverage(String city);
}