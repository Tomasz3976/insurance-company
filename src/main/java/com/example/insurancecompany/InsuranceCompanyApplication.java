package com.example.insurancecompany;

import com.example.insurancecompany.domain.Role;
import com.example.insurancecompany.dto.UserInDto;
import com.example.insurancecompany.repository.RoleRepository;
import com.example.insurancecompany.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class InsuranceCompanyApplication {

	public static void main(String[] args) {
		SpringApplication.run(InsuranceCompanyApplication.class, args);
	}
	@Bean
	public CommandLineRunner loadData(UserService userService, RoleRepository roleRepository) {
		return (args) -> {

			roleRepository.save(new Role(1L, "ROLE_USER", new ArrayList<>()));
			roleRepository.save(new Role(2L, "ROLE_ADMIN", new ArrayList<>()));
			userService.saveUser(new UserInDto( "Tomasz", "Nowak",
				"tomeczek", 30, 6, 2002,
				"jakismail@gmail.com", 745900321, "Melodie345"));

			userService.addRoleToUser(1L, "ROLE_USER");
			userService.addRoleToUser(1L, "ROLE_ADMIN");

		};

	}
}
