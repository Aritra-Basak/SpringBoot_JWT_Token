package com.java.springBoot_jwt_demo.service;

import com.java.springBoot_jwt_demo.serviceInterface.ServiceIntf;
import com.java.springBoot_jwt_demo.entity.UserCredentials;
import com.java.springBoot_jwt_demo.repository.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements ServiceIntf {
	
	@Autowired
	UserRepo userRepository;

    @Override
    public List<UserCredentials> getAllUser() {
    	List<UserCredentials> list  = userRepository.findAll();
    	for(UserCredentials user :list) {
    		user.setIsActiveValue(user.getIsActive()==1?"Yes":"No");
    	}
    	return list;       
    }
}
