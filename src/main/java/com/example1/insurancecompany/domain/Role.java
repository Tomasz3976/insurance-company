package com.example1.insurancecompany.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "role")
public class Role {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", unique = true, nullable = false)
        private Long id;

        @Column(name = "name", unique = true, nullable = false)
        private String name;

        @JsonIgnore
        @ManyToMany(cascade = CascadeType.ALL, mappedBy = "roles")
        private Collection<User> users;

}
