package com.google.springrest.repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

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
	@Query("select DISTINCT w.city from Weather w")
	public List<String> findAll();
	public Optional<Weather> findFirstByCityOrderByTimestampDesc(String city);
	public Optional<Weather> findFirstByCityOrderByTimestampDesc(String city, String property);
	
//	public Optional<List<Weather>> findHourAverage(String city);
//	public Optional<List<Weather>> findDayAverage(String city);
}
