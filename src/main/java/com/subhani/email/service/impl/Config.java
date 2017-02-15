package com.subhani.email.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.subhani.email.pojo.Person;

@Configuration
@PropertySource("classpath:emailServer.properties")
@Component
public class Config {
	@Autowired
    Environment env;
	
	@Bean
    public Person person() {
        Person person= new Person();
        person.setName(env.getProperty("prop.name"));
        person.setAge(Integer.parseInt(env.getProperty("prop.age"))); 
        return person;
    }
}
