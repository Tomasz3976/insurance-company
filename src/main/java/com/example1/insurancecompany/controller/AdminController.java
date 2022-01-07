package com.example1.insurancecompany.controller;

import com.example1.insurancecompany.domain.Role;
import com.example1.insurancecompany.domain.User;
import com.example1.insurancecompany.dto.UserDisplayDto;
import com.example1.insurancecompany.dto.UserDto;
import com.example1.insurancecompany.mapper.UserDisplayDtoMapper;
import com.example1.insurancecompany.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

        private final UserService userService;


        @GetMapping("/users/all")
        public List<UserDisplayDto> getUsers(@RequestParam Integer page) {
                return UserDisplayDtoMapper.mapUserToUserDisplayDto(userService.getAllUsers(page));
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
