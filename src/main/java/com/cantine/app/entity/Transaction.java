package com.cantine.app.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

@Entity
@Table(name="TBL_TRANSACTION")
@DynamicUpdate(value=true)
@SelectBeforeUpdate(value=true) 
public class Transaction {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int transactionId;
	@Temporal(TemporalType.TIMESTAMP)
	private Date transactionDate;
	private double transactionAmountInRiel;
	private float transactionAmountInDollar;
	
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="transactionTypeId")
	private TransactionType transactionType;

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public double getTransactionAmountInRiel() {
		return transactionAmountInRiel;
	}

	public void setTransactionAmountInRiel(double transactionAmountInRiel) {
		this.transactionAmountInRiel = transactionAmountInRiel;
	}

	public float getTransactionAmountInDollar() {
		return transactionAmountInDollar;
	}

	public void setTransactionAmountInDollar(float transactionAmountInDollar) {
		this.transactionAmountInDollar = transactionAmountInDollar;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", transactionDate=" + transactionDate
				+ ", transactionAmountInRiel=" + transactionAmountInRiel + ", transactionAmountInDollar="
				+ transactionAmountInDollar + ", user=" + user + ", transactionType=" + transactionType + "]";
	}
	

	
	
}
