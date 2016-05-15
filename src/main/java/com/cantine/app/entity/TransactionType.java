package com.cantine.app.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

@Entity
@Table(name="TBL_TRANSACTIONTYPE")
@DynamicUpdate(value=true)
@SelectBeforeUpdate(value=true) 
public class TransactionType {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int transactionTypeId;
	private String transactionTypeName;
	
	
	@OneToMany(mappedBy="transactionType")
	private List<Transaction> transaction;
	
	public int getTransactionTypeId() {
		return transactionTypeId;
	}

	public void setTransactionTypeId(int transactionTypeId) {
		this.transactionTypeId = transactionTypeId;
	}

	public String getTransactionTypeName() {
		return transactionTypeName;
	}

	public void setTransactionTypeName(String transactionTypeName) {
		this.transactionTypeName = transactionTypeName;
	}

	public List<Transaction> getTransaction() {
		return transaction;
	}

	public void setTransaction(List<Transaction> transaction) {
		this.transaction = transaction;
	}

	@Override
	public String toString() {
		return "TransactionType [transactionTypeId=" + transactionTypeId + ", transactionTypeName="
				+ transactionTypeName + ", transaction=" + transaction + "]";
	}


}
