package com.learnCoding.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learnCoding.Entity.User;
import com.learnCoding.Repository.UserRepository;
@Service
public class UserServiceImplementation implements UserService 
{
	@Autowired
	UserRepository uRpo;

	@Override
	public User addUser(User u) {
		// TODO Auto-generated method stub
		User user = uRpo.save(u);
		return user;
	}

	@Override
	public User loginUser(String email, String password) {
		// TODO Auto-generated method stub
		
		User findByEmail = (User) uRpo.findByEmail(email);
		if(findByEmail.getPassword().equals(password))
		{
			return findByEmail;
		}else
		{
			return null;
		}
		
	}

	@Override
	public boolean emailExist(String email) 
	{
		// TODO Auto-generated method stub
		boolean b =uRpo.existsByEmail(email);
		return b;
	}


	@Override
	public User setNewPassword(String email, String password) {
		// TODO Auto-generated method stub
		User findByEmail = (User) uRpo.findByEmail(email);
		findByEmail.setPassword(password);
		uRpo.save(findByEmail);
		return findByEmail;
	}

}
