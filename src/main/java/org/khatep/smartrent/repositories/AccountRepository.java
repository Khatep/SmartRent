package org.khatep.smartrent.repositories;

import org.khatep.smartrent.domain.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
