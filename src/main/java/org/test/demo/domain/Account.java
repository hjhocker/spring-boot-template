package org.test.demo.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ACCOUNT")
public class Account implements Serializable {

	private static final long serialVersionUID = -6518712641527492779L;

	@Id
	@Column(name = "ACCOUNT_ID")
	private long accountId;

	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@NotFound(action = NotFoundAction.IGNORE)
	@OneToMany(targetEntity = Transaction.class, mappedBy = "account", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Transaction> transactions;

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(Set<Transaction> transactions) {
		this.transactions = transactions;
	}

}
