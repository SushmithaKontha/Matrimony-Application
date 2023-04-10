package com.matrimony.entity;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;


	@Entity
	@Table(name="payment")
	public class Payment {
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int id;
		@Column(name = "candidate_Name", nullable = false)
	    
	    private String candidateName;
		
	    @Column(name = "bank_Name", nullable = false)
	   
	    private String bankName;
		
	    @Column(name = "accountNumber", nullable = false)
	    private String accountNo;
		
	    @Column(name = "ifscCode", nullable = false)
	    private String ifscCode;
		
	    @Column(name = "amount", nullable = false)
	    private String amount;
	    
		public int getId() {
			return id;
		}

		public void setId(int Id) {
			this.id = Id;
		}

		public String getCandidateName() {
			return candidateName;
		}

		public void setCandidateName(String candidateName) {
			this.candidateName = candidateName;
		}

		public String getBankName() {
			return bankName;
		}

		public void setBankName(String bankName) {
			this.bankName = bankName;
		}

		public String getAccountNo() {
			return accountNo;
		}

		public void setAccountNo(String accountNo) {
			this.accountNo = accountNo;
		}

		public String getIfscCode() {
			return ifscCode;
		}

		public void setIfscCode(String ifscCode) {
			this.ifscCode = ifscCode;
		}

		public String getAmount() {
			return amount;
		}

		public void setAmount(String amount) {
			this.amount = amount;
		}

				

				
				}



