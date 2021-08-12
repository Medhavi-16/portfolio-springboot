package com.example.portfolio.dao.customDao;

import java.util.List;
import java.util.Map;

import com.example.portfolio.model.Projects;

public interface ProjectsCustomDao {
	List<Projects> findProjectsByParam(Map<String, String> params);

}
