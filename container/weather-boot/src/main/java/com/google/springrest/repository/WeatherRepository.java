package com.google.springrest.repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.google.springrest.entity.Weather;
import com.google.springrest.entity.Wind;


public interface WeatherRepository extends Repository<Weather, Timestamp> {

	public Weather save(Weather weather);
	public Wind save(Wind wind);
	@Query("select DISTINCT w.city from Weather w")
	public List<Weather> findAll();
	public Optional<Weather> findFirstByCityOrderByTimestampDesc(String city);
	public Optional<Weather> findFirstByCityOrderByTimestampDesc(String city, String property);
	
	@Query(value = "SELECT a.id, a.timestamp, a.city, a.description, AVG(a.humidity) as humidity, "
			+ "AVG(a.pressure) as pressure, AVG(a.temperature) as temperature, AVG(b.speed) as speed, AVG(b.degree) as degree,"
			+ "b.id as wind_id FROM Weather a JOIN Wind b ON a.id = b.id "
			+ " where a.city = ?1 group by HOUR(a.timestamp)", nativeQuery=true)
	public Optional<List<Weather>> findHourAverage(String city);

	@Query(value = "SELECT a.id, a.timestamp, a.city, a.description, AVG(a.humidity) as humidity, "
			+ "AVG(a.pressure) as pressure, AVG(a.temperature) as temperature, AVG(b.speed) as speed, AVG(b.degree) as degree,"
			+ "b.id as wind_id FROM Weather a JOIN Wind b ON a.id = b.id "
			+ " where a.city = ?1 group by DAY(a.timestamp)", nativeQuery=true)
	public Optional<List<Weather>> findDayAverage(String city);
}
