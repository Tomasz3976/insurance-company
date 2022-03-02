package com.example.insurancecompany.controller;

import com.example.insurancecompany.dto.UserInDto;
import com.example.insurancecompany.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RegistrationController {

        private final RegistrationService registrationService;

        @PostMapping("/registration")
        public String registerUser(@RequestBody UserInDto userInDto) {
                return registrationService.registerUser(userInDto);
        }

        @GetMapping("/registration/confirm")
        public String confirm(@RequestParam String token) {
                return registrationService.confirmToken(token);
        }

}
