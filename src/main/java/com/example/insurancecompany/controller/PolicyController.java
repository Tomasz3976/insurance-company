package com.example.insurancecompany.controller;

import com.example.insurancecompany.service.PolicyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
public class PolicyController {

        private final PolicyService policyService;

        @GetMapping("/policies/generate")
        public void createPolicy(HttpServletResponse response, Long insuranceId) {
                policyService.createPolicy(response, insuranceId);
        }

}
