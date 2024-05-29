package com.cg.mtba.service;

import java.util.List;

import com.cg.mtba.exception.UserException;
import com.cg.mtba.model.User;

public interface IUserService {

	public User addNewUser(User user) throws UserException;
	
	public User signIn(int userId,String password) throws UserException;
	
	public User signOut(User user) throws UserException;
	
	public List<User> viewUserList() throws UserException;
	
}