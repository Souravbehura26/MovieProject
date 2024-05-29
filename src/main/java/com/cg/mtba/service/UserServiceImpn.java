package com.cg.mtba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mtba.dao.IUserRepository;
import com.cg.mtba.exception.UserException;
import com.cg.mtba.model.Ticket;
import com.cg.mtba.model.User;

@Service
public class UserServiceImpn implements IUserService{
	
	@Autowired
	IUserRepository userrepo;
	
	@Override
	public User addNewUser(User user) throws UserException{
		if(!userrepo.existsById(user.getUserId())) {
			userrepo.save(user);
			return user;
		}
		return  null;
	}
	
	public User signIn(int userId,String password) throws UserException {
		User u=userrepo.findUser(userId);
		if(u==null)
		{
			return null;
		}
		if(u!=null){
			if(!u.getPassword().equals(password)) {	
				throw new UserException("Wrong Password");
			}
		}
		return u;

	}

	@Override
	public User signOut(User user) throws UserException{
		if(userrepo.existsById(user.getUserId())) {
			return user;
			
		}
		return null;
	}

	@Override
	public List<User> viewUserList() throws UserException {
		List<User> userList = userrepo.findAll();
		if (userList.size() > 0) {
			return userList;
		}
		return null;
	}

	
}
