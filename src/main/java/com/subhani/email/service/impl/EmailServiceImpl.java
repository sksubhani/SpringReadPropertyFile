package com.subhani.email.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.subhani.email.pojo.Person;
import com.subhani.email.service.EmailService;


@Configuration
@PropertySource("classpath:emailServer.properties")
@Service
//@ContextConfiguration
public class EmailServiceImpl implements EmailService {

	private static final Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);
	
	@Value("${email.sender.id}")
	private String senderMailId;
	
	@Autowired
    Environment env;
	
	
	public EmailServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	//IMPORTANT: To populate the Environemnt or @Value fields, it is important that the class which instantiates
	// this class (EmailServiceImpl) need to autowire. It should not manually instantiate. Please refer to 
	// "EmailController" for reference.
	
	
	@Bean
    public Person person() {
        Person person= new Person();
        // Reading the property using environment object. Spring 4 preferred way!
        person.setName(env.getProperty("person.name"));
        person.setAge(Integer.parseInt(env.getProperty("person.age")));
        return person;
    }

	public String sendEmail(String data) {
		
		// Reading the property using @PropertySource's @Value annotation
		logger.debug("Sender email id read from properties: "  + senderMailId);
		logger.debug("Sender name read from properties: "  + person().getName());
		
		return "success";
	}

}
