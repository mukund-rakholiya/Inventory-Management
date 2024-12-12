package com.mohitsabhadiya123.InventoryManagementSystem.Config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "twilio.whatsapp")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TwilioWhatsapp {
    private String trialNumber;

    @Override
    public String toString() {
        return "ConfigTwilioWhatsapp{" +
                "trialNumber='" + trialNumber + '\'' +
                '}';
    }
}
