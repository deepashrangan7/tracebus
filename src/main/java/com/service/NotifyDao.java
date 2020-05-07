package com.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.model.Notify;

@Repository
public interface NotifyDao extends JpaRepository<Notify, Integer> {

	@Query("select s from Notify s where (s.bus_no=:n and s.pickup=:f and s.droping=:d and s.email=:e and s.isNotified=:o)")
	public Notify findByAll(Integer n, String f, String d, String e, String o);

	@Query("select s from Notify s where s.email=:e and s.isNotified='no'")
	public List<Notify> findByEmail(String e);
	
	@Query("select s from Notify s where s.bus_no=:e and s.isNotified='no'")
	public List<Notify> findByBus(Integer e);
	
}
