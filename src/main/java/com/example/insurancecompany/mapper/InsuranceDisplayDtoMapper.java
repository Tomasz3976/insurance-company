package com.example.insurancecompany.mapper;

import com.example.insurancecompany.domain.Insurance;
import com.example.insurancecompany.dto.InsuranceDisplayDto;
import org.springframework.stereotype.Service;

@Service
public class InsuranceDisplayDtoMapper {

        public static InsuranceDisplayDto mapToInsuranceDisplayDto(Insurance insurance) {

                return InsuranceDisplayDto.builder()
                        .id(insurance.getId())
                        .type(insurance.getType())
                        .startDate(insurance.getStartDate())
                        .endDate(insurance.getEndDate())
                        .price(insurance.getPrice())
                        .build();

        }

}
