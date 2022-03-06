package com.example.insurancecompany.service;

import com.example.insurancecompany.details.CarCalculateDetails;
import com.example.insurancecompany.domain.User;
import com.example.insurancecompany.mapper.PrintableDetailsMapper;
import com.example.insurancecompany.utils.Calculator;
import com.example.insurancecompany.details.CarDetails;
import com.example.insurancecompany.details.HouseCalculateDetails;
import com.example.insurancecompany.details.HouseDetails;
import com.example.insurancecompany.domain.Insurance;
import com.example.insurancecompany.dto.InsuranceDto;
import com.example.insurancecompany.mapper.CalculateDetailsMapper;
import com.example.insurancecompany.mapper.InsuranceDtoMapper;
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

        public InsuranceDto buyCarInsurance(CarDetails details) {
                CarCalculateDetails calculateDetails = CalculateDetailsMapper.mapToCarCalculateDetails(details);
                Integer price = Calculator.carInsuranceCalculator(calculateDetails);
                Integer time = details.getInsuranceTimeInYears();
                String printableDetails = PrintableDetailsMapper.mapToCarPrintableDetails(details);
                User user = loggedInUser.getUser();
                log.info("Registering a new car insurance");
                Insurance carInsurance = Insurance.builder()
                        .type(CAR)
                        .startDate(LocalDate.now())
                        .endDate(LocalDate.now().plusYears(time))
                        .price(price)
                        .printableDetails(printableDetails)
                        .user(user)
                        .build();
                insuranceRepository.save(carInsurance);
                InsuranceDto insuranceDto = InsuranceDtoMapper.mapToInsuranceDisplayDto(carInsurance);
                return insuranceDto;
        }

        public InsuranceDto buyHouseInsurance(HouseDetails details) {
                HouseCalculateDetails calculateDetails = CalculateDetailsMapper.mapToHouseCalculateDetails(details);
                Integer price = Calculator.houseInsuranceCalculator(calculateDetails);
                Integer time = details.getInsuranceTimeInYears();
                String printableDetails = PrintableDetailsMapper.mapToHousePrintableDetails(details);
                User user = loggedInUser.getUser();
                log.info("Registering a new house insurance");
                Insurance houseInsurance = Insurance.builder()
                        .type(HOUSE)
                        .startDate(LocalDate.now())
                        .endDate(LocalDate.now().plusYears(time))
                        .price(price)
                        .printableDetails(printableDetails)
                        .user(user)
                        .build();
                insuranceRepository.save(houseInsurance);
                InsuranceDto insuranceDto = InsuranceDtoMapper.mapToInsuranceDisplayDto(houseInsurance);
                return insuranceDto;
        }

}
