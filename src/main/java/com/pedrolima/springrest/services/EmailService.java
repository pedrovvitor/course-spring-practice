package com.pedrolima.springrest.services;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;

import com.pedrolima.springrest.entities.Customer;
import com.pedrolima.springrest.entities.Order;

public interface EmailService {

	void sendOrderConfirmationEmail(Order obj);
	
	void sendEmail(SimpleMailMessage msg);
	
	void sendOrderConfirmationHtmlEmail(Order obj);
	
	void sendHtmlEmail(MimeMessage msg);

	void sendNewPasswordEmail(Customer customer, String newPass);
}
