package com.example.portfolio.service;

import java.util.List;

import com.example.portfolio.model.Interests;
import com.example.portfolio.model.Users;

public interface InterestsService {

	Interests addInterest(String interest);

	List<Interests> addUserToInterest(List<String> interests, Users user);

	int getCountOfUsersForAnInterest(String interest);

	List<Interests> getInterestsForUser(String username);

}
