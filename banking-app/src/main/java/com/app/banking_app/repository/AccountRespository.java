package com.app.banking_app.repository;

import com.app.banking_app.pojo.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRespository extends JpaRepository<Account, Long> {

}
