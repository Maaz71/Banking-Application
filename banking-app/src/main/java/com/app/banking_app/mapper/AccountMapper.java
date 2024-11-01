package com.app.banking_app.mapper;

import com.app.banking_app.dto.AccountDto;
import com.app.banking_app.pojo.Account;

public class AccountMapper {
    public static Account mapToAccount(AccountDto accountDto){  //method to create account Dto to Jpa Entity
        Account account = new Account(
                accountDto.getId(),
                accountDto.getAccountHolderName(),
                accountDto.getBalance()
        );
        return account;
    }

    public static AccountDto mapToAccountDto(Account account)
    {
        AccountDto accountDto = new AccountDto(
                account.getId(),
                account.getAccHolderName(),
                account.getBalance()
        );
        return accountDto;
    }

}
