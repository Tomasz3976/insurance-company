package com.example.insurancecompany.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Table(name = "confirmation_token")
public class ConfirmationToken {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", unique = true, nullable = false)
        private Long id;

        @Column(name = "token", unique = true, nullable = false)
        private String token;

        @Column(name = "created_at", nullable = false)
        private LocalDateTime createdAt;

        @Column(name = "expiresAt", nullable = false)
        private LocalDateTime expiresAt;

        @Column(name = "confirmed_at")
        private LocalDateTime confirmedAt;

        @ManyToOne
        @JoinColumn(nullable = false, name = "app_user_id", referencedColumnName = "id")
        private User user;

        public ConfirmationToken(String token,
                                 LocalDateTime createdAt,
                                 LocalDateTime expiresAt,
                                 User user) {
                this.token = token;
                this.createdAt = createdAt;
                this.expiresAt = expiresAt;
                this.user = user;
        }

}
