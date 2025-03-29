package com.senibo.bank_management_api.Controller;

import com.senibo.bank_management_api.Entity.Account;
import com.senibo.bank_management_api.Service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/account")
public class AccountController {

//    This can be used, but dependency injection with constructor is generally preferred
//    @Autowired
//    AccountService service;

    private final AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {

        Account createAccount = service.createAccount(account);

        return ResponseEntity.status(HttpStatus.CREATED).body(createAccount);
    }

    @GetMapping("/{accountNumber}")
    public ResponseEntity<Account> getAccountByAccountNumber(@PathVariable Long accountNumber) {
        Optional<Account> accountOptional = service.getAccountDetailsByAccountNumber(accountNumber);

        return accountOptional
                .map(account -> ResponseEntity.ok(account))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("/getAllAccounts")
    public List<Account> getAllAccountDetails() {
        return service.getAllAccountDetails();
    }

    @PutMapping("/deposit/{accountNumber}/{amount}")
    public Account depositAccount(@PathVariable Long accountNumber, @PathVariable Double amount) {
        return service.depositMoney(accountNumber, amount);
    }

    @PutMapping("/withdraw/{accountNumber}/{amount}")
    public Account withdrawAccount(@PathVariable Long accountNumber, @PathVariable Double amount) {
        return service.withDrawAmount(accountNumber, amount);
    }

    @DeleteMapping("delete/{accountNumber}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long accountNumber) {
        service.closeAccount(accountNumber);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Account " + accountNumber + " Deleted");
    }
}
