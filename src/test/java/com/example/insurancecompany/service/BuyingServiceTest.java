package com.example.insurancecompany.service;

import com.example.insurancecompany.constant.InsuranceType;
import com.example.insurancecompany.details.CarDetails;
import com.example.insurancecompany.domain.Insurance;
import com.example.insurancecompany.domain.User;
import com.example.insurancecompany.dto.InsuranceDto;
import com.example.insurancecompany.repository.InsuranceRepository;
import com.example.insurancecompany.security.LoggedInUser;
import com.example.insurancecompany.details.HouseDetails;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class BuyingServiceTest {

        @Mock
        private InsuranceRepository insuranceRepository;

        @Mock
        private LoggedInUser loggedInUser;

        @InjectMocks
        private BuyingService buyingService;


        @Test
        void itShouldBuyCarInsurance() {

                CarDetails carDetails = CarDetails.builder()
                        .brand("Peugeot")
                        .model("208")
                        .registrationNumber("ERD-76409")
                        .yearOfProduction(2019)
                        .mileageInKm(8500)
                        .engineCapacityInCm3(1800)
                        .insuranceTimeInYears(1)
                        .build();

                User user = User.builder()
                        .build();

                Insurance carInsurance = Insurance.builder()
                        .type(InsuranceType.CAR)
                        .startDate(LocalDate.now())
                        .endDate(LocalDate.now().plusYears(1))
                        .price(1015)
                        .printableDetails("\nBrand: Peugeot\nModel: 208\nRegistration Number: ERD-76409"
                                + "\nYear Of Production: 2019\nMileage (km): 8500\nEngine Capacity (cm3): 1800")
                        .user(user)
                        .build();

                InsuranceDto insuranceDto = InsuranceDto.builder()
                        .type(InsuranceType.CAR)
                        .startDate(LocalDate.now())
                        .endDate(LocalDate.now().plusYears(1))
                        .price(1015)
                        .build();


                given(insuranceRepository.save(carInsurance)).willReturn(carInsurance);
                given(loggedInUser.getUser()).willReturn(user);


                assertThat(buyingService.buyCarInsurance(carDetails)).isEqualTo(insuranceDto);

        }

        @Test
        void itShouldBuyHouseInsurance() {

                HouseDetails houseDetails = HouseDetails.builder()
                        .town("Manchester")
                        .street("Queen Victoria Street")
                        .houseNumber("238")
                        .zipCode("M29")
                        .constructionYear(1978)
                        .buildingValue(410000)
                        .insuranceTimeInYears(6)
                        .build();

                User user = User.builder()
                        .insurances(new ArrayList<>())
                        .build();

                Insurance houseInsurance = Insurance.builder()
                        .type(InsuranceType.HOUSE)
                        .startDate(LocalDate.now())
                        .endDate(LocalDate.now().plusYears(6))
                        .price(31200)
                        .printableDetails("\nTown: Manchester\nStreet: Queen Victoria Street\nHouse Number: 238"
                                + "\nZip Code: M29\nConstruction Year: 1978\nBuilding Value: 410000")
                        .user(user)
                        .build();

                InsuranceDto insuranceDto = InsuranceDto.builder()
                        .type(InsuranceType.HOUSE)
                        .startDate(LocalDate.now())
                        .endDate(LocalDate.now().plusYears(6))
                        .price(31200)
                        .build();


                given(insuranceRepository.save(houseInsurance)).willReturn(houseInsurance);
                given(loggedInUser.getUser()).willReturn(user);


                assertThat(buyingService.buyHouseInsurance(houseDetails)).isEqualTo(insuranceDto);

        }

}