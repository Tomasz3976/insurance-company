package com.example.insurancecompany.service;

import com.example.insurancecompany.details.CarCalculateDetails;
import com.example.insurancecompany.mapper.PrintableDetailsMapper;
import com.example.insurancecompany.calculator.Calculator;
import com.example.insurancecompany.details.CarDetails;
import com.example.insurancecompany.details.HouseCalculateDetails;
import com.example.insurancecompany.details.HouseDetails;
import com.example.insurancecompany.domain.Insurance;
import com.example.insurancecompany.dto.InsuranceDisplayDto;
import com.example.insurancecompany.mapper.CalculateDetailsMapper;
import com.example.insurancecompany.mapper.InsuranceDisplayDtoMapper;
import com.example.insurancecompany.repository.InsuranceRepository;
import com.example.insurancecompany.security.LoggedInUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static com.example.insurancecompany.constant.InsuranceType.CAR;
import static com.example.insurancecompany.constant.InsuranceType.HOUSE;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class BuyingService {

        private final LoggedInUser loggedInUser;
        private final InsuranceRepository insuranceRepository;


        public InsuranceDisplayDto buyCarInsurance(CarDetails details) {

                CarCalculateDetails calculateDetails = CalculateDetailsMapper.mapToCarCalculateDetails(details);
                Integer price = Calculator.carInsuranceCalculator(calculateDetails);
                Integer time = details.getInsuranceTimeInYears();
                String printableDetails = PrintableDetailsMapper.mapToCarPrintableDetails(details);

                log.info("Registering a new car insurance");


                Insurance carInsurance = Insurance.builder()
                        .type(CAR)
                        .startDate(LocalDate.now())
                        .endDate(LocalDate.now().plusYears(time))
                        .price(price)
                        .printableDetails(printableDetails)
                        .build();

                insuranceRepository.save(carInsurance);

                loggedInUser.getUser().getInsurances().add(carInsurance);

                InsuranceDisplayDto insuranceDisplayDto = InsuranceDisplayDtoMapper.mapToInsuranceDisplayDto(carInsurance);

                return insuranceDisplayDto;

        }

        public InsuranceDisplayDto buyHouseInsurance(HouseDetails details) {

                HouseCalculateDetails calculateDetails = CalculateDetailsMapper.mapToHouseCalculateDetails(details);
                Integer price = Calculator.houseInsuranceCalculator(calculateDetails);
                Integer time = details.getInsuranceTimeInYears();
                String printableDetails = PrintableDetailsMapper.mapToHousePrintableDetails(details);

                log.info("Registering a new house insurance");


                Insurance houseInsurance = Insurance.builder()
                        .type(HOUSE)
                        .startDate(LocalDate.now())
                        .endDate(LocalDate.now().plusYears(time))
                        .price(price)
                        .printableDetails(printableDetails)
                        .build();

                insuranceRepository.save(houseInsurance);

                loggedInUser.getUser().getInsurances().add(houseInsurance);

                InsuranceDisplayDto insuranceDisplayDto = InsuranceDisplayDtoMapper.mapToInsuranceDisplayDto(houseInsurance);

                return insuranceDisplayDto;

        }

}
