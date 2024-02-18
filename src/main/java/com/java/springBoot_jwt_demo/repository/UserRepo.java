package com.java.springBoot_jwt_demo.repository;

import com.java.springBoot_jwt_demo.entity.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserCredentials, Integer> {
}
