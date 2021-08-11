package com.example.portfolio.service.impl;

import javax.persistence.Entity;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.portfolio.dao.ProjectsDao;
import com.example.portfolio.dao.UsersDao;
import com.example.portfolio.model.Projects;
import com.example.portfolio.model.Users;
import com.example.portfolio.service.ProjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectsServiceImpl implements ProjectsService {

	@Autowired
	private ProjectsDao dao;

	@Autowired
	private UsersDao usersDao;


	@Override
	public List<Projects> getProjects() {
		return dao.findAll();
	}

	@Override
	public Projects getProject(String id) {
		return dao.findById(id).orElse(null);
	}

	@Override
	public Projects addProject(Projects project, String username) {
		Optional<Users> user = Optional.of(usersDao.getUsersByUsername(username));
		user.ifPresent(project::setUser);
		dao.save(project);
		return project;
	}

	@Override
	public Projects updateProject(Projects project) {
		dao.save(project);
		return project;
	}

	@Override
	public void deleteProject(String id) {
		dao.deleteById(id);
		return;
	}

	@Override
	public List<Projects> getProjectsByParams(Map<String, String> params) {
		return dao.findProjectsByParam(params);
	}
}
