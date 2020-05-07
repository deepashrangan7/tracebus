package com.logic;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.BusBean;
import com.model.NotificationBean;
import com.model.Notify;
import com.model.TicketBean;
import com.service.BusDao;
import com.service.NotifyDao;
import com.service.TicketDao;

@Service
public class Notification {

	@Autowired
	private TicketDao ticketDao;

	@Autowired
	private BusDao busDao;
	@Autowired
	private NotifyDao notifyDao;

	@Transactional
	public List<NotificationBean> getNotification(String uid) {
		List<NotificationBean> obj = new ArrayList<>();

		List<TicketBean> t1 = ticketDao.findByUidActive(uid);
		for (TicketBean t : t1) {

			if (isTrue(t)) {
				obj.add(new NotificationBean(t.getBus_no(), t.getBusfrom()));
				obj.get(obj.size() - 1).setCurrent(busDao.findById(t.getBus_no()).get().getLoc());
			}

		}

		List<Notify> n1 = notifyDao.findByEmail(uid);

		for (Notify n : n1) {
			TicketBean t = new TicketBean();
			t.setBusfrom(n.getPickup());
			t.setBusto(n.getDroping());
			t.setBus_no(n.getBus_no());
			if (isTrue(t)) {
				obj.add(new NotificationBean(n.getBus_no(), n.getPickup()));
				obj.get(obj.size() - 1).setCurrent(busDao.findById(n.getBus_no()).get().getLoc());

			}
		}
		return obj;

	}

	@Transactional
	public boolean isTrue(TicketBean t) {
		boolean flag = false;
		BusBean b = busDao.findById(t.getBus_no()).get();
		if (b.getDirection().equals("up")) {
			if (b.getLoc().equals(b.getStop1())
					&& (b.getStop2().equals(t.getBusfrom()) || b.getStop1().equals(t.getBusfrom())))
				flag = true;
			else if (b.getLoc().equals(b.getStop2())
					&& (b.getStop3().equals(t.getBusfrom()) || b.getStop2().equals(t.getBusfrom())))
				flag = true;
			else if (b.getLoc().equals(b.getStop3())
					&& (b.getStop4().equals(t.getBusfrom()) || b.getStop3().equals(t.getBusfrom())))
				flag = true;
			else if (b.getLoc().equals(b.getStop4())
					&& (b.getStop5().equals(t.getBusfrom()) || b.getStop4().equals(t.getBusfrom())))
				flag = true;
			else if (b.getLoc().equals(b.getStop5())
					&& (b.getStop4().equals(t.getBusfrom()) || b.getStop5().equals(t.getBusfrom())))
				flag = true;

		} else {

			if (b.getLoc().equals(b.getStop5())
					&& (b.getStop4().equals(t.getBusfrom()) || b.getStop5().equals(t.getBusfrom())))
				flag = true;
			else if (b.getLoc().equals(b.getStop4())
					&& (b.getStop3().equals(t.getBusfrom()) || b.getStop4().equals(t.getBusfrom())))
				flag = true;
			else if (b.getLoc().equals(b.getStop3())
					&& (b.getStop2().equals(t.getBusfrom()) || b.getStop3().equals(t.getBusfrom())))
				flag = true;
			else if (b.getLoc().equals(b.getStop2())
					&& (b.getStop1().equals(t.getBusfrom()) || b.getStop2().equals(t.getBusfrom())))
				flag = true;
			else if (b.getLoc().equals(b.getStop1())
					&& (b.getStop2().equals(t.getBusfrom()) || b.getStop1().equals(t.getBusfrom())))
				flag = true;

		}
		return flag;
	}

	public boolean isUnique(Notify n) {
//		System.out.println(n.getBus_no());
		Notify n1 = notifyDao.findByAll(n.getBus_no(), n.getPickup(), n.getDroping(), n.getEmail(), "no");
		if (n1 == null)
			return true;
		return false;
	}

}
