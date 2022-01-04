package com.example1.insurancecompany.repository;

import com.example1.insurancecompany.domain.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

        @Query("Select u From User u Order By u.id Asc")
        List<User> findUsers(Pageable pageable);

        Optional<User> findByUsername(String username);

}
