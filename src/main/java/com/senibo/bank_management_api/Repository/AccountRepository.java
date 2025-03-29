package com.senibo.bank_management_api.Repository;

import com.senibo.bank_management_api.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
