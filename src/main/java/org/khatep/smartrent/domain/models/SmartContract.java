package org.khatep.smartrent.domain.models;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SmartContract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "property_listing_id")
    private PropertyListing propertyListing;

    @ManyToOne
    @JoinColumn(name = "renter_account_id")
    private Account renterAccount;

    private BigDecimal rentAmount;

    private BigDecimal depositAmount;

    private LocalDate startDate;

    private LocalDate endDate;

    private String contractHash; // Blockchain reference

    private boolean active;

}
