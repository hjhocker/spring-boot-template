package org.test.demo.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "REGISTERED_USERS")
public class RegisteredUsers implements Serializable {

	private static final long serialVersionUID = -2980911773850880749L;

	@Id
	@Column(name = "REGISTERED_USER_ID")
	private Long registeredUserId;
	
	@Column(name = "USERNAME")
	private String username;
	
}
