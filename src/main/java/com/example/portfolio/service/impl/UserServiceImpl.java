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

	@Autowired
	private EntityManager entityManager;

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
	public Projects addProject(String uname, Projects project) {
		Users user = dao.getUsersByUsername(uname);
		user.addProject(project);
		return user.getRecentProject();
	}

	//TODO
	@Override
	public List<Projects> getProjects(Map<String, String> params) {
		return null;
	}

	@Override
	public List<Projects> getProjects(String uname) {
		return dao.getUsersByUsername(uname).getProjects();
	}
}
