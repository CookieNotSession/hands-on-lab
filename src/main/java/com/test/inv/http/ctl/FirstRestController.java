package com.test.inv.http.ctl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
public class FirstRestController {
	protected final Logger logger = LoggerFactory.getLogger(getClass());


	@GetMapping(value = "/hello/{name}")
	@ApiOperation(value = "say hello")
	public String hello(
			@ApiParam(name = "name", value = "name", defaultValue = "richard")
			@PathVariable String name) {
		return "hello "+ name;
	}
}
