package com.broadway.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.broadway.springproject.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUsernameAndPassword(String un,String pw);


}
