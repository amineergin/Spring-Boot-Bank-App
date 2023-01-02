package com.example.LearnSpringProject.Service;

import com.example.LearnSpringProject.Dto.AccountDto;
import com.example.LearnSpringProject.Entity.Account;
import com.example.LearnSpringProject.Entity.Customer;

public interface AccountService {
    public void sendMoney(Long senderAcc, Long recieverAcc, double amount);

    public void deposit(Long custId, double amount);

    public void withdraw(Long custId, double amount);

    public void invest(Long custId, Long bankId, double amount);

    public AccountDto createAccount(AccountDto newAccount);

}
