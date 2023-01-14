package com.email.gmail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyEmailApplication implements CommandLineRunner {
	@Autowired
	EmailService emailService;
	public static void main(String[] args) {
		SpringApplication.run(MyEmailApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		UserInfo userInfo=new UserInfo();
		userInfo.setEmail("vashista123basava@gmail.com");
		userInfo.setName("Vasi");
		userInfo.setUsername("Vashista");
		
		register(userInfo);
	}
	public String register( UserInfo userInfo) throws Exception {
	    emailService.sendEmail(userInfo);
	    return "Email Sent..!";
	}
}
