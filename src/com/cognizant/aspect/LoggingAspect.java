package com.cognizant.aspect;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.cognizant.controller.ApplyEducationLoanController;

//import com.cognizant.service.PerformTransactionService;

@Aspect
@Component
public class LoggingAspect {
	
	private static final Logger LOG = Logger.getLogger(ApplyEducationLoanController.class);


	@Before("execution(* com.cognizant.service..*(..))")
	public void LoggingAspect(JoinPoint joinPoint) {

		System.out.println("LoggingAspect() is running!");
		System.out.println("******");

		System.out.println("hijacked : " + joinPoint.getSignature());
		System.out.println("Before running loggingAdvice on method=" + joinPoint.toString());
		System.out.println("Agruments Passed=" + Arrays.toString(joinPoint.getArgs()));

	}

	/*
	 * @Before(
	 * "execution(* com.cognizant.service.PerformTransactionService.addUserDetails(..)"
	 * ) public void logBeforeAllMethods1(JoinPoint joinPoint) {
	 * System.out.println("****LoggingAspect.logBeforeAllMethods() : " +
	 * joinPoint.getSignature().getName()); }
	 */

	/*
	 * @After(
	 * "execution(* com.cognizant.service.PerformTransactionService.updateTransactionDetails(..)"
	 * ) public void LoggingAspect1(JoinPoint joinPoint) {
	 * 
	 * System.out.println("LoggingAspect1() is running!"); System.out.println(
	 * "hijacked "); System.out.println("******");
	 * 
	 * }
	 */


		@AfterReturning(pointcut = "execution(* com.cognizant.service..*(..))", returning = "result")
			public void logBefore1(JoinPoint joinPoint, Object result) {
				LOG.info("logBefore() is running!");
				System.out.println("hijacked : " + joinPoint.getSignature());
				System.out.println("Before running loggingAdvice on method=" + joinPoint.toString());

				System.out.println("Agruments Passed=" + Arrays.toString(joinPoint.getArgs()));
				System.out.println("******");
				System.out.println("Metod returns  " + result.toString());
			} 

	
	
}
