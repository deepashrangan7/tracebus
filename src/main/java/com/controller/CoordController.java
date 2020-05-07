package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.MapService;

@Controller
public class CoordController {
	@Autowired
	private MapService map;

	@RequestMapping("/addco")
	public void addC() {
		map.addCor();
	}
}
