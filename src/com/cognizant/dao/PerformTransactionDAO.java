/*package com.cognizant.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;

import com.cognizant.entity.TransactionDetails;
import com.cognizant.entity.UserDetails;

@Component
@ImportResource("classpath:beans.xml")
public class PerformTransactionDAO {

	private static final Logger LOG = Logger.getLogger(PerformTransactionDAO.class);

	@PersistenceContext
	private EntityManager em;

	public UserDetails updateTransactionDetails(Long accountNumber) {
		UserDetails user = em.find(UserDetails.class, accountNumber);
		LOG.info("dao user :" + user);
		return user;
	}

	public List<TransactionDetails> retrieveTransactionDetails(Long accountNumber) {

		UserDetails user = em.find(UserDetails.class, accountNumber);
		LOG.info(user);
		LOG.info(user.getTdDetails());
		List<TransactionDetails> transaction = user.getTdDetails();
		return transaction;

	}

}
*/





package com.cognizant.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;

import com.cognizant.entity.TransactionDetails;
import com.cognizant.entity.UserDetails;

@Component
@ImportResource("classpath:beans.xml")
public class PerformTransactionDAO {

	private static final Logger LOG = Logger.getLogger(PerformTransactionDAO.class);

	@PersistenceContext
	private EntityManager em;

	public UserDetails updateTransactionDetails(Long accountNumber) {
		UserDetails user = em.find(UserDetails.class, accountNumber);
		LOG.info("dao user :" + user);
		return user;
	}

	/*public List<TransactionDetails> retrieveTransactionDetails(Long accountNumber) {

		UserDetails user = em.find(UserDetails.class, accountNumber);
		LOG.info(user);
		LOG.info(user.getTdDetails());
		List<TransactionDetails> transaction = user.getTdDetails();
		return transaction;

	}*/

	public List<TransactionDetails> retrieveTransactionDetails1(Long accountNumber ,Long transactionId) {

		UserDetails user = em.find(UserDetails.class, accountNumber);
		//TransactionDetails transactions=em.find(TransactionDetails.class, transactionId);
		LOG.info(user);
		//LOG.info(transactions);
		LOG.info(user.getTdDetails());
		List<TransactionDetails> transaction = user.getTdDetails();
		return transaction;

	}
	
	
	@PersistenceContext
	private EntityManager em1;

	
	public void addUserDetails(UserDetails user) {
		// TODO Auto-generated method stub
		//System.out.println("before dao");
		//System.out.println(user);
		em1.persist(user);
		//System.out.println("after dao");
	}
	

}
