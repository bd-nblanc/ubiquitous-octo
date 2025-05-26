/* Copyright (c) 2024 Blackduck, Inc. All rights reserved worldwide. */
package com.nbdg.server.repository;

import java.util.Optional;
import java.util.UUID;

import com.nbdg.server.model.Account;
import com.nbdg.server.model.Bank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, UUID> {

    Optional<Account> findById(@NotNull UUID id);
}
