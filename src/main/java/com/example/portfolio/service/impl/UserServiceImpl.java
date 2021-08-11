package com.example.portfolio.service.impl;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Map;

import com.example.portfolio.dao.UsersDao;
import com.example.portfolio.model.Profile;
import com.example.portfolio.model.Projects;
import com.example.portfolio.model.Users;
import com.example.portfolio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UsersDao dao;

	@Override
	public String createUser(Users user) {
		dao.save(user);
		return user.getUsername();
	}

	@Override
	public Profile addProfile(String uname, Profile profile) {
		Users user = dao.getUsersByUsername(uname);
		user.addProfile(profile);
		return user.getProfile();
	}


	@Override
	public Users getUserByUsername(String username) {
		return dao.getUsersByUsername(username);
	}
}
