package com.example.portfolio.dao;

import java.util.Collection;
import java.util.List;

import com.example.portfolio.model.SocialMedia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocialMediaDao extends JpaRepository<SocialMedia, String> {


}
