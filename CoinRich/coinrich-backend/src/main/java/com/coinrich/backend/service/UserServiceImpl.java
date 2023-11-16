package com.coinrich.backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

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
	
	

	@Override
	public String adduser(UserDto userDto) {
		User user = new User(
				userDto.getUserId(),
				userDto.getname(),
				userDto.getEmail(),
				this.passwordEncoder.encode(userDto.getPassword())				
		);
		
		userRepository.save(user);
		
		return user.getname();
	}



	@Override
	public LoginResponse loginUser(LoginDto loginDto) {

        String msg = "";
        User user1 = userRepository.findByEmail(loginDto.getEmail());
        if (user1 != null) {
            String password = loginDto.getPassword();
            String encodedPassword = user1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<User> user = userRepository.findOneByEmailAndPassword(loginDto.getEmail(), encodedPassword);
                if (user.isPresent()) {
                    return new LoginResponse("Login Success", true, user1.getname(), user1.getEmail());
                } else {
                    return new LoginResponse("Login Failed", false);
                }
            } else {
                return new LoginResponse("password Not Match", false);
            }
        }else {
            return new LoginResponse("Email not exits", false);
        }
    }
	
	
	/*
	 * private String thirdPartyApiUrl =
	 * "https://pro-api.coinmarketcap.com/v1/cryptocurrency/quotes/latest?symbol=BTC,ETHLTC";
	 * 
	 * 
	 * private String thirdPartyApiKey = "27ab17d1-215f-49e5-9ca4-afd48810c149";
	 * 
	 * 
	 * @Override public Object fetchDataFromAPI() { HttpHeaders headers = new
	 * HttpHeaders(); headers.set("X-CMC_PRO_API_KEY", thirdPartyApiKey);
	 * 
	 * RestTemplate restTemplate = new RestTemplate(); ResponseEntity<Object>
	 * response = restTemplate.getForEntity(thirdPartyApiUrl, Object.class);
	 * 
	 * return response.getBody(); }
	 */
	
	
    private String url = "https://pro-api.coinmarketcap.com/v1/cryptocurrency/quotes/latest?symbol=btc,bnb,bch,atom,ada";

    private String xRapidApiKey = "27ab17d1-215f-49e5-9ca4-afd48810c149";
	
	
	 @Autowired
	    private RestTemplate restTemplate;

	    public Object getAllCountryCovidData() {
	            try {
	                //Header value is set
	                HttpHeaders headers = new HttpHeaders();
	                headers.set("X-CMC_PRO_API_KEY", xRapidApiKey);

	                // Make a GET call to the RapidAPI

	                ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET,new HttpEntity<>(headers),String.class);

	                System.out.println("Output form rapidAPI:{}" + response.getBody());

	                return response.getBody();
	            }catch (Exception e){
	                System.out.println("Something went wrong while getting value from RapidAPI" +e);
	                throw new ResponseStatusException(
	                        HttpStatus.INTERNAL_SERVER_ERROR,
	                        "Exception while calling endpoint of RapidAPI for corona",
	                        e
	                );
	            }
	    }
}
