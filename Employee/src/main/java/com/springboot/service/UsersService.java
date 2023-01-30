package com.springboot.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.Repository.UsersRepository;
import com.springboot.model.Users_;

@Service
public class UsersService {
	
	@Autowired
	private UsersRepository usersRepository;

	public Users_  addUser(Users_ users)  {
		String salt=BCrypt.gensalt(10);
		String hashedPassword=BCrypt.hashpw(users.getPassword(), salt);
		System.out.println(salt);
		System.out.println(hashedPassword);
		// users.setPassword(hashedPassword);
		return usersRepository.save(users);
	}

}
