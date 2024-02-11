 package com.java.springBoot_jwt_demo;

import com.java.springBoot_jwt_demo.entity.User;
//import com.java.springBoot_jwt_demo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

 @SpringBootApplication
public class SpringBootJwtDemoApplication {

//	 @Autowired
//	 UserRepo userRepo;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJwtDemoApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		List<User> userList = new ArrayList<>();
//
//		User user = User.builder().name("Aritra Basak").email("basakaritra10@gmail.com").password("Aritra123").role("ADMIN").build();
//		userList.add(user);
//		User user1 = User.builder().name("Chandan Sarkar").email("sarkarchandan32@gmail.com").password("Chandan123").role("USER").build();
//		userList.add(user1);
//		User user2 = User.builder().name("Promi Paul").email("promi.2002@gmail.com").password("Promi123").role("USER").build();
//		userList.add(user2);
//		userRepo.saveAll(userList);
//	}

}
