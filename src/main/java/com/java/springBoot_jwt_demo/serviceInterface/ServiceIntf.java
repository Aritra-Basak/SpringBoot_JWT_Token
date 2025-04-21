package com.java.springBoot_jwt_demo.serviceInterface;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;

import com.java.springBoot_jwt_demo.dto.ServiceResponse;

public interface ServiceIntf {

	 public ServiceResponse getAllUser();
	 
	 public ServiceResponse getUser(int id);
	 
	 public ResponseEntity<?> seviceCheck();
	 
	 public ServiceResponse getUser(HttpServletRequest request);
}
