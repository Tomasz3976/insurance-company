package com.example.insurancecompany.controller;

import com.example.insurancecompany.details.CarCalculateDetails;
import com.example.insurancecompany.service.CalculationService;
import com.example.insurancecompany.details.HouseCalculateDetails;
import com.example.insurancecompany.details.InsurancePrice;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/calculation")
public class CalculationController {

        private final CalculationService calculationService;

        @GetMapping("/cars")
        public InsurancePrice carInsuranceCalculation(@RequestBody CarCalculateDetails details) {
                return calculationService.carInsuranceCalculation(details);
        }

        @GetMapping("/houses")
        public InsurancePrice houseInsuranceCalculation(@RequestBody HouseCalculateDetails details) {
                return calculationService.houseInsuranceCalculation(details);
        }

}
