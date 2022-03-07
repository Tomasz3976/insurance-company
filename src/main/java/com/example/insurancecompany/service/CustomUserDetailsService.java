package com.example.insurancecompany.service;

import com.example.insurancecompany.domain.ConfirmationToken;
import com.example.insurancecompany.domain.Role;
import com.example.insurancecompany.domain.User;
import com.example.insurancecompany.exception.ExistingEntityException;
import com.example.insurancecompany.repository.RoleRepository;
import com.example.insurancecompany.repository.UserRepository;
import com.example.insurancecompany.utils.EmailTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

@Service
@Transactional
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {

        private final UserRepository userRepository;
        private final RoleRepository roleRepository;
        private final PasswordEncoder passwordEncoder;
        private final ConfirmationTokenService confirmationTokenService;
        private final EmailService emailService;
        private final EmailTemplate emailTemplate;
        private final Integer tokenTime;

        public CustomUserDetailsService(UserRepository userRepository,
                                        RoleRepository roleRepository,
                                        PasswordEncoder passwordEncoder,
                                        ConfirmationTokenService confirmationTokenService,
                                        EmailService emailService,
                                        EmailTemplate emailTemplate,
                                        @Value("${confirmation.token.time}") Integer tokenTime) {
                this.userRepository = userRepository;
                this.roleRepository = roleRepository;
                this.passwordEncoder = passwordEncoder;
                this.confirmationTokenService = confirmationTokenService;
                this.emailService = emailService;
                this.emailTemplate = emailTemplate;
                this.tokenTime = tokenTime;
        }

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                User user = userRepository.findByUsername(username)
                        .orElseThrow(() -> new UsernameNotFoundException("Username Not Found!"));

                log.info("User found in the database: {}", username);

                Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
                user.getRoles().forEach(role -> {
                        authorities.add(new SimpleGrantedAuthority(role.getName()));
                });
                return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
        }

        public String signUpUser(User user) {
                log.info("Registration of new user {}", user.getUsername());
                user.setPassword(passwordEncoder.encode(user.getPassword()));
                userRepository.save(user);
                String token = UUID.randomUUID().toString();
                ConfirmationToken confirmationToken = new ConfirmationToken(
                        token,
                        LocalDateTime.now(),
                        LocalDateTime.now().plusMinutes(tokenTime),
                        user
                );
                confirmationTokenService.saveConfirmationToken(confirmationToken);
                String link = "http://localhost:8080/registration/confirm?token=" + token;
                String template = emailTemplate.buildEmail(user.getUsername(), link);
                emailService.send(user.getEmail(), template);
                String message = "Verification link has been sent to " + user.getEmail();
                return message;
        }

        public void enableUser(String email) {
                log.info("Activation account of user with email {}", email);
                User user = userRepository.findByEmail(email)
                        .orElseThrow(() -> new UsernameNotFoundException("Username Not Found!"));
                Role roleUser = roleRepository.findByName("ROLE_USER")
                                .orElseThrow(() -> new EntityNotFoundException("This Role Does Not Exists!"));
                user.getRoles().add(roleUser);
        }

}
