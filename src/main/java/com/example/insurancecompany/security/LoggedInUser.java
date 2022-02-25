package com.example.insurancecompany.security;

import com.example.insurancecompany.repository.UserRepository;
import com.example.insurancecompany.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoggedInUser {

        private final UserRepository userRepository;

        public User getUser() {

                Authentication principal = SecurityContextHolder.getContext().getAuthentication();
                String username = principal.getName();
                return userRepository.findByUsername(username).orElseThrow();

        }

}
