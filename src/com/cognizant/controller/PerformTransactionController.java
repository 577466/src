/*package com.cognizant.controller;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cognizant.entity.TransactionDetails;
import com.cognizant.service.PerformTransactionService;

@Controller
public class PerformTransactionController {
	@Autowired
	PerformTransactionService service;
	TransactionDetails transactionDetails;

	private static final Logger LOG = Logger.getLogger(PerformTransactionController.class);

	@RequestMapping(value = "/addTransaction", method = RequestMethod.GET)
	public String getEmployee(Model model) {

		model.addAttribute("transaction", new TransactionDetails());
		return "addTransaction";
	}

	@RequestMapping(value = "/addTransaction", method = RequestMethod.POST)
	public String initiateTransaction(@ModelAttribute("transaction") @Valid TransactionDetails transactionDetails,
			BindingResult result, Model model) {

		LOG.info("controller :" + transactionDetails);
		// transactionDetailsList = new ArrayList<TransactionDetailsVO>();
		// transactionDetailsList.add(transactionDetails);
		try {
			service.updateTransactionDetails(transactionDetails, 1234567890123546L);
		} catch (ConstraintViolationException e) {

			// e.printStackTrace();
			Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
			Iterator<ConstraintViolation<?>> iterator = constraintViolations.iterator();
			while (iterator.hasNext()) {
				ConstraintViolation<?> next = iterator.next();
				LOG.info("Validation message: " + next.getMessage());
				LOG.info("Invalid field: " + next.getPropertyPath());
				LOG.info("Validation class/bean: " + next.getRootBean());
				// result.reject(next.getPropertyPath(), next.getMessage());
				result.rejectValue(next.getPropertyPath().toString(), "", next.getMessage());
				// result.rejectValue(arg0, arg1, arg2);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("m1", transactionDetails.getTransactionId());

		if (result.hasErrors()) {
			return "addTransaction";
		}

		return "successTransaction";

	}

}
*/



package com.cognizant.controller;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cognizant.entity.TransactionDetails;
import com.cognizant.exception.InvalidAccountBalance;
import com.cognizant.service.PerformTransactionService;

@Controller
public class PerformTransactionController {
	@Autowired
	PerformTransactionService service;
	TransactionDetails transactionDetails;

	private static final Logger LOG = Logger.getLogger(PerformTransactionController.class);

	@RequestMapping(value = "/addTransaction", method = RequestMethod.GET)
	public String getEmployee(Model model,@RequestParam("AccNo") String AccNo) {

		model.addAttribute("msg", AccNo);
		model.addAttribute("transaction", new TransactionDetails());
		return "addTransaction";
	}
      
	@RequestMapping(value = "/addTransaction", method = RequestMethod.POST)
	public String initiateTransaction(@ModelAttribute("transaction") @Valid TransactionDetails transactionDetails,
			BindingResult result, Model model,@RequestParam("AccNo") long msg) {

		LOG.info("controller :" + transactionDetails);
		// transactionDetailsList = new ArrayList<TransactionDetailsVO>();
		// transactionDetailsList.add(transactionDetails);
		try {
			service.updateTransactionDetails(transactionDetails, msg);
		} catch (ConstraintViolationException e) {

			// e.printStackTrace();
			Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
			Iterator<ConstraintViolation<?>> iterator = constraintViolations.iterator();
			while (iterator.hasNext()) {
				ConstraintViolation<?> next = iterator.next();
				LOG.info("Validation message: " + next.getMessage());
				LOG.info("Invalid field: " + next.getPropertyPath());
				LOG.info("Validation class/bean: " + next.getRootBean());
				// result.reject(next.getPropertyPath(), next.getMessage());
				result.rejectValue(next.getPropertyPath().toString(), "", next.getMessage());
				// result.rejectValue(arg0, arg1, arg2);
			}
		} catch (InvalidAccountBalance e) {
			
			//System.out.println("in catch InvalidAccountBalance");
		
				String s[]=e.getMessage().split(":");
							result.rejectValue(s[0].toString(),"",s[1].toString());
							return "addTransaction"; 

			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		catch (Exception e) {
			//System.out.println("in catch exception");
			// TODO: handle exception
			e.printStackTrace();
		}
	

		
		if (result.hasErrors()) {
			return "addTransaction";
		}
		else
		{
		model.addAttribute("m1", transactionDetails.getTransactionId());
		model.addAttribute("m2", transactionDetails.getUser().getAccountBalance());
		return "successTransaction";
		}
        
	}

}
