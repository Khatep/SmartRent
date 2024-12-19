package org.khatep.smartrent.repositories;

import org.khatep.smartrent.domain.models.RentalApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalApplicationRepository extends JpaRepository<RentalApplication, Long> {

}
