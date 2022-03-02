package com.example.insurancecompany.mapper;

import com.example.insurancecompany.domain.User;
import com.example.insurancecompany.dto.UserInDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserInDtoMapper {

        public static User mapToUser(UserInDto userInDto) {

                return User.builder()
                        .firstName(userInDto.getFirstName())
                        .lastName(userInDto.getLastName())
                        .username(userInDto.getUsername())
                        .dayOfBirth(userInDto.getDayOfBirth())
                        .monthOfBirth(userInDto.getMonthOfBirth())
                        .yearOfBirth(userInDto.getYearOfBirth())
                        .email(userInDto.getEmail())
                        .phone(userInDto.getPhone())
                        .password(userInDto.getPassword())
                        .roles(new ArrayList<>())
                        .insurances(new ArrayList<>())
                        .build();

        }

}
