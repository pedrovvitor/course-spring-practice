package com.pedrolima.springrest.services;

import org.springframework.mail.SimpleMailMessage;

import com.pedrolima.springrest.entities.Order;

public interface EmailService {

	void sendOrderConfirmationEmail(Order obj);
	
	void sendEmail(SimpleMailMessage msg);
}
