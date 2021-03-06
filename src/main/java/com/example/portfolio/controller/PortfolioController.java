package com.example.portfolio.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.portfolio.Constants;
import com.example.portfolio.model.Interests;
import com.example.portfolio.model.Profile;
import com.example.portfolio.model.Projects;
import com.example.portfolio.model.SocialMedia;
import com.example.portfolio.model.Socials;
import com.example.portfolio.model.Users;
import com.example.portfolio.service.InterestsService;
import com.example.portfolio.service.ProfileService;
import com.example.portfolio.service.ProjectsService;
import com.example.portfolio.service.SocialMediaService;
import com.example.portfolio.service.SocialsService;
import com.example.portfolio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PortfolioController {

	@Autowired
	private SocialsService socialsService;

	@Autowired
	private ProfileService profileService;

	@Autowired
	private ProjectsService projectsService;

	@Autowired
	private SocialMediaService socialMediaService;

	@Autowired
	private UserService userService;

	@Autowired
	private InterestsService interestsService;


	/**
	 * Get all social media handles
	 * @return list of all social handle
	 */
	@GetMapping("/socials")
	public List<Socials> getSocials() {
		return this.socialsService.getSocials();
	}

	/**
	 * @param socialId Name for the desired social media
	 * @return handle details for the required social media
	 */
	@GetMapping("/socials/{socialId}")
	public Socials getSocials(@PathVariable String socialId) {
		return this.socialsService.getSocials(socialId);
	}

	/**
	 * can also use , (path = "/socials", consumes = "application/json") in mapping
	 * @param socials new social media handle
	 * @return social media handle that is created
	 */
	@PostMapping(path = "/socials")
	public Socials addSocials(@RequestBody Socials socials) {
		return this.socialsService.addSocials(socials);
	}

	/**
	 *
	 * @param socials update to social handle
	 * @return updated social handle
	 */
	@PutMapping(path = "/socials")
	public Socials updateSocials(@RequestBody Socials socials) {
		return this.socialsService.updateSocials(socials);
	}

	/**
	 *
	 * @param socialId key to social handle to be deleted
	 * @return deleted social handle
	 */
	@DeleteMapping("/socials/{socialId}")
	public ResponseEntity<HttpStatus> deleteSocials(@PathVariable String socialId) {
		try {
			this.socialsService.deleteSocials(socialId);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 *
	 * @param username Optional param to get projects by user
	 * @param genre Optional param to get projects by genre
	 *              Currently supporting fetching by only one param
	 * @return
	 */
	@GetMapping("/projects")
	public List<Projects> getProjects(@RequestParam(value = "_username", required = false) String username, @RequestParam(value = "_genre", required = false) String genre) {

		Map<String, String> params = new HashMap<>();
		params.put(Constants.USERNAME, username);
		params.put(Constants.GENRE, genre);
		return projectsService.getProjectsByParams(params);
	}

	@GetMapping("/projects/{projectId}")
	public Projects getProject(@PathVariable String projectId) {
		return this.projectsService.getProject(projectId);
	}


	@PostMapping("/projects")
	public Projects addProject(@RequestParam(value = "_username") String username, @RequestBody Projects project) {
		return projectsService.addProject(project, username);
	}

	@PutMapping("/projects")
	public Projects updateProject(@RequestBody Projects project) {
		return  this.projectsService.updateProject(project);
	}

	@DeleteMapping("/projects/{projectId}")
	public ResponseEntity<HttpStatus> deleteProject(@PathVariable String projectId) {
		try {
			this.projectsService.deleteProject(projectId);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	@PostMapping("/about")
	public Profile addProfile(@RequestParam(value = "_username") String username, @RequestBody Profile profile) {
		 userService.addProfile(username, profile);
		 return profileService.addProfile(profile);
	}

	@PutMapping("/about")
	public Profile updateProfile(@RequestBody Profile profile) {
		return profileService.updateProfile(profile);
	}

	@PutMapping("/about/description={description}")
	public Profile updateDescription(@PathVariable String description) {
		return profileService.updateProfile("description", description);
	}

	@GetMapping("/socialmedia")
	public List<SocialMedia> getSocialMedia()
	{
		return  this.socialMediaService.get();
	}

	@PostMapping("/socialmedia")
	public SocialMedia createSocialMedia(@RequestBody SocialMedia socialMedia) {
		return this.socialMediaService.create(socialMedia);
	}

	@PostMapping("/create/user")
	public String createUser(@RequestBody Users users){
		return userService.createUser(users);
	}

	@PostMapping("/create/interests")
	public String createInterests(@RequestBody String interest) {
		return interestsService.addInterest(interest).getInterest();
	}

	@PostMapping("/interests")
	public List<Interests> addUserInterests(@RequestParam(name = "_username", required = true) String username, @RequestBody List<String> interests) {
//		try {
//
//		}
//		catch (Exception e) {
//			System.out.println(e.getCause());
//			return null;
//		}

		Users user = userService.getUserByUsername(username);
		return interestsService.addUserToInterest(interests,user);
	}

	@GetMapping("/interests/{interestName}/count")
	public int getCountOfUsersForAnInterest(@PathVariable String interestName) {
		return interestsService.getCountOfUsersForAnInterest(interestName);
	}

}
