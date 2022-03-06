package com.example.insurancecompany.service;

import com.example.insurancecompany.domain.Insurance;
import com.example.insurancecompany.domain.Role;
import com.example.insurancecompany.dto.UserDto;
import com.example.insurancecompany.mapper.UserDtoMapper;
import com.example.insurancecompany.repository.InsuranceRepository;
import com.example.insurancecompany.repository.RoleRepository;
import com.example.insurancecompany.repository.UserRepository;
import com.example.insurancecompany.domain.User;
import com.example.insurancecompany.dto.UserInDto;
import com.example.insurancecompany.exception.AssignedRoleException;
import com.example.insurancecompany.exception.ExistingEntityException;
import com.example.insurancecompany.mapper.UserInDtoMapper;
import com.example.insurancecompany.utils.PageValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserService {

        public static final int DEFAULT_PAGE_SIZE = 5;
        private final UserRepository userRepository;
        private final PasswordEncoder passwordEncoder;
        private final RoleRepository roleRepository;
        private final InsuranceRepository insuranceRepository;

        public List<UserDto> getAllUsers(Integer page) {
                log.info("Fetching all users");
                int pageNumber = PageValidator.pageNumber(page);
                List<User> users = userRepository.findUsers(PageRequest.of(pageNumber - 1, DEFAULT_PAGE_SIZE));
                return UserDtoMapper.mapToUserDto(users);
        }

        public UserInDto saveUser(UserInDto userInDto) {
                if(userRepository.findByUsername(userInDto.getUsername()).isPresent()) {

                        throw new ExistingEntityException("User With Given Username Already Exists!");
                }
                log.info("Saving new user {} to the database", userInDto.getUsername());
                userInDto.setPassword(passwordEncoder.encode(userInDto.getPassword()));
                userRepository.save(UserInDtoMapper.mapToUser(userInDto));
                return userInDto;
        }

        public User editUser(Long id, UserInDto userInDto) {
                User userEdited = userRepository.findById(id)
                        .orElseThrow(() -> new UsernameNotFoundException("This User Does Not Exists!"));
                log.info("Edition user with id {}", id);
                userEdited.setFirstName(userInDto.getFirstName());
                userEdited.setLastName(userInDto.getLastName());
                userEdited.setUsername(userInDto.getUsername());
                userEdited.setDayOfBirth(userInDto.getDayOfBirth());
                userEdited.setMonthOfBirth(userInDto.getMonthOfBirth());
                userEdited.setYearOfBirth(userInDto.getYearOfBirth());
                userEdited.setEmail(userInDto.getEmail());
                userEdited.setPhone(userInDto.getPhone());
                userEdited.setPassword(passwordEncoder.encode(userInDto.getPassword()));
                return userRepository.save(userEdited);
        }

        public void deleteUser(Long id) {
                log.info("Deleting user with id {}", id);
                if(!userRepository.existsById(id)) throw new UsernameNotFoundException("This User Does Not Exists!");
                userRepository.deleteById(id);
        }

        public Role saveRole(Role role) {
                log.info("Saving new role {} to the database", role.getName());
                if(roleRepository.findByName(role.getName()).isPresent()) {

                        throw new ExistingEntityException("Role With Given Name Already Exists!");
                }
                return roleRepository.save(role);
        }

        public User addRoleToUser(Long id, String roleName) {
                log.info("Adding role {} to user with id {}", roleName, id);
                User user = userRepository.findById(id)
                        .orElseThrow(() -> new UsernameNotFoundException("This User Does Not Exists!"));
                Role role = roleRepository.findByName(roleName)
                        .orElseThrow(() -> new EntityNotFoundException("This Role Does Not Exists!"));
                if(user.getRoles().contains(role)) {

                        throw new AssignedRoleException("User Already Has This Role");
                }
                user.getRoles().add(role);
                return userRepository.save(user);
        }

        public void deleteUserRole(Long id, String roleName) {
                log.info("Deleting role {} of user with id {}", roleName, id);
                User user = userRepository.findById(id)
                        .orElseThrow(() -> new UsernameNotFoundException("This User Does Not Exists!"));
                Role role = roleRepository.findByName(roleName)
                        .orElseThrow(() -> new EntityNotFoundException("This Role Does Not Exists!"));
                user.getRoles().remove(role);
        }

        public void deleteInsurance(Long id) {
                log.info("Deleting insurance with id {}", id);
                insuranceRepository.deleteById(id);
        }
}
