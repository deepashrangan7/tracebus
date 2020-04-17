package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.logic.BusLogic;
import com.logic.BusService;
import com.model.BusSpecificBean;
import com.model.LocateBean;
import com.model.SearchBean;

@Controller
public class BusController {

	@Autowired
	private BusService busService;
	@Autowired
	private BusLogic busLogic;
	@RequestMapping("/locate")
	public String locate(@ModelAttribute("locate")LocateBean lb,Model m) {
		if(lb==null||lb.getBus_no()==null||lb.getBus_no()==0)
		{
			m.addAttribute("loc",null);
			
		}else {
			m.addAttribute("loc", 1);
			BusSpecificBean obj=busService.findSpecific(lb.getBus_no());
			m.addAttribute("detail",obj);
		}
			return "locate";
	}
	
	@RequestMapping("/locatebusses")
	public String locate(@ModelAttribute("searchbean") SearchBean sb, BindingResult br, Model m) {
//		System.out.println(sb.getBoarding()+" came as  "+sb.getDestination());
		
		if (sb.getBoarding() == null || sb.getDestination() == null || sb.getBoarding().equals("")
				|| sb.getDestination().equals("")) {
			m.addAttribute("loc", null);
			m.addAttribute("err", null);

		} else if (sb.getBoarding().equals(sb.getDestination())) {
			m.addAttribute("loc", null);

			m.addAttribute("err", "Choose different boarding point or desitantion point");
//			System.out.println(sb.getBoarding()+" same as "+sb.getDestination());
			return "locatebusses";
		}

		else {
			m.addAttribute("loc", 1);

			m.addAttribute("locbus", busService.knowMyBusses(sb));

		}

		return "locatebusses";
	}

	@GetMapping("/userhome")
	public String userHome() {

		return "userhome";
	}

	@ModelAttribute("allstop")
	public List<String> getAllStop() {
		List<String> obj = busService.allBusStop();
		return obj;

	}
	@ModelAttribute("particularbus")
	public List<Integer> getAllBus(){
		List<Integer> obj=busService.allBus();
		return obj;
	}
@RequestMapping("/calculatefare")
	public String calculateFare(@ModelAttribute("searchbean") SearchBean sb, BindingResult br, Model m) {
	if (sb.getBoarding() == null || sb.getDestination() == null || sb.getBoarding().equals("")
			|| sb.getDestination().equals("")) {
		m.addAttribute("loc", null);
		m.addAttribute("err", null);
		return "calculatefare";
	} else if (sb.getBoarding().equals(sb.getDestination())) {
		m.addAttribute("loc", null);

		m.addAttribute("err", "Choose different boarding point or desitantion point");
//		System.out.println(sb.getBoarding()+" same as "+sb.getDestination());
		return "calculatefare";
	}else {
		m.addAttribute("loc", 1);
		m.addAttribute("locbus", busLogic.calucateFare(sb.getBoarding().trim(), sb.getDestination().trim()));

	}
	return "calculatefare";
	}
}
