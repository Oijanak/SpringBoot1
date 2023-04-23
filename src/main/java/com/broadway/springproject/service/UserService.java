package com.broadway.springproject.service;

import com.broadway.springproject.model.User;

public interface UserService {
	void userSignup(User user);
	User userLogin(String un,String pw);

}
