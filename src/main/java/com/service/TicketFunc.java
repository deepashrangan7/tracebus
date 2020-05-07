package com.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logic.SmsService;
import com.model.TicketBean;

@Service
public class TicketFunc {
	@Autowired
	private TicketDao ticketDao;
	@Autowired
	private MailFunction mailFunction;

	@Autowired
	private UserDao userDao;
	@Autowired
	private SmsService sms;

	public List<TicketBean> filter(String type, String user) {
		List<TicketBean> obj = new ArrayList<>();
		if (type.equals("all"))
			obj = ticketDao.findByUid(user);
		else if (type.equals("yes")) {
			obj = ticketDao.findByUidActive(user);
		} else {
			obj = ticketDao.findByUidNotActive(user);
		}
		return obj;
	}

	public TicketBean particular(Integer tid, String user) {

		TicketBean obj = ticketDao.findById(tid).get();
		return obj;
	}

	@Transactional
	public void cancel(Integer tid, String user, String name) {
		TicketBean obj = ticketDao.findById(tid).get();
		obj.setActive("no");
		ticketDao.save(obj);
		mailFunction.cancel(user, name);
		sms.cancel(name,userDao.findById(obj.getUid()).get().getPhone(),obj);

	}

}