package com.app.banking_app.controller;

import com.app.banking_app.dto.AccountDto;
import com.app.banking_app.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // makes class as SpringMVC Rest Controller class
@RequestMapping("/api/accounts")
public class AccountController {

    private AccountService accountService;  //no need to use @Autowired anno as this class has only 1 cnstrt so spring will automatically inject dependency


    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    //add Account Rest Api
    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto) //@Requestbody converts incoming json into java object
    {

        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id){
        AccountDto accountDto = accountService.getAccountById(id);
        return ResponseEntity.ok(accountDto);
    }
}
