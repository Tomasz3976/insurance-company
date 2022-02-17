package com.example1.insurancecompany.service;

import com.example1.insurancecompany.calculator.Calculator;
import com.example1.insurancecompany.details.CarCalculateDetails;
import com.example1.insurancecompany.details.HouseCalculateDetails;
import com.example1.insurancecompany.details.InsurancePrice;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CalculationServiceTest {


        @InjectMocks
        private CalculationService calculationService;


        @Test
        void itShouldCalculateCarInsurance() {
                CarCalculateDetails details = CarCalculateDetails.builder().yearOfProduction(2018)
                        .mileageInKm(30000).engineCapacityInCm3(2500).insuranceTimeInYears(1).build();

                try (MockedStatic<Calculator> mockedStatic = Mockito.mockStatic(Calculator.class)) {

                        mockedStatic.when(() -> Calculator.carInsuranceCalculator(details)).thenReturn(1590);

                        assertThat(calculationService.carInsuranceCalculation(details)).isInstanceOf(InsurancePrice.class)
                                .hasFieldOrPropertyWithValue("price", 1590);

                }
        }

        @Test
        void itShouldCalculateHouseInsurance() {
                HouseCalculateDetails details = HouseCalculateDetails.builder().constructionYear(1940)
                        .buildingValue(300000).insuranceTimeInYears(5).build();

                try (MockedStatic<Calculator> mockedStatic = Mockito.mockStatic(Calculator.class)) {

                        mockedStatic.when(() -> Calculator.houseInsuranceCalculator(details)).thenReturn(25250);

                        assertThat(calculationService.houseInsuranceCalculation(details)).isInstanceOf(InsurancePrice.class)
                                .hasFieldOrPropertyWithValue("price", 25250);

                }

        }

        @Test
        void itShouldThrowIllegalArgumentExceptionInCarInsurance() {

                CarCalculateDetails details = CarCalculateDetails.builder().build();

                try (MockedStatic<Calculator> mockedStatic = Mockito.mockStatic(Calculator.class)) {

                        mockedStatic.when(() -> Calculator.carInsuranceCalculator(details))
                                .thenThrow(new IllegalArgumentException());

                        assertThrows(IllegalArgumentException.class, () -> calculationService.carInsuranceCalculation(details));

                }
        }

        @Test
        void itShouldThrowIllegalArgumentExceptionInHouseInsurance() {

                HouseCalculateDetails details = HouseCalculateDetails.builder().build();

                try (MockedStatic<Calculator> mockedStatic = Mockito.mockStatic(Calculator.class)) {

                        mockedStatic.when(() -> Calculator.houseInsuranceCalculator(details))
                                .thenThrow(new IllegalArgumentException());

                        assertThrows(IllegalArgumentException.class, () -> calculationService.houseInsuranceCalculation(details));

                }

        }

}