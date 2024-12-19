package org.khatep.smartrent.repositories;

import org.khatep.smartrent.domain.models.SmartContract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SmartContractRepository extends JpaRepository<SmartContract, Long> {

}
