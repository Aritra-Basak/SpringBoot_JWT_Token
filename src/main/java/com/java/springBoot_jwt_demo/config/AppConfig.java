package com.java.springBoot_jwt_demo.config;

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

@Configuration
public class AppConfig {

    //Spring Security class to proceed with login.
    //Uses a spring security pre-built entity-User to store all the details that will be used while login
    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails userDetails = User.builder().username("basakaritra10@gmail.com").password(passwordEncoder().encode("Aritra123")).roles("ADMIN").build();
        UserDetails userDetails1 = User.builder().username("sarkarchandan32@gmail.com").password(passwordEncoder().encode("Chandan123")).roles("USER").build();
        return new InMemoryUserDetailsManager(userDetails,userDetails1);
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
