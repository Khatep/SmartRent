package org.khatep.smartrent.repositories;

import org.khatep.smartrent.domain.models.PropertyListing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyListingRepository extends JpaRepository<PropertyListing, Long> {

}
