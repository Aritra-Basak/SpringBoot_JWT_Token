package com.java.springBoot_jwt_demo.service;

import com.java.springBoot_jwt_demo.serviceInterface.ServiceIntf;
import com.java.springBoot_jwt_demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService implements ServiceIntf {

	private List<User> userList = new ArrayList<>();
	
	public UserService() {
		userList.add(new User(UUID.randomUUID().toString(),"Aritra Basak","basakaritra10@gmail.com","Aritra123","ADMIN"));
		userList.add(new User(UUID.randomUUID().toString(),"Chandan Sarkar","chandansarkar32@gmail.com","Chandan123","USER"));
		userList.add(new User(UUID.randomUUID().toString(),"Sayoni Dutta","sayoni.dutta@in.ey.com","Sayoni123","USER"));
		userList.add(new User(UUID.randomUUID().toString(),"Promi Paul","promi.paul2002@gmail.com","Promi123","USER"));
	}
	

    @Override
    public List<User> getAllUser() {
        return this.userList;
    }
}
