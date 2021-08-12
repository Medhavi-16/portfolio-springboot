package com.example.portfolio.service;

import com.example.portfolio.model.Profile;

public interface ProfileService {

	Profile addProfile(Profile profile);

	Profile updateProfile(Profile profile);

	Profile updateProfile(String param, String value);

}
