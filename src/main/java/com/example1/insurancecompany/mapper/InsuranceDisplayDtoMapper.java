package com.example1.insurancecompany.mapper;

import com.example1.insurancecompany.domain.Insurance;
import com.example1.insurancecompany.dto.InsuranceDisplayDto;
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
