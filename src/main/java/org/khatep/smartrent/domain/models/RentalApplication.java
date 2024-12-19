package org.khatep.smartrent.domain.models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RentalApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "property_listing_id")
    private PropertyListing propertyListing;

    @ManyToOne
    @JoinColumn(name = "renter_account_id")
    private Account renterAccount;

    private String status; // "PENDING", "ACCEPTED", "REJECTED"

    private LocalDate applicationDate;
}
