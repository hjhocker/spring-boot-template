package org.test.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.test.demo.domain.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {

	public List<Account> findAll();
	public List<Account> findByAccountId(long accounId);
	
}
