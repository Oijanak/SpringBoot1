package com.broadway.springproject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.broadway.springproject.model.User;
import com.broadway.springproject.repository.UserRepository;
import com.broadway.springproject.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository urpo;
	@Override
	public void userSignup(User user) {
		urpo.save(user);
		
	}

	@Override
	public User userLogin(String un, String pw) {
		
		return urpo.findByUsernameAndPassword(un, pw);
	}

}
