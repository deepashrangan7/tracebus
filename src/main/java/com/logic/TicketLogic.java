package com.logic;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Service;

import com.model.TicketBean;
import com.service.MailFunction;
import com.service.TicketDao;

@Service
public class TicketLogic {

	@Autowired
	private TicketDao ticketDao;
	@Autowired
	private QRGenerator qr;
	@Autowired
	private MailFunction mailFunction;

	@Transactional
	public int bookTicket(Integer bus_no, Double fare, String pickup, String drop, Integer noofticket, String user,
			String name) {
		Date d = new Date();
		TicketBean tb = new TicketBean();
		tb.setActive("yes");
		tb.setBus_no(bus_no);
		tb.setBusfrom(pickup);
		tb.setBusto(drop);
		tb.setCost(fare*noofticket);
		tb.setDate(d);
		tb.setCount(noofticket);
		tb.setUid(user);
		ticketDao.save(tb);
		qr.genrateQRTicket(tb.getTid(), name);
		mailFunction.ticketBooked(user, tb.getTid(), name);
		return tb.getTid();
	}

	public void setNotActive(int id) {
		TicketBean obj = ticketDao.findById(id).get();
		obj.setActive("no");
		ticketDao.save(obj);
	}

	public TicketBean findTicket(Integer tid) {
		return ticketDao.findById(tid).get();
	}
}
