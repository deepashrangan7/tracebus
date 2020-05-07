package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.logic.QRGenerator;
import com.logic.SmsService;

@Controller
public class UserController {

	@Autowired
	private QRGenerator qr;
	@Autowired
	private SmsService sms;

	@RequestMapping("/changepic")
	public String changePic() {

		return "imageupload";
	}

	@GetMapping("/newsfeed")
	public String newsFeed() {
		return "newsfeed";
	}

	

}
