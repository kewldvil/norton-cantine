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
	

}
