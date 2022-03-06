package com.example.insurancecompany.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.Properties;

@Configuration
@EnableAsync
public class MailSenderConfiguration {

        @Bean
        public JavaMailSender getJavaMailSender() {
                JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
                mailSender.setHost("smtp.gmail.com");
                mailSender.setPort(587);
                mailSender.setUsername("insurance.company285@gmail.com");
                mailSender.setPassword("Insurance.Company285#");
                Properties props = mailSender.getJavaMailProperties();
                props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
                props.put("mail.transport.protocol", "smtp");
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.starttls.enable", "true");
                props.put("mail.debug", "true");
                return mailSender;
        }

}
