package com.google.springrest.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.springrest.constants.URI;
import com.google.springrest.entity.Weather;
import com.google.springrest.service.WeatherService;

@RestController
@RequestMapping(value=URI.WEATHER)
public class WeatherController {
	private WeatherService service;
	
	public WeatherController(WeatherService service) {
		this.service = service;
	}

	
	
	@CrossOrigin
	@ResponseBody
	@RequestMapping(value=URI.READ, method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Weather store(@RequestBody Weather weather){
		return service.store(weather);
	}
	
	//whatever is returned write to the response body
	@ResponseBody
	//This method should be called on get request, and produces json
	//As Jackson is available in dependency it will produce JSON object directly
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Weather> findAllCities(){
		return service.findAllCities();
	}	

	@ResponseBody
	//here we are using, template as anything come after employees will be parsed to id
	@RequestMapping(value=URI.ID, method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	//How to assign id to userId? use annotation PathVariable
	//for multiple variables, "/users/{id}/{city}" and (@PathVariable("id") String userId, @PathVariable("city") String city) 
	public Weather findOneCity(@PathVariable("id") String city){
		return service.findOneCity(city);
	}
	
	@ResponseBody
	//here we are using, template as anything come after employees will be parsed to id
	@RequestMapping(value=URI.IDPROPERTY, method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Map<String, Double> findOneCityProperty(@PathVariable("id") String city, @PathVariable("property") String property){
		return service.findOneCityProperty(city, property);
	}
	
	
	@ResponseBody
	@RequestMapping(value=URI.HOURID, method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Weather> findHourAverage(@PathVariable("id") String city){
		return service.findHourAverage(city);
	}
	
	@ResponseBody
	@RequestMapping(value=URI.DAYID, method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Weather> findDayAverage(@PathVariable("id") String city){
		return service.findDayAverage(city);
	}
}
