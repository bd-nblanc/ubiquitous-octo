/* Copyright (c) 2024 Blackduck, Inc. All rights reserved worldwide. */
package com.nbdg.server.model;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.UUID;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Entity
@Table(name = "bank")
@Getter
@Setter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Slf4j
public class Bank implements Serializable {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "name", updatable = false, nullable = false)
    private String name;

    @Column(name = "created_at", updatable = false, nullable = false)
    private OffsetDateTime createdAt;
}
