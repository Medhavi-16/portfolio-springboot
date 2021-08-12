package com.example.portfolio.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Users {

	@OneToOne
	private Profile profile;

	@OneToMany
	private List<Socials> socials;

	@Transient
	private Set<Interests> interests;

	@Transient
	private List<Projects> projects;

	private String email;

	@Id
	private String username;

	public Users() {
		super();
	}

	public Users(String email, String username) {
		this.email = email;
		this.username = username;
		profile = null;
		socials = new ArrayList<>();
		interests = new HashSet<>();
		projects = new ArrayList<>();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Users{" +
				", email='" + email + '\'' +
				", username='" + username + '\'' +
				'}';
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}


	public List<Socials> getSocials() {
		return socials;
	}

	public void setSocials(List<Socials> socials) {
		this.socials = socials;
	}

	public Set<Interests> getInterests() {
		return interests;
	}

	public void setInterests(Set<Interests> interests) {
		this.interests = interests;
	}

	public void addProfile(Profile profile) {
		this.profile = profile;
	}

	public void addSocials(Socials socials) {
		this.socials.add(socials);
	}

	public List<Projects> getProjects() {
		return projects;
	}

	public void setProjects(List<Projects> projects) {
		this.projects = projects;
	}
}
