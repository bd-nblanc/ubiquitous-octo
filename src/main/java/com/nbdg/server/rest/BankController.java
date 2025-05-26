/* Copyright (c) 2024 Blackduck, Inc. All rights reserved worldwide. */
package com.nbdg.server.rest;

import java.util.Optional;
import java.util.UUID;

import com.nbdg.server.BankException;
import com.nbdg.server.model.Account;
import com.nbdg.server.model.Bank;
import com.nbdg.server.repository.AccountRepository;
import com.nbdg.server.repository.BankRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping(path = "/")
public class BankController
{
    private final AccountRepository accountRepository;
    private final BankRepository bankRepository;

    @PostMapping("/{bankUuid}/{accountUuid}")
    public ResponseEntity<?> newOperation(
      @PathVariable String bankUuid,
      @PathVariable String accountUuid,
      @RequestParam("operation") String operation,
      @RequestParam("money") Long money) throws BankException
    {
        Optional<Bank> optionalBank = bankRepository.findById(UUID.fromString(bankUuid));
        Bank bank = optionalBank.orElseThrow(() -> new BankException("Bank not found with ID: " + bankUuid));

        Optional<Account> optionalAccount = accountRepository.findById(UUID.fromString(accountUuid));
        Account account = optionalAccount.orElseThrow(() -> new BankException("Account not found with ID: " + bankUuid));

        if (!account.getBank().equals(bank)) {
            return ResponseEntity.badRequest().build();
        }

        if (operation.equals("deposit"))
        {
            account.setBalance(account.getBalance() + money);
        }
        else if (operation.equals("withdraw"))
        {
            account.setBalance(account.getBalance() - money);
        }
        accountRepository.save(account);
        return ResponseEntity.ok().build();
    }
}
