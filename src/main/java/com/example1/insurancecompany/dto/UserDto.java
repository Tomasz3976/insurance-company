package com.example1.insurancecompany.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class UserDto {

        private Long id;
        private String firstName;
        private String lastName;
        private String username;
        private Integer dayOfBirth;
        private Integer monthOfBirth;
        private Integer yearOfBirth;
        private String email;
        private Integer phone;
        private String password;

}
