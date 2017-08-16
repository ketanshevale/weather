package com.google.weather.repository;

import java.util.List;
import java.util.Optional;

import com.google.weather.entity.User;
import com.google.weather.entity.Weather;

public interface UserRepository {
	public List<User> findAll();
	public Optional<User> findOne(String userId);
	public Optional<User> findByEmail(String email);
	public User create(User user);
	public User update(User user);
	public void delete(User user);
	
	public Weather store(Weather weather);
}
