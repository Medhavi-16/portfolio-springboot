package com.example.portfolio.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Interests {

	@ManyToMany
	@JoinTable(
			name = "users_interests",
			joinColumns = @JoinColumn(name = "interest"),
			inverseJoinColumns = @JoinColumn(name = "username"))
	private Set<Users> users;

	@Id
	private String interest;

	public Interests() {
		super();
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
				", interest='" + interest + '\'' +
				'}';
	}

	public Set<Users> getUsers() {
		return users;
	}

	public void setUsers(Set<Users> user) {
		this.users = user;
	}

	public Interests(String interestName) {
		this.users = new HashSet<>();
		this.interest = interestName;
	}

	public void addUser(Users user) {
		this.users.add(user);
	}
}
