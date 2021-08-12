package com.example.portfolio.dao.customDao;

import java.util.List;

import com.example.portfolio.model.Interests;
import com.example.portfolio.model.Users;

public interface InterestsCustomDao {

	int getCountOfUsersForAnInterest(String interest);

}
