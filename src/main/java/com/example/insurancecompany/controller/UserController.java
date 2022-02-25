package com.example.insurancecompany.controller;

import com.example.insurancecompany.domain.Role;
import com.example.insurancecompany.domain.User;
import com.example.insurancecompany.dto.UserDisplayDto;
import com.example.insurancecompany.dto.UserDto;
import com.example.insurancecompany.mapper.UserDisplayDtoMapper;
import com.example.insurancecompany.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

        private final UserService userService;


        @GetMapping("/users")
        public List<UserDisplayDto> getUsers(@RequestParam Integer page) {
                return UserDisplayDtoMapper.mapToUserDisplayDto(userService.getAllUsers(page));
        }

        @PostMapping("/users")
        public UserDto saveUser(@RequestBody UserDto userDto) {
                return userService.saveUser(userDto);
        }

        @PutMapping("/users/{id}")
        public User editUser(@PathVariable Long id, @RequestBody UserDto userDto) {
                return userService.editUser(id, userDto);
        }

        @DeleteMapping("/users/{id}")
        public void deleteUser(@PathVariable Long id) {
                userService.deleteUser(id);
        }

        @PostMapping("/roles")
        public Role saveRole(@RequestBody Role role) {
                return userService.saveRole(role);
        }

}
