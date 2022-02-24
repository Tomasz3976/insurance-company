package com.example1.insurancecompany.details;

import lombok.*;

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
