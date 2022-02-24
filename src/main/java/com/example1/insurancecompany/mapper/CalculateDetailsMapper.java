package com.example1.insurancecompany.mapper;

import com.example1.insurancecompany.details.CarCalculateDetails;
import com.example1.insurancecompany.details.CarDetails;
import com.example1.insurancecompany.details.HouseCalculateDetails;
import com.example1.insurancecompany.details.HouseDetails;
import org.springframework.stereotype.Service;

@Service
public class CalculateDetailsMapper {

        public static CarCalculateDetails mapToCarCalculateDetails(CarDetails details) {

                return CarCalculateDetails.builder()
                        .yearOfProduction(details.getYearOfProduction())
                        .mileageInKm(details.getMileageInKm())
                        .engineCapacityInCm3(details.getEngineCapacityInCm3())
                        .insuranceTimeInYears(details.getInsuranceTimeInYears())
                        .build();

        }

        public static HouseCalculateDetails mapToHouseCalculateDetails(HouseDetails details) {

                return HouseCalculateDetails.builder()
                        .constructionYear(details.getConstructionYear())
                        .buildingValue(details.getBuildingValue())
                        .insuranceTimeInYears(details.getInsuranceTimeInYears())
                        .build();

        }

}
