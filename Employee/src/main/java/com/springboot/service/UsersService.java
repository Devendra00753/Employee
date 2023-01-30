package com.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.springboot.Repository.UsersRepository;
import com.springboot.model.Users_;

@Service
public class UsersService {
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private UsersRepository usersRepository;
	public Users_  addUser(Users_ users)  {
		users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
		return usersRepository.save(users);
	}
}
