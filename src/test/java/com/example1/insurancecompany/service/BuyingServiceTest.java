package com.example1.insurancecompany.service;

import com.example1.insurancecompany.details.CarDetails;
import com.example1.insurancecompany.details.HouseDetails;
import com.example1.insurancecompany.domain.Insurance;
import com.example1.insurancecompany.domain.User;
import com.example1.insurancecompany.dto.InsuranceDisplayDto;
import com.example1.insurancecompany.repository.InsuranceRepository;
import com.example1.insurancecompany.security.LoggedInUser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;

import static com.example1.insurancecompany.constant.InsuranceType.CAR;
import static com.example1.insurancecompany.constant.InsuranceType.HOUSE;
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

                Insurance carInsurance = Insurance.builder()
                        .type(CAR)
                        .startDate(LocalDate.now())
                        .endDate(LocalDate.now().plusYears(1))
                        .price(1015)
                        .printableDetails("Brand: Peugeot\nModel: 208\nRegistration Number: ERD-76409"
                                + "\nYear Of Production: 2019\nMileage (km): 8500\nEngine Capacity (cm3): 1800")
                        .build();

                InsuranceDisplayDto insuranceDisplayDto = InsuranceDisplayDto.builder()
                        .type(CAR)
                        .startDate(LocalDate.now())
                        .endDate(LocalDate.now().plusYears(1))
                        .price(1015)
                        .build();

                User user = User.builder()
                        .insurances(new ArrayList<>())
                        .build();


                given(insuranceRepository.save(carInsurance)).willReturn(carInsurance);
                given(loggedInUser.getUser()).willReturn(user);


                assertThat(buyingService.buyCarInsurance(carDetails)).isEqualTo(insuranceDisplayDto);
                assertThat(user.getInsurances().contains(carInsurance)).isTrue();

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

                Insurance houseInsurance = Insurance.builder()
                        .type(HOUSE)
                        .startDate(LocalDate.now())
                        .endDate(LocalDate.now().plusYears(6))
                        .price(31200)
                        .printableDetails("Town: Manchester\nStreet: Queen Victoria Street\nHouse Number: 238"
                                + "\nZip Code: M29\nConstruction Year: 1978\nBuilding Value: 410000")
                        .build();

                InsuranceDisplayDto insuranceDisplayDto = InsuranceDisplayDto.builder()
                        .type(HOUSE)
                        .startDate(LocalDate.now())
                        .endDate(LocalDate.now().plusYears(6))
                        .price(31200)
                        .build();

                User user = User.builder()
                        .insurances(new ArrayList<>())
                        .build();


                given(insuranceRepository.save(houseInsurance)).willReturn(houseInsurance);
                given(loggedInUser.getUser()).willReturn(user);


                assertThat(buyingService.buyHouseInsurance(houseDetails)).isEqualTo(insuranceDisplayDto);
                assertThat(user.getInsurances().contains(houseInsurance)).isTrue();

        }

}