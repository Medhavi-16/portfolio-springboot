package com.example.portfolio.service;

import java.util.List;
import java.util.Map;

import com.example.portfolio.model.Projects;

public interface ProjectsService {

	public List<Projects> getProjects();

	public Projects getProject(String id);

	public Projects addProject(Projects project, String username);

	public Projects updateProject(Projects project);

	public void deleteProject(String id);

	public List<Projects> getProjectsByParams(Map<String, String> params);

}
