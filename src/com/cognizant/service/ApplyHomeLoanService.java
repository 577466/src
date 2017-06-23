package com.cognizant.service;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.cognizant.dao.ApplyHomeLoanDao;
import com.cognizant.entity.HomeLoan;
import com.cognizant.entity.UserDetails;
import com.cognizant.exception.EducationLoanException;

@Component
@Transactional
public class ApplyHomeLoanService {
	@Autowired
	ApplyHomeLoanDao applyHomeLoanDao;
HomeLoan homeLoan;
java.sql.Date systemDate = new java.sql.Date(System.currentTimeMillis());
	private static final Logger LOG = Logger.getLogger(ApplyHomeLoanService.class);

	
	
	Random random = new Random();
	UserDetails userDetails = new UserDetails();
	ApplyHomeLoanService applyHomeLoanService;

	public void insertHomeDetails(UserDetails userDetails) {

		applyHomeLoanDao.insertHomeDetails(userDetails);

	}

	public String generateRandomNumber(long accoNum) {

		String a = String.valueOf(accoNum).substring(13);
		String id = "HL-" + a;
		return id;
	}
	public Long generateLoanAccNumber() {
		Long num = (long) (Math.random() * 100000000000000L);
		return num;
	}

	public void updateHomeLoanDetails(Long l, HomeLoan e6) throws EducationLoanException{

		if(e6.getLoanDuration()%5!=0 || 

				e6.getLoanDuration()>=20 || e6.getLoanDuration()<=0)
							throw new EducationLoanException("loanDuration:Please enter valid loan duration");
						
		Long income= e6.getAnnualIncome();
		Long loanAmount = e6.getLoanAmount();
						if(income!=(.10*loanAmount))
							throw new EducationLoanException("annualIncome:Please enter valid loan amount");
						
						if(loanAmount%1!=0)
							throw new EducationLoanException("loanAmount:Please enter valid loanAmount");
/*//						Date d1 = e6.getLoanApplyDate(); 
//
//						if(!(d1.after(systemDate))){
//							throw new BankManagementException("loanApplyDate:Please enter valid date");
//						}
*/						userDetails = applyHomeLoanDao.updateHomeLoanDetails(l);
						LOG.info("again");

						List<HomeLoan> list = userDetails.getHomeLoan();

		e6.setUser(userDetails);
		list.add(e6);
		userDetails.setHomeLoan(list);
		LOG.info(userDetails);

	}

}
