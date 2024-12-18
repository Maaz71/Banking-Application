package com.app.banking_app.service.impl;

import com.app.banking_app.dto.AccountDto;
import com.app.banking_app.mapper.AccountMapper;
import com.app.banking_app.pojo.Account;
import com.app.banking_app.repository.AccountRespository;
import com.app.banking_app.service.AccountService;
import org.springframework.stereotype.Service;

@Service //to automatically create spring bean
public class AccountServiceImpl implements AccountService {

    private AccountRespository accountRespository;

    public AccountServiceImpl(AccountRespository accountRespository) {
        this.accountRespository = accountRespository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {

        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount =accountRespository.save(account); // save() return saved entity

        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {

        Account account =accountRespository
                .findById(id)
                .orElseThrow(()-> new RuntimeException("Account does not exist")  );

        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(Long id, double amount) {
         Account account = accountRespository.
                 findById(id).
                 orElseThrow(()-> new RuntimeException("Account does not exist"));
         double total = account.getBalance() + amount;
         account.setBalance(total);
         Account savedAccount = accountRespository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }
}
