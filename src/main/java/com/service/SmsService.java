package com.service;


import org.springframework.stereotype.Service;
import com.twilio.Twilio;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
@Service
public class SmsService {

	private final String ACCOUNT_SID="AC80e0ae18800bc3ee793844c118b0a5d8";
	private final String AUTH_TOKEN="d5e3505596584fede9b4cfb6125abf71";
	
	public void sendSms(String num) {
		
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
	Message.creator(new PhoneNumber("+917010809760"), new PhoneNumber("+18125779566"), "Hi Your Ticket Booked SUccessFully").create();

	}
}
