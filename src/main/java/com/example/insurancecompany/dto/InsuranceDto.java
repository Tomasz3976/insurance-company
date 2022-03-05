package com.example.insurancecompany.dto;

import com.example.insurancecompany.constant.InsuranceType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Builder
public class InsuranceDto {

        private Long id;
        private InsuranceType type;
        private LocalDate startDate;
        private LocalDate endDate;
        private Integer price;

}
