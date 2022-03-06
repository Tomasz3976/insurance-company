package com.example.insurancecompany.controller;

import com.example.insurancecompany.domain.Role;
import com.example.insurancecompany.domain.User;
import com.example.insurancecompany.dto.UserDto;
import com.example.insurancecompany.dto.UserInDto;
import com.example.insurancecompany.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

        private final UserService userService;

        @GetMapping("/users")
        public List<UserDto> getAllUsers(@RequestParam(required = false) Integer page) {
                return userService.getAllUsers(page);
        }

        @PostMapping("/users")
        public UserInDto saveUser(@RequestBody UserInDto userInDto) {
                return userService.saveUser(userInDto);
        }

        @PutMapping("/users/{id}")
        public User editUser(@PathVariable Long id, @RequestBody UserInDto userInDto) {
                return userService.editUser(id, userInDto);
        }

        @DeleteMapping("/users/{id}")
        public void deleteUser(@PathVariable Long id) {
                userService.deleteUser(id);
        }

        @PostMapping("/roles")
        public Role saveRole(@RequestBody Role role) {
                return userService.saveRole(role);
        }

        @PutMapping("/users/{id}/roles")
        public User addRoleToUser(@PathVariable Long id, @RequestParam String roleName) {
                return userService.addRoleToUser(id, roleName);
        }

        @DeleteMapping("/users/{id}/roles/{roleName}")
        public void deleteUserRole(@PathVariable Long id, @PathVariable String roleName) {
                userService.deleteUserRole(id, roleName);
        }

        @DeleteMapping("/users/insurances/{id}")
        public void deleteInsurance(@PathVariable Long id) {
                userService.deleteInsurance(id);
        }

}
