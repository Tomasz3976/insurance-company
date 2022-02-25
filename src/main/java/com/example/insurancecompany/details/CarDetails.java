package com.example.insurancecompany.details;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class CarDetails {

        private String brand;
        private String model;
        private String registrationNumber;
        private Integer yearOfProduction;
        private Integer mileageInKm;
        private Integer engineCapacityInCm3;
        private Integer insuranceTimeInYears;


}
