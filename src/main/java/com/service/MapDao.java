package com.service;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Map;
@Repository
public interface MapDao extends JpaRepository<Map, String>{

}
