package com.example1.insurancecompany.controller;

import com.example1.insurancecompany.details.CarCalculateDetails;
import com.example1.insurancecompany.details.HouseCalculateDetails;
import com.example1.insurancecompany.details.InsurancePrice;
import com.example1.insurancecompany.service.CalculationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/calculation")
public class CalculationController {

        private final CalculationService calculationService;

        @PostMapping("/cars")
        public InsurancePrice carInsuranceCalculation(@RequestBody CarCalculateDetails details) {
                return calculationService.carInsuranceCalculation(details);
        }

        @PostMapping("/houses")
        public InsurancePrice houseInsuranceCalculation(@RequestBody HouseCalculateDetails details) {
                return calculationService.houseInsuranceCalculation(details);
        }

}
