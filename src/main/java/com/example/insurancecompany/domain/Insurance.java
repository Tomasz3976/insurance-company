package com.example.insurancecompany.domain;

import com.example.insurancecompany.constant.InsuranceType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "insurance")
public class Insurance {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", unique = true, nullable = false)
        private Long id;

        @Enumerated(EnumType.STRING)
        @Column(name = "type", nullable = false)
        private InsuranceType type;

        @Column(name = "start_date", nullable = false)
        private LocalDate startDate;

        @Column(name = "end_date", nullable = false)
        private LocalDate endDate;

        @Column(name = "price", nullable = false)
        private Integer price;

        @Column(name = "printable_details", nullable = false)
        private String printableDetails;

        @ManyToOne
        @JoinColumn(name = "user_id", referencedColumnName = "id")
        private User user;

}
