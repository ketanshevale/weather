package com.google.weather.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.google.weather.entity.User;
import com.google.weather.entity.Weather;
import com.google.weather.exception.BadRequest;
import com.google.weather.exception.NotFound;
import com.google.weather.repository.UserRepository;
import com.google.weather.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	private UserRepository repository;
	
	public UserServiceImpl(UserRepository repository) {
		this.repository = repository;
	}
	
	@Override
	@org.springframework.transaction.annotation.Transactional(readOnly=true)
	public List<User> findAll() {
		return repository.findAll();
	}

	@org.springframework.transaction.annotation.Transactional(readOnly=true)	
	@Override
	public User findOne(String id) {
		return repository.findOne(id).orElseThrow(() -> 
		new NotFound("User with id "+ id + "does not found"));
	}

	@org.springframework.transaction.annotation.Transactional
	@Override
	public User create(User user) {
		Optional<User> mayExists = repository.findByEmail(user.getEmail());
			if(mayExists.isPresent())
				throw new BadRequest("User with email "+ user.getEmail() + "already exists");
		return repository.create(user);
	}

	@org.springframework.transaction.annotation.Transactional
	@Override
	public User update(String id, User user) {
		repository.findOne(id).orElseThrow(() -> 
		new NotFound("User with id "+ id + "does not found"));
		return repository.update(user);
	}

	@org.springframework.transaction.annotation.Transactional
	@Override
	public void delete(String id) {
		User found = repository.findOne(id).orElseThrow(() -> 
		new NotFound("User with id "+ id + "does not found"));
		repository.delete(found);		
	}
	
	
	@Override
	public Weather store(Weather weather) {
		return repository.store(weather);		
	}
	
}
