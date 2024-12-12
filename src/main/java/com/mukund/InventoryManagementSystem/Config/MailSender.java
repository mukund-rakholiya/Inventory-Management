package com.mohitsabhadiya123.InventoryManagementSystem.Config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "spring.mail")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MailSender {
    private String userName;

    @Override
    public String toString() {
        return "ConfigTwilioMail{" +
                "username='" + userName + '\'' +
                '}';
    }
}
