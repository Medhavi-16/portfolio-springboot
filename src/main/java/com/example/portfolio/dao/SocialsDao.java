package com.example.portfolio.dao;

import java.util.List;

import com.example.portfolio.model.Socials;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocialsDao extends JpaRepository<Socials, String> {

	List<SocialsDao> findBySocialName(String socialname);



}
