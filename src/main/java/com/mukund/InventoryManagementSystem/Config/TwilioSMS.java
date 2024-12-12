package com.mohitsabhadiya123.InventoryManagementSystem.Config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "twilio")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TwilioSMS {

    private String accountSid;

    private String trialNumber;

    private String authId;


    @Override
    public String toString() {
        return "ConfigTwilio{" +
                "accountSid='" + accountSid + '\'' +
                ", trialNumber='" + trialNumber + '\'' +
                ", authId='" + authId + '\'' +
                '}';
    }
}
