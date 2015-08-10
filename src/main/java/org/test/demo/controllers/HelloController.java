package org.test.demo.controllers;

import java.util.List;

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
	
	@RequestMapping(value = "/getName")
	public ResponseEntity<List<Account>> getAccountName() {
		return new ResponseEntity<>(accountRepository.findAll(), HttpStatus.OK);
	}
}
