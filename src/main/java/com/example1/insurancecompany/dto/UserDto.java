package com.example1.insurancecompany.dto;

import lombok.*;

@Data
@AllArgsConstructor
@Builder
public class UserDto {

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
