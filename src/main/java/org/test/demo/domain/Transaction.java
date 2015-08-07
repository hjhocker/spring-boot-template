package org.test.demo.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TRANSACTION")
public class Transaction implements Serializable {

	private static final long serialVersionUID = -7714943686924094140L;

	@Id
	@Column(name = "TRANSACTION_ID")
	private Long transactionId;
	
	@Column(name = "LOCATION")
	private String location;
	
	@Column(name = "AMOUNT")
	private Double amount;

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "TRANSACTION_ID", insertable = false, updatable = false)
	private Account account;
	
	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
}
