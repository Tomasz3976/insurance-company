package com.example.insurancecompany.controller;

import com.example.insurancecompany.details.CarDetails;
import com.example.insurancecompany.service.BuyingService;
import com.example.insurancecompany.details.HouseDetails;
import com.example.insurancecompany.dto.InsuranceDisplayDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/buying")
public class BuyingController {


        private final BuyingService buyingService;

        @PostMapping("/carInsurances")
        public InsuranceDisplayDto buyCarInsurance(@RequestBody CarDetails details) {
                return buyingService.buyCarInsurance(details);
        }

        @PostMapping("/houseInsurances")
        public InsuranceDisplayDto buyHouseInsurance(@RequestBody HouseDetails details) {
                return buyingService.buyHouseInsurance(details);
        }

}
