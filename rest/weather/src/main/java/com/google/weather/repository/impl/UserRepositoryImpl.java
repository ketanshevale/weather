package com.google.weather.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.google.weather.entity.User;
import com.google.weather.entity.Weather;
import com.google.weather.repository.UserRepository;

//we created these database lower level connectivity in separate class 
//because we can easily change it with other technologies

@Repository
public class UserRepositoryImpl implements UserRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<User> findAll() {
		TypedQuery<User> query = em.createNamedQuery("User.findAll", User.class);
		return query.getResultList();
	}

	@Override
	public Optional<User> findOne(String id) {
		return Optional.ofNullable(em.find(User.class, id));
	}
	
	@Override
	public Optional<User> findByEmail(String email) {
		TypedQuery<User> query = em.createNamedQuery("User.findByEmail", User.class);
		query.setParameter("pEmail", email);
		List<User> users = query.getResultList();
		if(!users.isEmpty())
			return Optional.of(users.get(0));
		else
			return Optional.empty();
	}
	
	@Override
	public User create(User user) {
		em.persist(user);
		return user;
	}

	@Override
	public User update(User user) {
		return em.merge(user);
	}

	@Override
	public void delete(User user) {
		em.remove(user);
	}

	@Override
	public Weather store(Weather weather) {
		System.out.println(weather);
		return weather;	
	}	
}