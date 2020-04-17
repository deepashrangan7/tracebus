package com.service;



import java.io.File;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;



@Service
public class MailFunction {

			@Autowired
	    private JavaMailSender javaMailSender;
		
		public void sendEmail(String email,String name) {

	        SimpleMailMessage msg = new SimpleMailMessage();
	        msg.setTo(email);
//	       
	        msg.setSubject("Trace Account Created Succesfully");
	        msg.setText("Hello "+name+"\n			  Welcome to Trace\nNow get through the wastage of time waiting at bus stop\nOpen our portal and get complete details about the busses you need\n                           Thank You\n                   Happy Tracing\nFor any queries you can reply to this mail or contact us at 7010809760!!!! ");

	        javaMailSender.send(msg);

	    }
		
		
		public void ticketBooked(String user,Integer tid,String name) {
			String s=name+""+tid+".png";
			String files="E:\\QR\\"+name+""+tid+".png";
			MimeMessagePreparator preparator = new MimeMessagePreparator() 
		    {
		        public void prepare(MimeMessage mimeMessage) throws Exception 
		        {
		            mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(user));
		            mimeMessage.setFrom(new InternetAddress("deepashdeepika77@gmail.com"));
		            mimeMessage.setSubject("Ticket Booked Successfully");
		            mimeMessage.setText("Here is your ticket please carry while boarding");
		           
		            FileSystemResource file = new FileSystemResource(new File(files));
		            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		            helper.addAttachment(s, file);
//		            helper.addAttachment(MimeUtility.encodeText(""), new ByteArrayResource(IOUtils.toByteArray(inputStream)));
		            helper.setText(" Hey "+name+"\n Here is your ticket please carry while boarding \n Ticket Id : "+tid+"\n Contact 7010809760 for any queries ", true);
		        }
		    };
		     
		    try {
		        javaMailSender.send(preparator);
		    }
		    catch (MailException ex) {
		        // simply log it and go on...
		        System.err.println(ex.getMessage());
		    }
			
		}


		public void cancel(String user, String name) {
	        SimpleMailMessage msg = new SimpleMailMessage();
	        msg.setTo(user);
	       
	        msg.setSubject("Ticket Cancelled Succesfully");
	        msg.setText("Hello "+name+"\n			  Your ticket is cancelled successfully \nThe amount will be refunded to your account within 7 Working days \n                           Thank You\n                          Happy Tracing\nFor any queries you can reply to this mail or contact us at 7010809760!!!! ");

	        javaMailSender.send(msg);

			
		}
}
