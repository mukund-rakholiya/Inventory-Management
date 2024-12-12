package com.mohitsabhadiya123.InventoryManagementSystem;

import com.mohitsabhadiya123.InventoryManagementSystem.Config.TwilioSMS;
import com.twilio.Twilio;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InventoryManagementSystemApplication {
	@Autowired
	private TwilioSMS twilioSMS;

	public static void main(String[] args) {
		SpringApplication.run(InventoryManagementSystemApplication.class, args);
	}

	@PostConstruct
	public void init(){
		Twilio.init(twilioSMS.getAccountSid(),twilioSMS.getAuthId());
	}
}
