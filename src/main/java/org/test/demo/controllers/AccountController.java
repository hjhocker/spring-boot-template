package org.test.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.test.demo.domain.Account;
import org.test.demo.domain.Transaction;
import org.test.demo.repository.AccountRepository;
import org.test.demo.repository.TransactionRepository;

@RestController
@RequestMapping(value = "/api")
public class AccountController {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private TransactionRepository transactionRepository;

	@RequestMapping(value = "/haha")
	public String getHaha() {
		return "haha";
	}

	@RequestMapping(value = "/getAccounts")
	public ResponseEntity<List<Account>> getAllUsers() {
		List<Account> accounts = accountRepository.findAll();
		return new ResponseEntity<List<Account>>(accounts, HttpStatus.OK);
	}

	@RequestMapping(value = "/getTransactions")
	public ResponseEntity<List<Transaction>> getTransactions() {
		List<Transaction> transactions = transactionRepository.findAll();
		return new ResponseEntity<List<Transaction>>(transactions, HttpStatus.OK);
	}
}
