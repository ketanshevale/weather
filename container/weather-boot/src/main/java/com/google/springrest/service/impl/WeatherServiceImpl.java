package com.google.springrest.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.springrest.entity.Weather;
import com.google.springrest.repository.WeatherProperty;
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

	@org.springframework.transaction.annotation.Transactional
	@Override
	public List<Weather> findAllCities(){
		return repository.findAll();
	}

	@org.springframework.transaction.annotation.Transactional(readOnly=true)	
	@Override
	public Weather findOneCity(String city) {
		return repository.findFirstByCityOrderByTimestampDesc(city).orElseThrow(() -> 
		new NotFound("City with name "+ city + "does not found"));
	}

	@org.springframework.transaction.annotation.Transactional(readOnly=true)	
	@Override
	public Map<String, Double> findOneCityProperty(String city, String property) {
		Weather weather = repository.findFirstByCityOrderByTimestampDesc(city).get();
		Method method;
		Map<String, Double> result = new HashMap<String, Double>();
		try {
			method = weather.getClass().getMethod(property);
			result.put(property, (Double) method.invoke(weather));
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}

		if(result.get(property) != null)
			return result;
		else
			throw new NotFound("City with name "+ city + "does not found");
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
