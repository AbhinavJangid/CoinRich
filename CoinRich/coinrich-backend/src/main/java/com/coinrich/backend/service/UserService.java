package com.coinrich.backend.service;

import com.coinrich.backend.dto.LoginDto;
import com.coinrich.backend.dto.UserDto;

public interface UserService {

	String adduser(UserDto userDTO);
	
	LoginResponse loginUser(LoginDto loginDto);
	
	/* Object fetchDataFromAPI() ; */
	
	 Object getAllCountryCovidData();

}
