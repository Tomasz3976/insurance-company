package com.example.insurancecompany.mapper;

import com.example.insurancecompany.details.CarDetails;
import com.example.insurancecompany.details.HouseDetails;
import org.springframework.stereotype.Service;

@Service
public class PrintableDetailsMapper {

        public static String mapToCarPrintableDetails(CarDetails details) {

                return "\nBrand: " + details.getBrand()
                        + "\nModel: " + details.getModel()
                        + "\nRegistration Number: " + details.getRegistrationNumber()
                        + "\nYear Of Production: " + details.getYearOfProduction()
                        + "\nMileage (km): " + details.getMileageInKm()
                        + "\nEngine Capacity (cm3): " + details.getEngineCapacityInCm3();

        }

        public static String mapToHousePrintableDetails(HouseDetails details) {

                return "\nTown: " + details.getTown()
                        + "\nStreet: " + details.getStreet()
                        + "\nHouse Number: " + details.getHouseNumber()
                        + "\nZip Code: " + details.getZipCode()
                        + "\nConstruction Year: " + details.getConstructionYear()
                        + "\nBuilding Value: " + details.getBuildingValue();

        }

}
