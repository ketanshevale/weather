package com.google.weather.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.google.weather.entity.Weather;
import com.google.weather.exception.NotFound;
import com.google.weather.repository.WeatherRepository;
import com.google.weather.service.WeatherService;

@Service
public class WeatherServiceImpl implements WeatherService{

	private WeatherRepository repository;
	
	public WeatherServiceImpl(WeatherRepository repository) {
		this.repository = repository;
	}
		
	@org.springframework.transaction.annotation.Transactional
	@Override
	public Weather store(Weather weather) {
		return repository.store(weather);		
	}
	
	@org.springframework.transaction.annotation.Transactional
	@Override
	public List<String> findAllCities(){
		return repository.findAllCities();
	}

	@org.springframework.transaction.annotation.Transactional(readOnly=true)	
	@Override
	public Weather findOneCity(String city) {
		return repository.findOneCity(city).orElseThrow(() -> 
		new NotFound("City with name "+ city + "does not found"));
	}

	@org.springframework.transaction.annotation.Transactional(readOnly=true)	
	@Override
	public Map<String, String> findOneCityProperty(String city, String property) {
		return repository.findOneCityProperty(city, property).orElseThrow(() -> 
		new NotFound("City with name "+ city + "does not found"));
	}

	@Override
	public List<Weather> findHourAverage(String city) {
		return repository.findHourAverage(city).orElseThrow(() -> 
		new NotFound("City with name "+ city + "does not found"));
	}

	@Override
	public List<Weather> findDayAverage(String city) {
		return repository.findDayAverage(city).orElseThrow(() -> 
		new NotFound("City with name "+ city + "does not found"));
	}
}
