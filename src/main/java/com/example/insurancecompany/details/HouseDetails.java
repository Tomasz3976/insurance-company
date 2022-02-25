package com.example.insurancecompany.details;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class HouseDetails {

        private String town;
        private String street;
        private String houseNumber;
        private String zipCode;
        private Integer constructionYear;
        private Integer buildingValue;
        private Integer insuranceTimeInYears;

}
