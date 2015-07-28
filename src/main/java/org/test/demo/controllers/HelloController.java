package org.test.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class HelloController {

	@RequestMapping(value = "/hello")
	public String hello() {
		return "Hello World\n";
	}
}
