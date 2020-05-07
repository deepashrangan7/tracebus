package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.logic.BusService;
import com.logic.Notification;
import com.model.Notify;
import com.service.AdminFunc;
import com.service.NotifyDao;

@Controller
public class NotifyController {
	@Autowired
	private Notification noti;
	@Autowired
	private NotifyDao notifyDao;
	@Autowired
	private AdminFunc adminFunc;
	@Autowired
	private BusService busService;

	@RequestMapping("/changeB")
	public String changeBusLoc(String stop) {
		adminFunc.changeLocation(stop);
		return "empty";
	}

	@GetMapping("/reset")
	public String reset() {

		return "redirect:ad";
	}

	@GetMapping("/notify")
	public String notifi(Notify n, HttpSession session, Model m) {
		String email = (String) session.getAttribute("user");
		n.setEmail(email);
		if (noti.isUnique(n)) {
			notifyDao.save(n);

			m.addAttribute("notifi",
					"You will be notified when bus number : " + n.getBus_no() + " reaches near your stop");
		} else {
			m.addAttribute("notifi", "Already You subscribed for notification you will be notified when bus number : "
					+ n.getBus_no() + " reaches near your stop");

		}
		m.addAttribute("notic", noti.getNotification((String) session.getAttribute("user")));

		return "userhome";
	}

	@ModelAttribute("allstop")
	public List<String> getAllStop() {
		List<String> obj = busService.allBusStop();
		return obj;

	}
}
