package com.google.weather.controller;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.weather.constants.URI;
import com.google.weather.entity.Weather;
import com.google.weather.service.UserService;

@RestController
@RequestMapping(value=URI.API+URI.WEATHER)
public class UserController {
	private UserService service;
	
	public UserController(UserService service){
		this.service = service;
	}
	
//	//whatever is returned write to the response body
//	@ResponseBody
//	//This method should be called on get request, with value /employees, and produces json
//	//As Jackson is available in dependency it will produce JSON object directly
//	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
//	public List<User> findAll(){
//		return service.findAll();
//	}
	
//	@ResponseBody
//	//here we are using, template as anything come after employees will be parsed to id
//	@RequestMapping(value=URI.ID, method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
//	//How to assign id to userId? use annotation PathVariable
//	//for multiple variables, "/users/{id}/{city}" and (@PathVariable("id") String userId, @PathVariable("city") String city) 
//	public User findOne(@PathVariable("id") String userId){
//		return service.findOne(userId);
//	}
//
//	@ResponseBody
//	//As it consumes JSON
//	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
//	//We are using user object from RequestBody so use @RequestBody
//	public User create(@RequestBody User user){
//		return service.create(user);
//	}
//
//	@ResponseBody
//	@RequestMapping(value=URI.ID, method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
//	//We are using id from PathVariable  so use @PathVariable, using user from RequestBody so @RequestBody
//	public User update(@PathVariable("id") String id, @RequestBody User user){
//		return service.update(id, user);
//	}
//	
//	@ResponseBody
//	@RequestMapping(value=URI.ID, method=RequestMethod.DELETE, produces=MediaType.TEXT_PLAIN_VALUE)
//	public void delete(@PathVariable("id") String id){
//		service.delete(id);
//	}

///////////////////////////////////////////////////////	//////////////////////////
	
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
	public List<String> findAllCities(){
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
	//How to assign id to userId? use annotation PathVariable
	//for multiple variables, "/users/{id}/{city}" and (@PathVariable("id") String userId, @PathVariable("city") String city) 
	public String findOneCityProperty(@PathVariable("id") String city, @PathVariable("property") String property){
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