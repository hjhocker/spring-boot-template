package org.test.demo.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ACCOUNT")
public class Account implements Serializable {

	private static final long serialVersionUID = -6518712641527492779L;
	
	@Id
	@Column(name = "ACCOUNT_ID")
	private long accountId;

}
