package com.senibo.bank_management_api.Service;

import com.senibo.bank_management_api.Entity.Account;
import com.senibo.bank_management_api.Repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository repository;

    public AccountServiceImpl(AccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public Account createAccount(Account account) {
        return repository.save(account);
    }

    @Override
    public Optional<Account> getAccountDetailsByAccountNumber(Long accountNumber) {
        return repository.findById(accountNumber);
    }

    @Override
    public List<Account> getAllAccountDetails() {
        return repository.findAll();
    }

    @Override
    public Account depositMoney(Long accountNumber, Double money) {
        Optional<Account> getAcountById = repository.findById(accountNumber);

        if(getAcountById.isEmpty()) {
            throw new RuntimeException("Account is not present");
        }

        Account account1 = getAcountById.get();

        double totalBalance = account1.getAccount_balance() + money;

        account1.setAccount_balance(totalBalance);
        repository.save(account1);

        return account1;
    }

    @Override
    public Account withDrawAmount(Long accountNumber, Double money) {
        Optional<Account> getAcountById = repository.findById(accountNumber);

        if(getAcountById.isEmpty()) {
            throw new RuntimeException("Account is not present");
        }

        Account account1 = getAcountById.get();

        double totalBalance = account1.getAccount_balance() - money;

        account1.setAccount_balance(totalBalance);
        repository.save(account1);

        return account1;
    }

    @Override
    public void closeAccount(Long accountNumber) {
        repository.deleteById(accountNumber);
    }
}
