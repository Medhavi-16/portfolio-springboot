package com.example.portfolio.dao;

import com.example.portfolio.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProfileDao extends JpaRepository<Profile, String> {

	//Profile getProfileByUser(String user);

}
