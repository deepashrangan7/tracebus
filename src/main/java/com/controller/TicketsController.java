package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.logic.BusLogic;
import com.logic.Notification;
import com.logic.TicketLogic;
import com.model.FareBean;
import com.model.FilterBean;
import com.model.TicketBean;
import com.service.TicketFunc;

@Controller
public class TicketsController {

	@Autowired
	private BusLogic busLogic;
	@Autowired
	private TicketLogic ticketLogic;
	@Autowired
	private TicketFunc ticketFunc;

	@Autowired
	private Notification noti;
	@GetMapping("/booktickets")
	public String bookTickets(Integer bus_no, Double fare, String pickup, String drop, Model m) {

		if (bus_no == null) {

			return "redirect:calculatefare";
		} else if (fare == null) {
			List<FareBean> obj = busLogic.calucateFare(pickup, drop);
			for (FareBean f : obj) {
				if (f.getBus_no() == bus_no) {
					fare = f.getFare();
				}
			}
		} else {
		}
		m.addAttribute("pickup", pickup);
		m.addAttribute("drop", drop);
		m.addAttribute("fare", fare);
		m.addAttribute("bus_no", bus_no);
		return "bookticket";
	}// method

	@PostMapping("/booked")
	public String booked(Integer bus_no, Double fare, String pickup, String drop, Integer noofticket, Model m,
			HttpSession session) {
		String user = (String) session.getAttribute("user");
		String name = (String) session.getAttribute("name");
		int tid = ticketLogic.bookTicket(bus_no, fare, pickup, drop, noofticket, user, name);
	
		m.addAttribute("bus_no", bus_no);
		m.addAttribute("pickup", pickup);
		m.addAttribute("drop", drop);
		m.addAttribute("total", (fare * noofticket));
		m.addAttribute("noofticket", noofticket);
		m.addAttribute("tid", tid);

		return "booked";
	}

	@RequestMapping("/viewtickets")
	public String viewTickets(@ModelAttribute("filt") FilterBean fb, Model m, HttpSession session) {
		if (fb.getFilter() == null)
			fb.setFilter("yes");
		String user = (String) session.getAttribute("user");
		List<TicketBean> obj = ticketFunc.filter(fb.getFilter(), user);
		m.addAttribute("tickets", obj);
		return "viewtickets";
	}

	@RequestMapping("/viewp")
	public String viewP(Integer tid, HttpSession session, Model m) {
		String user = (String) session.getAttribute("user");

		TicketBean obj = ticketFunc.particular(tid, user);
		m.addAttribute("tick", obj);

		return "particularticket";
	}

	@RequestMapping("/cancel")
	public String cancel(Integer tid, HttpSession session, Model m) {
		String user = (String) session.getAttribute("user");
		String name = (String) session.getAttribute("name");
		ticketFunc.cancel(tid, user, name);
		m.addAttribute("can", 1);

		m.addAttribute("notic", noti.getNotification((String) session.getAttribute("user")));
		return "userhome";
	}
}// class
