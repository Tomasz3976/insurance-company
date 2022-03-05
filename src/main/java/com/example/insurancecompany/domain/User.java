package com.example.insurancecompany.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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

        @JsonIgnore
        @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
        private Collection<Insurance> insurances;

        @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
        @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
        private Collection<Role> roles;

}
