package com.app.banking_app.service.impl;

import com.app.banking_app.dto.AccountDto;
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
        return null;
    }
}
