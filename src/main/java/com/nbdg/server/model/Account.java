/* Copyright (c) 2024 Blackduck, Inc. All rights reserved worldwide. */
package com.nbdg.server.model;

import java.io.*;
import java.time.OffsetDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;


@Entity
@Table(name = "bank_account")
@Getter
@Setter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Slf4j
public class Account implements Serializable {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bank_id", nullable = false)
    private Bank bank;

    @Column(name = "created_at", updatable = false, nullable = false)
    private OffsetDateTime createdAt;

    @Column(name = "balance", nullable = true)
    private Long balance;
}
