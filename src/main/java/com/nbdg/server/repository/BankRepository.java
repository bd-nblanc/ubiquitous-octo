/* Copyright (c) 2024 Blackduck, Inc. All rights reserved worldwide. */
package com.nbdg.server.repository;

import com.nbdg.server.model.Bank;
import jakarta.validation.constraints.NotNull;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends JpaRepository<Bank, UUID> {

    Optional<Bank> findById(@NotNull UUID id);
}
