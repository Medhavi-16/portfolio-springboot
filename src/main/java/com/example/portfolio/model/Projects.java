package com.example.portfolio.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
public class Projects {


	@Id
	private String id;

	private String name;

	private String description;

	private String projectLink;

	@ManyToOne
	@JoinColumn(name = "username")
	private Users user;


	private String coverImageUrl;

	@Temporal(TemporalType.DATE)
	private Date dateStart;

	@Temporal(TemporalType.DATE)
	private Date dateEnd;

	private String genre;

	public Projects(String id, String name, String description, String projectLink, String coverImageUrl, Date dateStart,
			Date dateEnd, String genre, Users user) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.projectLink = projectLink;
		this.coverImageUrl = coverImageUrl;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.genre = genre;
		this.user = user;
	}

	public Projects() {
		super();
	}

	@Override
	public String toString() {
		return "Projects{" +
				"id=" + id +
				", name=" + name + '\'' +
				", description='" + description + '\'' +
				", projectLink='" + projectLink + '\'' +
				", coverImageUrl='" + coverImageUrl + '\'' +
				", dateStart=" + dateStart +
				", dateEnd=" + dateEnd + '\'' +
				", category=" + genre +
				'}';
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProjectLink() {
		return projectLink;
	}

	public void setProjectLink(String projectLink) {
		this.projectLink = projectLink;
	}

	public String getCoverImageUrl() {
		return coverImageUrl;
	}

	public void setCoverImageUrl(String coverImageUrl) {
		this.coverImageUrl = coverImageUrl;
	}

	public Date getDateStart() {
		return dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public Date getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
}
