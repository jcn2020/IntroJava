package com.sb.springbootdemo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/bank")
public class BankController {


    private List<Account> accounts;
    public BankController() {
        accounts = new ArrayList<>();
        Account ac = new CheckingAccount("Bob", 38383, Status.ABANDONED);
        accounts.add(ac);

        ac = new SavingsAccount("Sammy", 93939);
        accounts.add(ac);

        ac = new SavingsAccount("Bobery", 93939);
        accounts.add(ac);


        ac = new SavingsAccount("Rahul", 50000);
        accounts.add(ac);

        ac = new SavingsAccount("Zoey", 383989393);
        accounts.add(ac);
    }

    //@GetMapping("/{abc}")
    public Account getAccountSimpl(@PathVariable("abc") int id) {
        for(Account account : accounts) {
            if(account.getId() == id) {
                return account;
            }
        }
        return null;
    }

    @GetMapping
    public List<Account> getAll() {
        return accounts;
    }

    @GetMapping("/{abc}")
    public ResponseEntity<?> getAccount(@PathVariable("abc") int id) {
        for(Account account : accounts) {
            if(account.getId() == id) {
                return ResponseEntity.ok(account);
            }
        }
        return ResponseEntity.notFound().build();
    }
}
