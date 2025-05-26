/* Copyright (c) 2024 Blackduck, Inc. All rights reserved worldwide. */
package com.nbdg.server;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@Slf4j
public class BankApplication
{

    public static void main(String[] args) {
        log.info("Running Bank application");
        SpringApplication.run(BankApplication.class, args);
    }
}
