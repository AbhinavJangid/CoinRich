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
import com.coinrich.backend.service.LoginResponse;
import com.coinrich.backend.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("api/v1/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping(path = "/save")
	public String saveUser(@RequestBody UserDto userDTO) {
		String id = userService.adduser(userDTO);
		return id;
	}

	@PostMapping(path = "/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDto loginDTO)
    {
        LoginResponse loginResponse = userService.loginUser(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }

	@GetMapping("/location")
	private String getISSLocation()
	{
	    String url = "https://dummyjson.com/products";
	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(url, String.class);
	    return result;
	}
	
	/*
	 * @GetMapping("/datadedo") public Object fetchDataFromAPI() {
	 * 
	 * return userService.fetchDataFromAPI(); }
	 */
	
	@GetMapping("/getdata")
	public ResponseEntity<?> callRapidEndpointToGetCovidData(){
        return ResponseEntity.ok(userService.getAllCountryCovidData());

    }
	
	
}
