package com.coinrich.backend.service;

import org.springframework.stereotype.Service;

import com.coinrich.backend.dto.LoginDto;
import com.coinrich.backend.dto.UserDto;

@Service
public interface UserService {

	String adduser(UserDto userDTO);

	LoginResponse loginUser(LoginDto loginDto);

}
