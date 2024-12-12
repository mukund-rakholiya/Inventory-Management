package com.mohitsabhadiya123.InventoryManagementSystem.Service;


import com.mohitsabhadiya123.InventoryManagementSystem.Config.TwilioSMS;
import com.mohitsabhadiya123.InventoryManagementSystem.Config.TwilioWhatsapp;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServices {
    @Autowired
    private TwilioWhatsapp twilioWhatsapp;

    @Autowired
    private TwilioSMS twilioSMS;

    public void sendWhatsapp(String number, String message){
        Message.creator(new PhoneNumber("whatsapp:+91"+number),new PhoneNumber(twilioWhatsapp.getTrialNumber()),message).create();
    }

    public void sendSMS(String phoneNumber, String message){
        Message.creator(new PhoneNumber("+91"+phoneNumber),new PhoneNumber(twilioSMS.getTrialNumber()),message).create();
    }

}
