package com.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.ProfileImage;

@Repository
public interface ProfileDao extends JpaRepository<ProfileImage, String>{

}
