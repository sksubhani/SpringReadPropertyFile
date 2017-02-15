package com.subhani.email.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.subhani.email.service.EmailService;
import com.subhani.email.service.impl.EmailServiceImpl;

@Controller
public class EmailController {
	
	// IMPORTANT: To populate the Environemnt or @Value fields in other classes, it is important to Autowire the 
	// respective class here. Eg: EmailService
	// DO NOT INSTANTIATE using EmailService service = new EmailServiceImpl(); 
	
	@Autowired
	private EmailService service;
	
	private static final Logger logger = LoggerFactory.getLogger(EmailController.class);
	
	public EmailController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome() {

		logger.info("Received request for welcome page.");
		
		
		try {
			service.sendEmail("Hello");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "home";
	}

}
