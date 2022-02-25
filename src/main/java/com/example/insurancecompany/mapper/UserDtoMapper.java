package com.example.insurancecompany.mapper;

import com.example.insurancecompany.domain.User;
import com.example.insurancecompany.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDtoMapper {

        public static User mapToUser(UserDto userDto) {

                return User.builder()
                        .firstName(userDto.getFirstName())
                        .lastName(userDto.getLastName())
                        .username(userDto.getUsername())
                        .dayOfBirth(userDto.getDayOfBirth())
                        .monthOfBirth(userDto.getMonthOfBirth())
                        .yearOfBirth(userDto.getYearOfBirth())
                        .email(userDto.getEmail())
                        .phone(userDto.getPhone())
                        .password(userDto.getPassword())
                        .roles(new ArrayList<>())
                        .build();

        }

}