package org.test.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.test.demo.domain.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, String> {
	
}