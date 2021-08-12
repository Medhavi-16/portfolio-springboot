package com.example.portfolio.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.portfolio.dao.InterestsDao;
import com.example.portfolio.model.Interests;
import com.example.portfolio.model.Users;
import com.example.portfolio.service.InterestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InterestsServiceImpl implements InterestsService {

	@Autowired
	private InterestsDao dao;

	@Override
	public Interests addInterest(String interestName) {
		Optional<Interests> optional = Optional.ofNullable(dao.findByInterestIgnoreCase(interestName));
		if(optional.isEmpty()) {
			dao.save(new Interests(interestName));
		}

		return dao.findByInterestIgnoreCase(interestName);
	}

	@Override
	public List<Interests> addUserToInterest(List<String> interests, Users user) {

		return interests.stream().map(i -> {
			Interests interest = dao.findByInterestIgnoreCase(i);
			interest.addUser(user);
			dao.save(interest);
			return interest;
		}).collect(Collectors.toList());
	}

	@Override
	public int getCountOfUsersForAnInterest(String interest) {
		return dao.getCountOfUsersForAnInterest(interest);
	}

	@Override
	public List<Interests> getInterestsForUser(String username) {
		return null;
	}
}
