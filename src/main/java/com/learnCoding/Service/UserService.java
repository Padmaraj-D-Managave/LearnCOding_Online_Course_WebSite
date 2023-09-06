package com.learnCoding.Service;

import com.learnCoding.Entity.User;

public interface UserService 
{
	public User addUser(User u);
	public User loginUser(String username,String password);
	public boolean emailExist(String email);
	public User setNewPassword(String email, String password);
}
