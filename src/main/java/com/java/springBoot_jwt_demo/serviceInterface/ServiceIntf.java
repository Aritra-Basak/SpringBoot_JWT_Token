package com.java.springBoot_jwt_demo.serviceInterface;

import com.java.springBoot_jwt_demo.entity.ServiceResponse;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;

public interface ServiceIntf {

	 public ServiceResponse getAllUser();
	 
	 public ServiceResponse getUser(int id);
	 
	 public ResponseEntity<?> seviceCheck();
	 
	 public ServiceResponse getUser(HttpServletRequest request);
}
