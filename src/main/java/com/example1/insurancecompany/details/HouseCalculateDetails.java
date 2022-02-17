package com.example1.insurancecompany.details;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class HouseCalculateDetails {

        private Integer constructionYear;
        private Integer buildingValue;
        private Integer insuranceTimeInYears;

}
