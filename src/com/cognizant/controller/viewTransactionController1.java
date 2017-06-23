package com.cognizant.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cognizant.entity.TransactionDetails;
import com.cognizant.service.PerformTransactionService;

@Controller
public class viewTransactionController1

{
	
	@Autowired
	PerformTransactionService service;
	TransactionDetails transactionDetails;
	private static final Logger LOG = Logger.getLogger(viewTransactionController1.class);

	@RequestMapping(value = "/viewTransaction", method = RequestMethod.GET)
	public String searchUserTransaction(@RequestParam("AccNo") String AccNo,Model model,@RequestParam("transactionId") Long transactionId) {
		Long accountNumber=Long.parseLong(AccNo);
		//System.out.println(AccNo);
		//System.out.println(accountNumber);
		model.addAttribute( AccNo);
		model.addAttribute(transactionId);
		return "viewTransaction";
	}

	@RequestMapping(value = "/getTransactionDetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)

	public @ResponseBody List<TransactionDetails> getUserDetails(@RequestParam("AccNo") String AccNo,@RequestParam("transactionId") Long transactionId) {

		Long accountNumber=Long.parseLong(AccNo);
		//System.out.println(msg);
		//System.out.println(accountNumber);
		List<TransactionDetails> transactionDetailsList = service.retrieveTransactionDetails1(accountNumber, transactionId);

		LOG.info("controller:" + transactionDetailsList);
		return transactionDetailsList;

	}
}
