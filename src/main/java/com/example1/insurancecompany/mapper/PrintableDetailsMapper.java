package com.example1.insurancecompany.mapper;

import com.example1.insurancecompany.details.CarDetails;
import com.example1.insurancecompany.details.HouseDetails;
import org.springframework.stereotype.Service;

@Service
public class PrintableDetailsMapper {

        public static String mapToCarPrintableDetails(CarDetails details) {

                return "Brand: " + details.getBrand()
                        + "\nModel: " + details.getModel()
                        + "\nRegistration Number: " + details.getRegistrationNumber()
                        + "\nYear Of Production: " + details.getYearOfProduction()
                        + "\nMileage (km): " + details.getMileageInKm()
                        + "\nEngine Capacity (cm3): " + details.getEngineCapacityInCm3();

        }

        public static String mapToHousePrintableDetails(HouseDetails details) {

                return "Town: " + details.getTown()
                        + "\nStreet: " + details.getStreet()
                        + "\nHouse Number: " + details.getHouseNumber()
                        + "\nZip Code: " + details.getZipCode()
                        + "\nConstruction Year: " + details.getConstructionYear()
                        + "\nBuilding Value: " + details.getBuildingValue();

        }

}
