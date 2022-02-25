package com.example.insurancecompany.mapper;

import com.example.insurancecompany.domain.User;
import com.example.insurancecompany.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDtoMapper {

        public static List<UserDto> mapToUserDto(List<User> users) {

                return users.stream()
                        .map(user -> new UserDto(user.getId(), user.getFirstName(),
                                user.getLastName(), user.getUsername(), user.getDayOfBirth(),
                                user.getMonthOfBirth(), user.getYearOfBirth(), user.getEmail(),
                                user.getPhone(), user.getPassword())).collect(Collectors.toList());

        }

}
