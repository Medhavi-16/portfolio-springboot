package com.example.portfolio.service;

import java.util.List;
import java.util.Map;

import com.example.portfolio.model.Profile;
import com.example.portfolio.model.Projects;
import com.example.portfolio.model.Users;

public interface UserService {

	public String createUser(Users user);

	public Profile addProfile(String uname, Profile profile);

	public Users getUserByUsername(String username);

}
