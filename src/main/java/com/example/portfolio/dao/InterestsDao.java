package com.example.portfolio.dao;

import com.example.portfolio.dao.customDao.InterestsCustomDao;
import com.example.portfolio.model.Interests;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterestsDao extends JpaRepository<Interests, String>, InterestsCustomDao {

	Interests findByInterestIgnoreCase(String interest);

}
