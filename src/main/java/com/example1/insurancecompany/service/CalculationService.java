package com.example1.insurancecompany.service;

import com.example1.insurancecompany.calculator.Calculator;
import com.example1.insurancecompany.details.CarCalculateDetails;
import com.example1.insurancecompany.details.HouseCalculateDetails;
import com.example1.insurancecompany.details.InsurancePrice;
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
