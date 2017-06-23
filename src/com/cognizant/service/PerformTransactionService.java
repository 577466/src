/*package com.cognizant.service;

import java.util.ArrayList;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.cognizant.dao.PerformTransactionDAO;
import com.cognizant.entity.TransactionDetails;
import com.cognizant.entity.UserDetails;
import com.cognizant.exception.InvalidAccountBalance;

@Component
public class PerformTransactionService {

	private static final Logger LOG = Logger.getLogger(PerformTransactionService.class);

	@Autowired
	PerformTransactionDAO ptDAO;
	InvalidAccountBalance invalidAccountBalance;

	@Transactional
	public void updateTransactionDetails(TransactionDetails transaction, Long accountNumber)
			throws InvalidAccountBalance {
		System.out.println("inside service");
		UserDetails user = ptDAO.updateTransactionDetails(accountNumber);

		transaction.setUser(user);

		List<TransactionDetails> transactionList = new ArrayList<TransactionDetails>();
		LOG.info(transaction);
		transactionList.add(transaction);
		user.setTdDetails(transactionList);
		LOG.info(user);
		// updates the balance in user table
		updateUser(transaction.getTransactionAmount(), user, transaction.getTransactionType());

	}

	private void updateUser(int transactionAmount, UserDetails user, String transactionType)
			throws InvalidAccountBalance {
		int newBalance = 0;

		if (transactionType.equals("DEPOSIT")) {
			newBalance = user.getAccountBalance() + transactionAmount;
			user.setAccountBalance(newBalance);
		}

		else {
			newBalance = user.getAccountBalance() - transactionAmount;

			if (newBalance < 5000 && user.getAccountType().equals("SAVINGS")) {

				throw new InvalidAccountBalance("Saving Account's Balance can't be less than 5000");

			} else if (newBalance < 0) {

				throw new InvalidAccountBalance("Insufficient Balance");
			}

			else {

				user.setAccountBalance(newBalance);
			}
		}

	}

	@Transactional
	public List<TransactionDetails> retrieveTransactionDetails(Long accountNumber) {
		List<TransactionDetails> transactionDetails = ptDAO.retrieveTransactionDetails(accountNumber);
		return transactionDetails;

	}

}
*/

package com.cognizant.service;

import java.util.ArrayList;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.cognizant.dao.PerformTransactionDAO;
import com.cognizant.entity.TransactionDetails;
import com.cognizant.entity.UserDetails;
import com.cognizant.exception.InvalidAccountBalance;

@Component
public class PerformTransactionService {

	private static final Logger LOG = Logger.getLogger(PerformTransactionService.class);

	@Autowired
	PerformTransactionDAO ptDAO;
	InvalidAccountBalance invalidAccountBalance;
	TransactionDetails transaction=new TransactionDetails();


	@Transactional
	public void updateTransactionDetails(TransactionDetails transaction, Long accountNumber)
			throws InvalidAccountBalance {
		//System.out.println("inside service");
		UserDetails user = ptDAO.updateTransactionDetails(accountNumber);

		transaction.setUser(user);

		List<TransactionDetails> transactionList = new ArrayList<TransactionDetails>();
		LOG.info(transaction);
		transactionList.add(transaction);
		user.setTdDetails(transactionList);
		LOG.info(user);
		
		
		
		
		
		
		
	              
//	            for(TransactionDetails obj:userdetails)
	              //performTransactionDao.updateTransactionDetails(accountNumber);
	      
	            Double transactionAmount=transaction.getTransactionAmount();

	              if(!transaction.getTransactionType().equalsIgnoreCase("DEPOSIT") && !transaction.getTransactionType().equalsIgnoreCase("WITHDRAWAL") )
	              {
	                     throw new InvalidAccountBalance("Transaction Type should be DEPOSIT or WITHDRAWAL");
	              }
	       
	              
	              
	                     if(transaction.getTransactionType().equalsIgnoreCase("WITHDRAWAL")){
	                     
	                           if(transaction.getTransactionAmount()>user.getAccountBalance()){
	                                  throw new InvalidAccountBalance("transactionAmount:Withdrawal Amount is greater than balance");
	                           }
	                           else if(user.getAccountType().equalsIgnoreCase("SAVINGS")){
	                           
	                           if((user.getAccountBalance()-transaction.getTransactionAmount())<=5000)
	                           throw new InvalidAccountBalance("transactionAmount:Savings account balance must be above 5000");
	                     }
	                     else
	                    	 user.setAccountBalance(user.getAccountBalance()-transactionAmount);
	                     
	              }
	              else{
	            	  user.setAccountBalance(user.getAccountBalance()+transactionAmount);
	              }
	                     
	                     //String ta=Long.toString((long) trans1.getTransactionAmount()); 

	                     
	                     /*if(ta.matches("/[a-z][A-Z]{20}$"))
	                     {
	                           throw new TransactionExceptions(" Amount should be numeric");
	                     } */

	                     
	                    
	              
	              //usd.getAccountBalance()
	              
	       }
	       @Transactional
	       public void addUserDetails(UserDetails user) throws InvalidAccountBalance {
	             // System.out.println("in service");
	              user.setAccountNumber(generateAccountNumber());
	              
	              //public void addSingleUser(UserDetails user1) {
	                     
	                     
	                     if(user.getAccountType().equalsIgnoreCase("SAVINGS"))
	                     {
	                           if(user.getAccountBalance()<5000)
	                           {
	                                  throw new InvalidAccountBalance("Minimum balance in savings account should be greater than 5000");
	                           }
	                           
	                     }
	                     else
	                           if(user.getAccountType().equalsIgnoreCase("salary"))
	                           {
	                                  if(user.getAccountBalance()<0)
	                                  {
	                                         throw new InvalidAccountBalance("Minimum  balance in salary account should be 0");
	                                  }
	                           }
	                     
	                     ptDAO.addUserDetails(user);
	                    //System.out.println("after service");
	       }
	       
	              
	              //performTransactionDao.addUserDetails(user);
	              
