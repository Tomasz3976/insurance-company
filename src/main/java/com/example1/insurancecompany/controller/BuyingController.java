package com.example1.insurancecompany.controller;

import com.example1.insurancecompany.details.CarDetails;
import com.example1.insurancecompany.details.HouseDetails;
import com.example1.insurancecompany.dto.InsuranceDisplayDto;
import com.example1.insurancecompany.service.BuyingService;
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

        @PostMapping("/carInsurance")
        public InsuranceDisplayDto buyCarInsurance(@RequestBody CarDetails details) {
                return buyingService.buyCarInsurance(details);
        }

        @PostMapping("/houseInsurance")
        public InsuranceDisplayDto buyHouseInsurance(@RequestBody HouseDetails details) {
                return buyingService.buyHouseInsurance(details);
        }

}
