package com.example.portfolio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

@Entity
public class Profile {

	@Id
	@GeneratedValue
	private Long id;


	private String name;
	private String description;

	public Profile(String name, String description, byte[] profileImg) {
		this.name = name;
		this.description = description;
		this.profileImg = profileImg;
	}

	@Lob
	private byte[] profileImg;

	public Profile() {
		super();
	}

	@Override
	public String toString() {
		return "Profile{" +
				"name='" + name + '\'' +
				", description='" + description + '\'' +
				'}';
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getProfileImg() {
		return profileImg;
	}

	public void setProfileImg(byte[] profileImg) {
		this.profileImg = profileImg;
	}

}
