package com.java.springBoot_jwt_demo.service;

import com.java.springBoot_jwt_demo.serviceInterface.ServiceIntf;

import jakarta.servlet.http.HttpServletRequest;

import com.java.springBoot_jwt_demo.dto.ServiceResponse;
import com.java.springBoot_jwt_demo.repository.UserRepo;
import com.java.springBoot_jwt_demo.security.JwtHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService implements ServiceIntf {
	
	@Autowired
	private UserRepo userRepo;
	
	 @Autowired
	private JwtHelper jwtHelper;

	@Override
	public ServiceResponse getAllUser() {
		try {
			ServiceResponse serviceResponse = ServiceResponse.builder().entityCount(userRepo.count()).resMessage("Success: Found all the User Details").resObject(userRepo.findAll()).status(HttpStatus.OK).statusCode(1).build();
			return serviceResponse;
		}catch(Exception e) {
			e.printStackTrace();
			ServiceResponse serviceResponse = ServiceResponse.builder().entityCount(0).resMessage("Failure: No Users Found").status(HttpStatus.BAD_REQUEST).statusCode(0).build();
			return serviceResponse;
		}
		
	}

	
	@Override
	public ServiceResponse getUser(int id) {
		try {
			ServiceResponse serviceResponse = ServiceResponse.builder().entityCount(1).resMessage("Success: Found the User Details").resObject(userRepo.findById(id)).status(HttpStatus.OK).statusCode(1).build();
			return serviceResponse;
		}catch(Exception e) {
			e.printStackTrace();
			ServiceResponse serviceResponse = ServiceResponse.builder().entityCount(0).resMessage("Failure: No Users Found").status(HttpStatus.BAD_REQUEST).statusCode(0).build();
			return serviceResponse;
		}
	}
	
	public ServiceResponse getUser(HttpServletRequest request) {
		String requestHeader="",token="",userName="";
		try {
			requestHeader = request.getHeader("Authorization");
			if (requestHeader != null && requestHeader.startsWith("Bearer"))
				token = requestHeader.substring(7);
			 userName = this.jwtHelper.getUsernameFromToken(token);
			ServiceResponse serviceResponse = ServiceResponse.builder().entityCount(1).resMessage("Success: Found the User Details").resObject(userRepo.findByEmail(userName)).status(HttpStatus.OK).statusCode(1).build();
			return serviceResponse;
		}catch(Exception e) {
			e.printStackTrace();
			ServiceResponse serviceResponse = ServiceResponse.builder().entityCount(0).resMessage("Failure: No Users Found").status(HttpStatus.BAD_REQUEST).statusCode(0).build();
			return serviceResponse;
		}
	}

	@Override
	public ResponseEntity<?> seviceCheck() {
		try {
			return new ResponseEntity<String>("API Service working fine.",HttpStatus.OK);
		}catch(Exception e ) {
			return new ResponseEntity<String>("API Service is down."+e.getMessage(),HttpStatus.SERVICE_UNAVAILABLE);
		}
	}
	
	

}
