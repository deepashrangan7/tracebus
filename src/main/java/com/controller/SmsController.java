package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.service.SmsService;

@Controller
public class SmsController {

	@Autowired
	private SmsService sms;
	@GetMapping("/send")
	public String sendSms() {
		
		sms.sendSms("+917010809760");
	return "mainpage";
	}
}
