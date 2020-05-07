package com.logic;

import org.springframework.stereotype.Service;

import com.model.TicketBean;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class SmsService {
	private final static String ACCOUNT_SID = "AC80e0ae18800bc3ee793844c118b0a5d8";
	private final static String AUTH_ID = "e550155ba382e722cb7485b6de260736";

	static {
		Twilio.init(ACCOUNT_SID, AUTH_ID);
	}

	public void send() {
		Message.creator(new PhoneNumber("+917200691127"), new PhoneNumber("+18125779566"),
				"Hello Deepika Your Bus has reached gandhipuram next stop is urs\n thank you").create();
	}

	public void createdAccount(String email, String name, String phone) {

		String msg = "Hello " + name + " Your Trace Account Created Succesfully checkout your email " + email
				+ " for confirmation...\n\n!!!Happy Tracing!!!";
		Message.creator(new PhoneNumber(phone), new PhoneNumber("+18125779566"), msg).create();

	}

	public void ticketBooked(String name, int tid, Integer bus_no, String pickup, String drop, String phone) {
		String msg = "             \n" + "\n\nHello " + name + "\n\n Your Ticket Booked Succesfully \n\n"
				+ "Your Ticket id is : " + tid + "\n\nBus Number : " + bus_no + "\n\nFrom : " + pickup + "\n\nTo : "
				+ drop + "\n\nvisit http://192.168.43.36/:8089/viewp?tid=" + tid
				+ " for more details \n\n You will receive sms from our side when bus reaches near your stop \n\nPlease Carry the QR sent to your email while boarding"
				+ "\n\n\n          !!! Happy Tracing !!! ";
		Message.creator(new PhoneNumber(phone), new PhoneNumber("+18125779566"), msg).create();

	}

	public void cancel(String name, String phone, TicketBean obj) {

		String msg = ".\n\n" + "Hello " + name + "\n\nYour Ticket number : " + obj.getTid() + "\n\nFrom : "
				+ obj.getBusfrom() + "\n\nTo : " + obj.getBusto() + "\n\nBooked on : \n" + obj.getDate()
				+ "  has been cancelled succesfully \n\n Your amount will be redirected to your bank account within 5-7 working days\n\n                 !!!Happy Tracing!!!";

		Message.creator(new PhoneNumber(phone), new PhoneNumber("+18125779566"), msg).create();

	}

	public void noti(TicketBean t, String phone, String name, String loc) {
		String msg = ".\n\n Hello " + name + "\n\nYou have booked a ticket for Bus number : " + t.getBus_no()
				+ "\n\nFrom : " + t.getBusfrom() + "\n\nTo : " + t.getBusto() + "\n\n The Bus has reached " + loc
				+ "\n\n          !!!Happy Tracing!!!";
		Message.creator(new PhoneNumber(phone), new PhoneNumber("+18125779566"), msg).create();

	}
	
	public void noti1(TicketBean t, String phone, String name, String loc) {
		String msg = ".\n\n Hello " + name + "\n\nYou have subscribed for Bus number : " + t.getBus_no()
				+ "\n\nFrom : " + t.getBusfrom() + "\n\nTo : " + t.getBusto() + "\n\n The Bus has reached " + loc
				+ "\n\n          !!!Happy Tracing!!!";
		Message.creator(new PhoneNumber(phone), new PhoneNumber("+18125779566"), msg).create();

	}
		

}
