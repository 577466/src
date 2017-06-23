package com.cognizant.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
//@Table(name="TRANSACTION_DETAILS")
public class TransactionDetails {

	@Id
	@Column(name="TRANSACTION_ID")
	Long transactionId=(long) (Math.floor(Math.random() * 9000000000L) + 1000000000L);
	
	@NotNull(message="Mandatory field")
    @Size(min=4,max=50)
	@Column(name="TRANSACTION_DESCRIPTION")
	String transactionDescription;
	
	@NotNull(message="Mandatory field")
	@Column(name="TRANSACTION_TYPE")
	String transactionType;
	
	@NotNull(message="Mandatory field")
	@Min(value=1)
	
//@NotBlank
	//@Pattern(regexp=".+@.+\\.[a-z]+")
	
	@Column(name="TRANSACTION_AMOUNT")
	Double transactionAmount;
	
	@JsonBackReference
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="ACCOUNT_NUMBER")
		private UserDetails user;

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}


	public String getTransactionDescription() {
		return transactionDescription;
	}

	public void setTransactionDescription(String transactionDescription) {
		this.transactionDescription = transactionDescription;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(Double accountBalance) {
		this.transactionAmount = accountBalance;
	}
	
	

	@Override
	public String toString() {
		return "TransactionDetailsVO [transactionId=" + transactionId 
				+ ", transactionDescription=" + transactionDescription + ", transactionType=" + transactionType
				+ ", transactionAmount=" + transactionAmount + "]";
	}
	
	public TransactionDetails(){
		
	}
	
	

	public TransactionDetails(String transactionDescription, String transactionType, Double transactionAmount) {
		super();
		this.transactionDescription = transactionDescription;
		this.transactionType = transactionType;
		this.transactionAmount = transactionAmount;
	}

	public UserDetails getUser() {
		return user;
	}

	public void setUser(UserDetails user) {
		this.user = user;
	}

}
