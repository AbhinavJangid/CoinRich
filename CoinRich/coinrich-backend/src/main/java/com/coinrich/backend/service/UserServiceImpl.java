package com.coinrich.backend.service;

import java.util.Optional;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.coinrich.backend.dto.LoginDto;
import com.coinrich.backend.dto.UserDto;
import com.coinrich.backend.entity.User;
import com.coinrich.backend.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	private boolean patternMatches(String emailAddress, String regexPattern) {
		return Pattern.compile(regexPattern).matcher(emailAddress).matches();
	}

	@Override
	public String adduser(UserDto userDto) {
		User user = new User(userDto.getUserId(), userDto.getname(), userDto.getEmail(),
				this.passwordEncoder.encode(userDto.getPassword()));
		if (patternMatches(user.getEmail(), "^(.+)@(\\S+)$")) {
			userRepository.save(user);
			return user.getname();
		} else {
			return "Invalid Email Address";
		}

	}

	@Override
	public LoginResponse loginUser(LoginDto loginDto) {

		if (patternMatches(loginDto.getEmail(), "^(.+)@(\\S+)$")) {
			User user1 = userRepository.findByEmail(loginDto.getEmail());
			if (user1 != null) {
				String password = loginDto.getPassword();
				String encodedPassword = user1.getPassword();
				Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
				if (isPwdRight) {
					Optional<User> user = userRepository.findOneByEmailAndPassword(loginDto.getEmail(),
							encodedPassword);
					if (user.isPresent()) {
						return new LoginResponse("Login Success", true, user1.getname(), user1.getEmail());
					} else {
						return new LoginResponse("Login Failed", false);
					}
				} else {
					return new LoginResponse("password Not Match", false);
				}
			} else {
				return new LoginResponse("Email not exits", false);
			}
		} else {
			return new LoginResponse("Invalid Email", false);
		}

	}

}
