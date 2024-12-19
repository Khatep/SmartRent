package org.khatep.smartrent.domain.models;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal balance;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userr;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<PropertyListing> propertyListings;
}
