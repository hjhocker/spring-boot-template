package org.test.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.test.demo.domain.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

	public List<Account> findAll();
	public List<Account> findByAccountId(long accounId);
	
}
