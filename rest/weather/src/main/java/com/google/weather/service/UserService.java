package com.google.weather.service;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.google.weather.entity.User;
import com.google.weather.entity.Weather;

public interface UserService {
	public List<User> findAll();
	public User findOne(@PathVariable("id") String userId);
	public User create(@RequestBody User user);
	public User update(@PathVariable("id") String id, @RequestBody User user);
	public void delete(@PathVariable("id") String id);
	
	public Weather store(@RequestBody Weather weather);
}
