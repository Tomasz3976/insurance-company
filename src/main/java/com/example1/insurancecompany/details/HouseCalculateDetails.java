package com.example1.insurancecompany.details;

import lombok.*;

@Data
@AllArgsConstructor
@Builder
public class HouseCalculateDetails {

        private Integer constructionYear;
        private Integer buildingValue;
        private Integer insuranceTimeInYears;

}
