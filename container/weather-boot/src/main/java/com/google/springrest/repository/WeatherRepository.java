package com.google.springrest.repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import com.google.springrest.entity.User;
import com.google.springrest.entity.Weather;
import com.google.springrest.entity.Wind;


public interface WeatherRepository extends Repository<Weather, Timestamp>{
	
//	public List<User> findAll();
//	public Optional<User> findOne(String userId);
//	public Optional<User> findByEmail(String email);
//	public User save(User user);
//	public void delete(User user);
	
	public Weather save(Weather weather);
	public Wind save(Wind wind);
	
//	public List<String> findAllByCity();

//	public Optional<Weather> findOneCity(String city);
//	public Optional<Map<String, String>> findOneCityProperty(String city, String property);
//	public Optional<List<Weather>> findHourAverage(String city);
//	public Optional<List<Weather>> findDayAverage(String city);
}
