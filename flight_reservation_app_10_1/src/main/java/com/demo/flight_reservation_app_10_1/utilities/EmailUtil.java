package com.demo.flight_reservation_app_10_1.utilities;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtil {
	
	@Autowired
	private JavaMailSender sender;
	
	
	public void sendItinerary(String toAddress ,String filePath) {
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper =null;
		System.out.println(toAddress);
		System.out.println(filePath);
		try {
			mimeMessageHelper = new MimeMessageHelper(message, true);
			mimeMessageHelper.setTo(toAddress);
			mimeMessageHelper.setSubject("Itinerary");
			mimeMessageHelper.setText("Itinerary of flight booking");
			mimeMessageHelper.addAttachment("ItineraryFile", new File(filePath));
			sender.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	

}
