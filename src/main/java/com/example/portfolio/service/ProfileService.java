package com.example.portfolio.service;

import com.example.portfolio.model.Profile;

public interface ProfileService {

	public Profile addProfile(Profile profile);

	public Profile updateProfile(Profile profile);

	public Profile updateProfile(String param, String value);

}
