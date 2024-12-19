package org.khatep.smartrent.domain.models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LegalDispute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "smart_contract_id")
    private SmartContract smartContract;

    private String disputeType; // "LAWYER" or "COURT"

    private String description;

    private LocalDate createdDate;

    private String status; // "OPEN", "RESOLVED"
}

