package com.example.insurancecompany.service;

import com.example.insurancecompany.utils.Calculator;
import com.example.insurancecompany.details.CarCalculateDetails;
import com.example.insurancecompany.details.HouseCalculateDetails;
import com.example.insurancecompany.details.InsurancePrice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class CalculationService {

        public InsurancePrice carInsuranceCalculation(CarCalculateDetails details) {
                log.info("Calculation performed");
                return new InsurancePrice(Calculator.carInsuranceCalculator(details));
        }

        public InsurancePrice houseInsuranceCalculation(HouseCalculateDetails details) {
                log.info("Calculation performed");
                return new InsurancePrice(Calculator.houseInsuranceCalculator(details));
        }

}
