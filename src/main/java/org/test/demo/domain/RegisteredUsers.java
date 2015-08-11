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

	@Column(name = "TOKEN")
	private String token;

	public Long getRegisteredUserId() {
		return registeredUserId;
	}

	public void setRegisteredUserId(Long registeredUserId) {
		this.registeredUserId = registeredUserId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
