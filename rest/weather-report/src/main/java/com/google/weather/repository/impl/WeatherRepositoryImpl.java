package com.google.weather.repository.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.google.weather.entity.Weather;
import com.google.weather.repository.WeatherRepository;

//we created these database lower level connectivity in separate class 
//because we can easily change it with other technologies

@Repository
public class WeatherRepositoryImpl implements WeatherRepository {

	@PersistenceContext
	private EntityManager em;	

	@Override
	public Weather store(Weather weather) {
		System.out.println(weather);
		weather.getWind().setId(weather.getId());
		em.persist(weather.getWind());
		em.persist(weather);
		return weather;	
	}	
	
	@Override
	public List<String> findAllCities(){
		TypedQuery<String> query = em.createNamedQuery("Weather.findAllCities", String.class);
		return query.getResultList();
	}
	
	@Override
	public Optional<Weather> findOneCity(String city) {
		TypedQuery<Weather> query = em.createNamedQuery("Weather.findByTime", Weather.class);
		query.setParameter("pCity", city);
		List<Weather> weather = query.getResultList();
		if(!weather.isEmpty())
		return Optional.of(weather.get(0));
		else
		return Optional.empty();
	}

	@Override
	public Optional<Map<String, String>> findOneCityProperty(String city, String property) {
		Map<String, String> map = new HashMap<>();
		Query query = em.createNativeQuery("SELECT "+ property + " from Weather where city = '" + city + "' order by timestamp DESC");
		String weather = query.getResultList().get(0).toString();

		if(weather != null){
			map.put(property, weather);
			return Optional.of(map);
		}
		else
			return Optional.empty();
	}

	@Override
	public Optional<List<Weather>> findHourAverage(String city) {
		Query query = em.createNamedQuery("Weather.findHourAverage");
		query.setParameter(1, city);
		@SuppressWarnings("unchecked")
		List<Weather> weather = query.getResultList();
		
		if(weather != null)
			return Optional.of(weather);
		else
			return Optional.empty();
		
	}

	@Override
	public Optional<List<Weather>> findDayAverage(String city) {		
		Query query = em.createNamedQuery("Weather.findDayAverage");
		query.setParameter(1, city);
		@SuppressWarnings("unchecked")
		List<Weather> weather = query.getResultList();
		
		if(weather != null)
			return Optional.of(weather);
		else
			return Optional.empty();
		
	}
}