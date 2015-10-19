package org.test.demo.controllers;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.test.demo.domain.Account;
import org.test.demo.repository.AccountRepository;

@RestController
@RequestMapping(value = "/api")
public class HelloController {

	@Autowired
	private AccountRepository accountRepository;

	@RequestMapping(value = "/hello")
	public String hello() {
		return "Hello World\n";
	}

	@RequestMapping(value = "/getNames")
	public ResponseEntity<List<String>> getAccountName() {
		List<Account> accounts = accountRepository.findAll();
		List<String> names = new ArrayList<String>();
		for (Account account : accounts) {
			if (account.getFirstName() != null && account.getLastName() != null) {
				names.add(account.getFirstName() + " " + account.getLastName());
			}
		}
		return new ResponseEntity<>(names, HttpStatus.OK);
	}
}
