package com.example1.insurancecompany.mapper;

import com.example1.insurancecompany.domain.User;
import com.example1.insurancecompany.dto.UserDisplayDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDisplayDtoMapper {

        public static List<UserDisplayDto> mapToUserDisplayDto(List<User> users) {

                return users.stream()
                        .map(user -> new UserDisplayDto(user.getId(), user.getFirstName(),
                                user.getLastName(), user.getUsername(), user.getDayOfBirth(),
                                user.getMonthOfBirth(), user.getYearOfBirth(), user.getEmail(),
                                user.getPhone(), user.getPassword())).collect(Collectors.toList());

        }

}
