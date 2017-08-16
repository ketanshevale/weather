package com.google.springrest.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.springrest.entity.Weather;
import com.google.springrest.repository.WeatherRepository;
import com.google.springrest.service.WeatherService;
import com.google.springrest.exception.NotFound;

@Service
public class WeatherServiceImpl implements WeatherService{
	
	private WeatherRepository repository;
	@Autowired
	public WeatherServiceImpl(WeatherRepository repository) {
		this.repository = repository;
	}
	
	@org.springframework.transaction.annotation.Transactional
	@Override
	public Weather store(Weather weather) {
		System.out.println(weather);
		weather.getWind().setTimestamp(weather.getTimestamp());
		repository.save(weather.getWind());
		return repository.save(weather);
	}
	
//	@org.springframework.transaction.annotation.Transactional
//	@Override
//	public List<String> findAllCities(){
//		return repository.findAllByCity();
//	}

//	@org.springframework.transaction.annotation.Transactional(readOnly=true)	
//	@Override
//	public Weather findOneCity(String city) {
//		return repository.findOneCity(city).orElseThrow(() -> 
//		new NotFound("City with name "+ city + "does not found"));
//	}
//
//	@org.springframework.transaction.annotation.Transactional(readOnly=true)	
//	@Override
//	public Map<String, String> findOneCityProperty(String city, String property) {
//		return repository.findOneCityProperty(city, property).orElseThrow(() -> 
//		new NotFound("City with name "+ city + "does not found"));
//	}
//
//	@Override
//	public List<Weather> findHourAverage(String city) {
//		return repository.findHourAverage(city).orElseThrow(() -> 
//		new NotFound("City with name "+ city + "does not found"));
//	}
//
//	@Override
//	public List<Weather> findDayAverage(String city) {
//		return repository.findDayAverage(city).orElseThrow(() -> 
//		new NotFound("City with name "+ city + "does not found"));
//	}
	
}
