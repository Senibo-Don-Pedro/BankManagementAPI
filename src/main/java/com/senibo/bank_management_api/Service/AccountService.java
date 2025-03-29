package com.senibo.bank_management_api.Service;

import com.senibo.bank_management_api.Entity.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {

    public Account createAccount(Account account);
    public Optional<Account> getAccountDetailsByAccountNumber(Long accountNumber);
    public List<Account> getAllAccountDetails();
    public Account depositMoney(Long accountNumber, Double money);
    public Account withDrawAmount(Long accountNumber, Double amount);
    public void closeAccount(Long accountNumber);
}
