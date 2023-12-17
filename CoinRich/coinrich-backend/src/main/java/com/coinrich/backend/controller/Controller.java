package com.coinrich.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.coinrich.backend.dto.LoginDto;
import com.coinrich.backend.dto.UserDto;
import com.coinrich.backend.service.CoinDataService;
import com.coinrich.backend.service.LoginResponse;
import com.coinrich.backend.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("api/v1/user")
public class Controller {

	@Autowired
	private UserService userService;

	@Autowired(required = false)
	private CoinDataService coinDataService;

	@PostMapping(path = "/save")
	public String saveUser(@RequestBody UserDto userDTO) {
		String id = userService.adduser(userDTO);
		return id;
	}

	@PostMapping(path = "/login")
	public ResponseEntity<?> loginUser(@RequestBody LoginDto loginDTO) {
		LoginResponse loginResponse = userService.loginUser(loginDTO);
		return ResponseEntity.ok(loginResponse);
	}

	@GetMapping("/getdata")
	public ResponseEntity<?> getCoinData() {
		return ResponseEntity.ok(coinDataService.getdata());

	}

}
