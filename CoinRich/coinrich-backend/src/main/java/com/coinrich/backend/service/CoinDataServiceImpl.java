package com.coinrich.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

public class CoinDataServiceImpl implements CoinDataService {

	private String url = "https://pro-api.coinmarketcap.com/v1/cryptocurrency/quotes/latest?symbol=btc,bnb,bch,atom,ada";

	private String xRapidApiKey = "27ab17d1-215f-49e5-9ca4-afd48810c149";

	@Autowired
	private RestTemplate restTemplate;

	public Object getdata() {
		try {
			// Header value is set
			HttpHeaders headers = new HttpHeaders();
			headers.set("X-CMC_PRO_API_KEY", xRapidApiKey);

			// Make a GET call to the RapidAPI

			ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(headers),
					String.class);

			System.out.println("Output form rapidAPI:{}" + response.getBody());

			return response.getBody();
		} catch (Exception e) {
			System.out.println("Something went wrong while getting value from RapidAPI" + e);
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Exception while calling endpoint of RapidAPI for corona", e);
		}
	}

}
