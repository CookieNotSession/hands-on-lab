package com.test.inv.http.ctl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.inv.http.dao.UserDataRepository;
import com.test.inv.http.entity.UserData;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
public class DBApiController {
	protected final Logger logger = LoggerFactory.getLogger(getClass());


	@Autowired
	private UserDataRepository userDataRepository;
	
	@GetMapping(value = "/userdata/{name}")
	@ApiOperation(value = "查詢userdata")
	public ResponseEntity<UserData> userProfileData(
			@ApiParam(name = "name", value = "findByName", defaultValue = "richard")
			@PathVariable String name) {
		UserData userProfile = userDataRepository.findByName(name);
		return ResponseEntity.ok().body(userProfile);
	}
	
	@GetMapping(value = "/userdatas")
	@ApiOperation(value = "查詢all userdata")
	public ResponseEntity<List<UserData>> userProfiles() {

		List<UserData> userProfileList = userDataRepository.findAll();
		return ResponseEntity.ok(userProfileList);
	}
	
	@PostMapping(value = "/userdata")
	@ApiOperation(value = "新增userdata")
	@ResponseStatus(HttpStatus.OK)
	public void createUserProfile(
			@ApiParam(name = "userdata", value = "insert")
			@RequestBody UserData userData) {
		logger.info("userData => {}",userData);
		userDataRepository.saveAndFlush(userData);
	}
	
	
	
}
