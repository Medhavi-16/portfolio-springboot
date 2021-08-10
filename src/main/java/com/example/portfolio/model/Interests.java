package com.example.portfolio.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Interests {

	@ManyToMany
	private List<Users> user;

	@Id
	private Long id;

	private String interest;

	public Interests() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	@Override
	public String toString() {
		return "Interests{" +
				"id=" + id +
				", interest='" + interest + '\'' +
				'}';
	}

	public List<Users> getUser() {
		return user;
	}

	public void setUser(List<Users> user) {
		this.user = user;
	}

	public Interests(List<Users> user, Long id, String interest) {
		this.user = user;
		this.id = id;
		this.interest = interest;
	}
}
