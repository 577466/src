package test.java;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cognizant.entity.HomeLoan;
import com.cognizant.entity.UserDetails;
import com.cognizant.exception.EducationLoanException;
import com.cognizant.service.ApplyHomeLoanService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:beans.xml" })
public class TestApplyHomeLoan {
	private UserDetails userDetails;
	private List<HomeLoan> homeLoan = new ArrayList<HomeLoan>();
	@Autowired
	ApplyHomeLoanService applyHomeLoanService;

	@Before
	public void setup() throws ParseException {
		userDetails = new UserDetails(1234567890123546L, "saving", "Aman", 4785655d);

		
		Date d1=new Date(2018-07-26);
		Date d2=new Date(2017-06-02);
		
		HomeLoan e6 = new HomeLoan(12378L, 3, d1, 22000L, "ford", "manager", 8, 2, userDetails);
		HomeLoan e7 = new HomeLoan(123L, 7, d2, 88000L, "hella", "manager", 7, 2, userDetails);

		//System.out.println("12");
		long loanACCNum = applyHomeLoanService.generateLoanAccNumber();
		long loanACCNum1 = applyHomeLoanService.generateLoanAccNumber();
		String id = applyHomeLoanService.generateRandomNumber(userDetails.getAccountNumber());
		//System.out.println(id);
		e6.setLoanAccountNumber(loanACCNum);
		//System.out.println(loanACCNum);
		e7.setLoanAccountNumber(loanACCNum1);
		//System.out.println(loanACCNum1);
		e6.setHomeLoanId(id);
		e7.setHomeLoanId(id);
		homeLoan.add(e6);
		homeLoan.add(e7);
		//System.out.println(e6);
		//System.out.println(e7);

	}
//@Test
	public void testApplyHomeLoan() {
		//System.out.println("13");

		userDetails.setHomeLoan(homeLoan);
		//System.out.println(userDetails);
		//System.out.println(homeLoan);
		applyHomeLoanService.insertHomeDetails(userDetails);
		//System.out.println("14");

	}

	 @Test
	public void updateHomeLoanDetails() throws ParseException, EducationLoanException {
		
		Date d3=new Date(20-12-2017);
		HomeLoan e8 = new HomeLoan(123L, 5, d3, 88700L, "cogni", "manager", 9, 4, userDetails);
		Long loanACCNum = applyHomeLoanService.generateLoanAccNumber();
		String id = applyHomeLoanService.generateRandomNumber(1234567890123456L);
		e8.setHomeLoanId(id);
		e8.setLoanAccountNumber(loanACCNum);
		applyHomeLoanService.updateHomeLoanDetails(1234567890123456L, e8);
	}

}
