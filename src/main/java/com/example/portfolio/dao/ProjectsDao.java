package com.example.portfolio.dao;

import java.util.List;

import com.example.portfolio.model.Projects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProjectsDao extends JpaRepository<Projects, String> {

	//@Query("select p from Projects p where p.genre = ?1")
	List<Projects> findAllByGenre(String genre);

}
