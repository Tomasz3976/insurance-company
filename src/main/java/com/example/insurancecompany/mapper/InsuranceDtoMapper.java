package com.example.insurancecompany.mapper;

import com.example.insurancecompany.domain.Insurance;
import com.example.insurancecompany.dto.InsuranceDto;
import org.springframework.stereotype.Service;

@Service
public class InsuranceDtoMapper {

        public static InsuranceDto mapToInsuranceDisplayDto(Insurance insurance) {

                return InsuranceDto.builder()
                        .id(insurance.getId())
                        .type(insurance.getType())
                        .startDate(insurance.getStartDate())
                        .endDate(insurance.getEndDate())
                        .price(insurance.getPrice())
                        .build();

        }

}