	       public long generateAccountNumber(){
	             // System.out.println("In Service accNumber");
	              Long num=(long) (Math.random() * 10000000000000000L);
	              //System.out.println(num);
	              
	              return num;
	              
	              
	       }

		
		
		
		
		
		
		
		
		
		
		
		
		
		// updates the balance in user table
		//updateUser(transaction.getTransactionAmount(), user, transaction.getTransactionType());

	//}
        
	
	
	/*private void updateUser(int transactionAmount, UserDetails user, String transactionType)
			throws InvalidAccountBalance {

		
		int newBalance = 0;
		String regrex="[0-9]";
	
			int	a=Integer.parseInt(regrex);

		if (transactionType.equals("DEPOSIT")) {
			
			newBalance = user.getAccountBalance() + transactionAmount;
			user.setAccountBalance(newBalance);
		}

		else {
			newBalance = user.getAccountBalance() - transactionAmount;

			if (newBalance < 5000 && user.getAccountType().equals("SAVINGS")) {
				
				System.out.println("in 1st if");

				throw new InvalidAccountBalance("transactionAmount:Saving Account's Balance can't be less than 5000");

			} 
			else if(newBalance < 0) 
			{
				System.out.println("in 1st else");
				throw new InvalidAccountBalance("transactionAmount:Insufficient Balance");
			}
			
			/*else
				if(user.getAccountType().equals("SALARY")&& user.getAccountBalance()<0)
				{
				
					
						throw new InvalidAccountBalance("transactionAmount:Minimum  balance in salary account should be 0");
				}
			
				else if(transaction.getTransactionType().equals("WITHDRAWAL"))
				{
					System.out.println("in withdraw");
					if (user.getAccountBalance()<transaction.getTransactionAmount())
				{
					throw new InvalidAccountBalance("transactionAmount:Transaction amount must be less than account balance");
				}
				}*/
                      
			/**else {

				user.setAccountBalance(newBalance);
			}
		}*/

		

	
	/*@Transactional
	public List<TransactionDetails> retrieveTransactionDetails(Long accountNumber) {
		List<TransactionDetails> transactionDetails = ptDAO.retrieveTransactionDetails(accountNumber);
		return transactionDetails;

	}*/
	
	
	@Transactional
	public List<TransactionDetails> retrieveTransactionDetails1(Long accountNumber,Long transactionId) {
		List<TransactionDetails> transactionDetails = ptDAO.retrieveTransactionDetails1(accountNumber,transactionId);
		return transactionDetails;

	}
	
	}




			
			/*if(!transaction.getTransactionType().equals("deposit") && !transaction.getTransactionType().equals("withdrawal") )
			{
				throw new InvalidAccountBalance("transactionType:Transaction Type should be Deposit or Withdrawal");
			}
			
			else if(transaction.getTransactionType().equals("withdrawal"))
				{
					if(transaction.getTransactionAmount()>user.getAccountBalance())
					{
						throw new InvalidAccountBalance("transactionAmount:Withdrawal amount is greater than account balance");
					}
					 else if(user.getAccountType().equalsIgnoreCase("savings"))
					 {
	                     
	                     if((user.getAccountBalance()-transaction.getTransactionAmount())<=5000)
	                     throw new InvalidAccountBalance("transactionAmount:Savings account balance must be above 5000");
				}
			
			
				}
			
			
			
			else
				if(user.getAccountType().equals("salary"))
				{
					if(user.getAccountBalance()<0)
					{
						throw new InvalidAccountBalance("transactionAmount:Minimum  balance in salary account should be 0");
					}
				}
		
		

	}
		
	}*/


    
   
   // UserDetails user = new UserDetails();
   


   /* public void checkTransactionType(TransactionD
    * etails transaction, Long accountNumber) throws
    
    InvalidTransactionType
    


    {
    	UserDetails user = ptDAO.updateTransactionDetails(accountNumber);

		transaction.setUser(user);

		List<TransactionDetails> transactionList = new ArrayList<TransactionDetails>();
		LOG.info(transaction);
		transactionList.add(transaction);
		user.setTdDetails(transactionList);
		LOG.info(user);
		// updates the balance in user table
		updateUser(transaction.getTransactionAmount(), user, transaction.getTransactionType());

    }
	
    
    
    private void CheckUser(UserDetails user, String transactionType)
			throws   InvalidTransactionType
    {
		

		if ((transactionType.equals("DEPOSIT")||(transactionType.equals("WITHDRAWL"))) 
			
				{
			
			
		}

		
		}*/

	
	
	
	
	
	