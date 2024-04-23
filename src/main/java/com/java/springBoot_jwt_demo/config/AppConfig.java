package com.java.springBoot_jwt_demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.java.springBoot_jwt_demo.entity.UserCredentials;
import com.java.springBoot_jwt_demo.repository.UserRepo;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {
	
	@Autowired
	UserRepo userRepository;

    //Spring Security class to proceed with login.
    //Uses a spring security pre-built entity-User to store all the details that will be used while login
 
	@Bean
    public UserDetailsService userDetailsService(){
    	List<UserCredentials> userList = userRepository.findAll();
    	List<UserDetails> userDetailsList = new ArrayList<>();
    	for(UserCredentials user:userList) {
    		UserDetails userDetails = User.builder().username(user.getEmail()).password(passwordEncoder().encode(user.getPassword())).authorities(user.getRole()).roles(user.getRole()).build();
    		userDetailsList.add(userDetails);
    	}
        return new InMemoryUserDetailsManager(userDetailsList);
    }

    //Default Password Encoder from Spring Security.
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
        return builder.getAuthenticationManager();
    }
}
