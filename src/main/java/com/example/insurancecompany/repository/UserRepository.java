package com.example.insurancecompany.repository;

import com.example.insurancecompany.domain.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

        @Query("Select u From User u Order By u.id Asc")
        List<User> findUsers(Pageable pageable);

        Optional<User> findByUsername(String username);

        Optional<User> findByEmail(String email);

}
