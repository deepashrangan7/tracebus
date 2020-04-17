package com.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.model.TicketBean;

@Repository
public interface TicketDao extends JpaRepository<TicketBean, Integer> {

	@Query("select s from TicketBean s where s.uid=:uid   ORDER BY s.date DESC")
	public List<TicketBean> findByUid(String uid);

	@Query("select s from TicketBean s where s.uid=:uid and s.active='yes'   ORDER BY s.date DESC")
	public List<TicketBean> findByUidActive(String uid);

	@Query("select s from TicketBean s where s.uid=:uid and s.active='no'   ORDER BY s.date DESC")
	public List<TicketBean> findByUidNotActive(String uid);
}
