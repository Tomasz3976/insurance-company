package com.example.insurancecompany.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailService {

        private final JavaMailSender mailSender;

        @Async
        public void send(String to, String email) {
                try {
                        MimeMessage mimeMessage = mailSender.createMimeMessage();
                        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
                        helper.setText(email, true);
                        helper.setTo(to);
                        helper.setSubject("Confirm your email");
                        helper.setFrom("insurancecompany@gmail.com");
                        mailSender.send(mimeMessage);
                } catch (MessagingException e) {
                        log.error("Failed to send email", e);
                        throw new IllegalStateException("Failed To Send Email!");
                }
        }

}
