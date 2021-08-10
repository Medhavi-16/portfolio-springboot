package com.example.portfolio.dao;

import com.example.portfolio.model.Profile;
import com.example.portfolio.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsersDao extends JpaRepository<Users, String> {

	Users getUsersByUsername(String uname);



}
