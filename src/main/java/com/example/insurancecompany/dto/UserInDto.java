package com.example.insurancecompany.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UserInDto {

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
