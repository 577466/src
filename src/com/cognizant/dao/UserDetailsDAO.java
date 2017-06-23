package com.cognizant.dao;

import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.entity.UserDetails;
import java.util.List;

@Component
public class UserDetailsDAO {

	@PersistenceContext
	private EntityManager em;

	@Transactional
	public void addUser(UserDetails user) {
		em.persist(user);

	}
	public UserDetails getUserDetails(long l) {
		
		UserDetails retrive = em.find(UserDetails.class, l);

		return retrive;
	}

	
	
	}
	
	
	
	

