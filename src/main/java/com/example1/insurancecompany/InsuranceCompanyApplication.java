package com.example1.insurancecompany;

import com.example1.insurancecompany.domain.Role;
import com.example1.insurancecompany.domain.User;
import com.example1.insurancecompany.dto.UserDto;
import com.example1.insurancecompany.repository.RoleRepository;
import com.example1.insurancecompany.repository.UserRepository;
import com.example1.insurancecompany.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
@EnableSwagger2
public class InsuranceCompanyApplication {

	public static void main(String[] args) {
		SpringApplication.run(InsuranceCompanyApplication.class, args);
	}




}
