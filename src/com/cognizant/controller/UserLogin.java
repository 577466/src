package com.cognizant.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cognizant.dao.UserDetailsDAO;
import com.cognizant.entity.EducationLoan;
import com.cognizant.entity.UserDetails;
@Controller
public class UserLogin {
	@Autowired
	UserDetailsDAO dao;
	
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String getEducationLoan(Model model,@RequestParam("AccNo") String AccNo) {
		//model.addAttribute("userDetails", new UserDetails());
		//System.out.println(" AccNo=" + AccNo);
		//System.out.println("in home");
		boolean flag=false;
		
		if(AccNo.matches(".*[^0-9].*"))
{
	 return "Error";
	  
}
		else
		{
		
			long accountNumber=Long.parseLong(AccNo);
		UserDetails userDetails=dao.getUserDetails( accountNumber);
		
		if(userDetails==null)
		{
			return "Error";
		}
		else
		{
			
		
		
		model.addAttribute("name",userDetails.getAcountHolderName());
		model.addAttribute("msg", AccNo);
		
		return "home";
		
		}
		}
		
	/*flag=dao.CheckDetailsLogin(accountNumber);
	  if(flag==true)
		
		return "home";
	  else
		  return "error";*/
	}
	@RequestMapping(value="/homepage",method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody  List<UserDetails> getList(@RequestParam("AccNo") String msg){
		//String accNum=request.getParameter("AccNo");
		//System.out.println(" AccNo=" + AccNo);
		
		Long accountNumber=Long.parseLong(msg);
	//System.out.println(msg);
	//System.out.println(accountNumber);
	//long accountNumber=1234567890123456l;
		UserDetails userDetails=dao.getUserDetails( accountNumber);
		
	List<UserDetails> List=new ArrayList<UserDetails>();
	userDetails.setEduLoan(null);
	userDetails.setTdDetails(null);
	userDetails.setHomeLoan(null);
	List.add(userDetails);

		return List;
		
		
		
		
	}

}
