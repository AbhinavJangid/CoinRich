package com.coinrich.backend.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
    private ApiKeyAuthFilter apiKeyAuthFilter;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable() // Disabling CSRF protection
            .addFilterBefore(apiKeyAuthFilter, UsernamePasswordAuthenticationFilter.class) // Add our custom filter
            .authorizeRequests()
                .anyRequest().authenticated(); // All requests must be authenticated
    }

}
