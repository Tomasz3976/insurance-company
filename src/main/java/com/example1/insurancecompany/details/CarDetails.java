package com.example1.insurancecompany.details;

import lombok.*;

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
