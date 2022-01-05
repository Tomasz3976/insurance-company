package com.example1.insurancecompany.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "user")
public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", unique = true, nullable = false)
        private Long id;

        @Column(name = "first_name", nullable = false)
        private String firstName;

        @Column(name = "last_name", nullable = false)
        private String lastName;

        @Column(name = "username", unique = true, nullable = false)
        private String username;

        @Column(name = "day_of_birth", nullable = false)
        private Integer dayOfBirth;

        @Column(name = "month_of_birth", nullable = false)
        private Integer monthOfBirth;

        @Column(name = "year_of_birth", nullable = false)
        private Integer yearOfBirth;

        @Column(name = "email", unique = true, nullable = false)
        private String email;

        @Column(name = "phone", nullable = false)
        private Integer phone;

        @Column(name = "password", nullable = false)
        private String password;

        @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
        @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
        private Collection<Role> roles;

}
