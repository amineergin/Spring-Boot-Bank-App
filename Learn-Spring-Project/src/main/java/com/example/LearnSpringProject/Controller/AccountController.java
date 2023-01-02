package com.example.LearnSpringProject.Controller;

import com.example.LearnSpringProject.Dto.AccountDto;
import com.example.LearnSpringProject.Entity.Account;
import com.example.LearnSpringProject.Entity.Customer;
import com.example.LearnSpringProject.Service.Impl.AccountServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Account")
public class AccountController {
    private final AccountServiceImpl accountService;

    @PostMapping("/sendMoney")
    public void sendMoney(Long senderAcc,Long recieverAcc,double amount){
        accountService.sendMoney(senderAcc,recieverAcc,amount);
    }

    @PostMapping("/deposit/{custId}/{amount}")
            public void deposit(@PathVariable Long custId, @PathVariable double amount){
        accountService.deposit(custId,amount);
    }

    @PostMapping("/withdraw/{custId}/{amount}")
    public void withdraw(@PathVariable Long custId,@PathVariable double amount){
        accountService.withdraw(custId,amount);
    }

    @PostMapping("/Invest/{custId}/{bankId}/{amount}")
    public void invest(@PathVariable Long custId,@PathVariable Long bankId,@PathVariable double amount){
        accountService.invest(custId, bankId, amount);
    }

    @PostMapping("/createAccount")
    public AccountDto createAccount(@RequestBody AccountDto newAccount)
    {
        return accountService.createAccount(newAccount);
    }
}
