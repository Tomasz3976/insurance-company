package com.example1.insurancecompany.domain;

import com.example1.insurancecompany.constant.InsuranceType;
import lombok.*;

import javax.persistence.*;
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

        @ManyToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "user_id", referencedColumnName = "id")
        private User user;

}
