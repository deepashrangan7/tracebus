package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.BusBean;

@Service
public class AdminFunc {

	@Autowired
	private BusDao busDao;

	public void changeLocation(String stop) {
		BusBean b = busDao.findById(8).get();

		b.setLoc(stop);
		if (stop.equals(b.getStop5()))
			b.setDirection("down");
		else
			b.setDirection("up");
			
		busDao.save(b);
	}

	public void reset() {
		BusBean b = busDao.findById(8).get();
		b.setDirection("up");
		b.setLoc(b.getStop1());
		busDao.save(b);
	}
}
