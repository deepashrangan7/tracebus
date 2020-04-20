package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.logic.BusService;
import com.logic.TicketLogic;
import com.model.BusBean;
import com.model.LocateBean;
import com.model.TicketBean;
import com.service.BusDao;

@Controller
public class AdminController {

	@Autowired
	private TicketLogic ticketLogic;
	@Autowired
	private BusService busService;
	@Autowired
	private BusDao busDao;

	@RequestMapping("/ad")
	public String adminHome(Model m) {
		m.addAttribute("noti", 0);
		return "adminhome";

	}

	
	
	@GetMapping("/tickets")
	public String processTicket(Integer tid, Model m) {
		TicketBean tb = ticketLogic.findTicket(tid);
		m.addAttribute("tick", tb);
		m.addAttribute("err", "");
		return "ticketscanning";
	}

	@PostMapping("/boarded")
	public String processed(String pass, Integer tid, Model m) {
		if (pass.equals("1234")) {
			ticketLogic.setNotActive(tid);
			m.addAttribute("noti", 1);

		} else {
			TicketBean tb = ticketLogic.findTicket(tid);
			m.addAttribute("tick", tb);
			m.addAttribute("err", "Incorrect Password");
			return "ticketscanning";

		}
		return "adminhome";
	}

	@ModelAttribute("particularbus")
	public List<Integer> getAllBus() {
		List<Integer> obj = busService.allBus();
		return obj;
	}

	@RequestMapping("/changeloc")
	public String changeLoc(@ModelAttribute("changel") LocateBean lb, Model m) {
		if (lb.getBus_no() != null && lb.getBus_no() != null) {
			BusBean b = busDao.findById(lb.getBus_no()).get();
			String next = busService.nextLoc(lb.getBus_no(), b);
			m.addAttribute("bb", b);
			m.addAttribute("nextloc", next);
		}
		return "changeloc";
	}

	@RequestMapping("/change")
	public String change(Integer bus_no) {
		busService.changeLoc(bus_no);
		return "adminhome";
	}

}
