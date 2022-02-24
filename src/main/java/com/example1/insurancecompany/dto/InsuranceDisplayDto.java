package com.example1.insurancecompany.dto;

import com.example1.insurancecompany.constant.InsuranceType;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@Builder
public class InsuranceDisplayDto {

        private Long id;
        private InsuranceType type;
        private LocalDate startDate;
        private LocalDate endDate;
        private Integer price;

}
