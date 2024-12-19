package org.khatep.smartrent.domain.models;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PropertyListing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;

    private Double area;

    private String description;

    private BigDecimal rentAmount;

    private BigDecimal depositAmount;

    private LocalDate availableFrom;

    private LocalDate availableTo;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @OneToMany(mappedBy = "propertyListing", cascade = CascadeType.ALL)
    private List<RentalApplication> rentalApplications;
}