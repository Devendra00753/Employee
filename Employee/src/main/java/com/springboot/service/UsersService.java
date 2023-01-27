package com.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.Repository.UsersRepository;
import com.springboot.model.Users_;

@Service
public class UsersService {
	
	@Autowired
	private UsersRepository usersRepository;

	public Users_  addUser(Users_ users)  {
		//validations
//		String res=Validater.allvalidations(users);
//		if(res!=null){
//			throw new Exception(res);
//		}
		return usersRepository.save(users);
		// return users;
	}

}
