package com.example.insurancecompany.service;

import com.example.insurancecompany.details.CarCalculateDetails;
import com.example.insurancecompany.details.HouseCalculateDetails;
import com.example.insurancecompany.details.InsurancePrice;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class CalculationServiceTest {


        @InjectMocks
        private CalculationService calculationService;


        @Test
        void itShouldCalculateCarInsurance() {

                CarCalculateDetails details = CarCalculateDetails.builder()
                        .yearOfProduction(2018)
                        .mileageInKm(30000)
                        .engineCapacityInCm3(2500)
                        .insuranceTimeInYears(1)
                        .build();


                assertThat(calculationService.carInsuranceCalculation(details))
                        .isInstanceOf(InsurancePrice.class)
                        .hasFieldOrPropertyWithValue("price", 1590);

        }

        @Test
        void itShouldCalculateHouseInsurance() {

                HouseCalculateDetails details = HouseCalculateDetails.builder()
                        .constructionYear(1940)
                        .buildingValue(300000)
                        .insuranceTimeInYears(5)
                        .build();


                assertThat(calculationService.houseInsuranceCalculation(details))
                        .isInstanceOf(InsurancePrice.class)
                        .hasFieldOrPropertyWithValue("price", 25250);

        }

        @Test
        void itShouldThrowExceptionDueToTheYearOfProductionOfCar() {

                CarCalculateDetails details = CarCalculateDetails.builder()
                        .yearOfProduction(1898)
                        .mileageInKm(10000)
                        .engineCapacityInCm3(2600)
                        .insuranceTimeInYears(2)
                        .build();


                assertThrows(IllegalArgumentException.class, () -> calculationService.carInsuranceCalculation(details));

        }

        @Test
        void itShouldThrowExceptionDueToTheMileageOfCar() {

                CarCalculateDetails details = CarCalculateDetails.builder()
                        .yearOfProduction(2015)
                        .mileageInKm(-1)
                        .engineCapacityInCm3(3500)
                        .insuranceTimeInYears(3)
                        .build();


                assertThrows(IllegalArgumentException.class, () -> calculationService.carInsuranceCalculation(details));

        }

        @Test
        void itShouldThrowExceptionDueToTheEngineCapacityOfCar() {

                CarCalculateDetails details = CarCalculateDetails.builder()
                        .yearOfProduction(2014)
                        .mileageInKm(35000)
                        .engineCapacityInCm3(9500)
                        .insuranceTimeInYears(1)
                        .build();


                assertThrows(IllegalArgumentException.class, () -> calculationService.carInsuranceCalculation(details));

        }

        @Test
        void itShouldThrowExceptionDueToTheInsuranceTimeOfCar() {

                CarCalculateDetails details = CarCalculateDetails.builder()
                        .yearOfProduction(2020)
                        .mileageInKm(300)
                        .engineCapacityInCm3(1400)
                        .insuranceTimeInYears(11)
                        .build();


                assertThrows(IllegalArgumentException.class, () -> calculationService.carInsuranceCalculation(details));

        }

        @Test
        void itShouldThrowExceptionDueToTheConstructionYearOfHouse() {

                HouseCalculateDetails details = HouseCalculateDetails.builder()
                        .constructionYear(1750)
                        .buildingValue(250000)
                        .insuranceTimeInYears(1)
                        .build();


                assertThrows(IllegalArgumentException.class, () -> calculationService.houseInsuranceCalculation(details));

        }

        @Test
        void itShouldThrowExceptionDueToTheBuildingValueOfHouse() {

                HouseCalculateDetails details = HouseCalculateDetails.builder()
                        .constructionYear(1995)
                        .buildingValue(3000)
                        .insuranceTimeInYears(6)
                        .build();


                assertThrows(IllegalArgumentException.class, () -> calculationService.houseInsuranceCalculation(details));

        }

        @Test
        void itShouldThrowExceptionDueToTheInsuranceTimeOfHouse() {

                HouseCalculateDetails details = HouseCalculateDetails.builder()
                        .constructionYear(2012)
                        .buildingValue(345000)
                        .insuranceTimeInYears(21)
                        .build();


                assertThrows(IllegalArgumentException.class, () -> calculationService.houseInsuranceCalculation(details));

        }

}