package com.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.model.BusBean;

@Repository
public interface BusDao extends JpaRepository<BusBean, Integer> {

	@Query("select s from BusBean s where (s.stop1=?1 or s.stop2=?1 or s.stop3=?1 or s.stop4=?1 or s.stop5=?1)and(s.stop1=?2 or s.stop2=?2 or s.stop3=?2 or s.stop4=?2 or s.stop5=?2)")
	public List<BusBean> KnowYourBus(String n1, String n2);
//public List<BusBean> findByStop1OrStop2OrStop3OrStop4OrStop5(String stop1);
//		public List<BusBean> findByStop1orStop2orStop3orStop4orStop5(String name);

	
}
