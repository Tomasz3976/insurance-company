package com.example.insurancecompany.controller;

import com.example.insurancecompany.service.PolicyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/policies")
public class PolicyController {

        private final PolicyService policyService;

        @GetMapping("/generate")
        public void createPolicy(HttpServletResponse response, @RequestParam Long insuranceId) {
                policyService.createPolicy(response, insuranceId);
        }

}
