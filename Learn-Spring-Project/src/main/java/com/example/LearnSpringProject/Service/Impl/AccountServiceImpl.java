package com.example.LearnSpringProject.Service.Impl;

import com.example.LearnSpringProject.Dto.AccountDto;
import com.example.LearnSpringProject.Entity.Account;
import com.example.LearnSpringProject.Repository.AccountRepository;
import com.example.LearnSpringProject.Repository.BanksRepository;
import com.example.LearnSpringProject.Repository.CustomerRepository;
import com.example.LearnSpringProject.Service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.DecimalFormat;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final BanksRepository banksRepository;

    private final CustomerRepository customerRepository;

    public void sendMoney(Long senderAcc, Long recieverAcc, double amount) {

        var senderId = accountRepository.findById(senderAcc).orElseThrow();
        var recieverId = accountRepository.findById(recieverAcc).orElseThrow();

        if(senderId.getAccAmount() >= amount){
            senderId.setAccAmount(senderId.getAccAmount()-amount);
            recieverId.setAccAmount(recieverId.getAccAmount() + amount);
            this.accountRepository.saveAndFlush(senderId);
            this.accountRepository.saveAndFlush(recieverId);
        }
        else if(senderId.getAccAmount()< amount){
            log.info("Yeterli bakiyeniz bulunmamaktadır.");
        }

    }

    public void deposit(Long custId, double amount){
        var customerId = accountRepository.findById(custId);
        customerId.get().setAccAmount(customerId.get().getAccAmount() + amount);
    }

    public void withdraw(Long custId, double amount){
        var customerId = accountRepository.findById(custId);

        if(customerId.get().getAccAmount() > amount){
            customerId.get().setAccAmount(customerId.get().getAccAmount() - amount);
        }
        else{
            log.info("Yeterli bakiyeniz bulunmamaktadır !");
        }
    }

    public void invest(Long custId, Long bankId, double amount){
        var customer = customerRepository.findAll();
        var customerId = accountRepository.findById(custId);
        var custAccType = customerId.get().getAccType();

        if(custAccType == 0 && customerId.get().getAccAmount() >= amount)
        {
            var banksId = banksRepository.findById(bankId);
            var banksRate = banksId.get().getBankRate();

            var custKazanci = (amount * 32.0 * 0.15 * banksRate) / 36500.0;

            DecimalFormat df = new DecimalFormat("0.0000");
            log.info(String.valueOf("Kazancınız: " + df.format(custKazanci)));

            customer.get(0).setCustKazanc(custKazanci);


        }
        else{
            log.info("Hesap bakiyeniz ve hesap türünüzü kontrol ediniz. Yalnızca vadeli hesaplar yatırım yapabilir! ");
        }
    }

    @Override
    public AccountDto createAccount(AccountDto newAccount) {
        var customer = customerRepository.findById(newAccount.getCustomerid()).orElseThrow(() -> new NoSuchElementException("No customer found for this id"));
        var account = Account.builder()
                .accAmount(newAccount.getAccAmount())
                .accType(newAccount.getAccType())
                .currency(newAccount.getCurrency())
                .customer(customer)
                .build();
        var createdCustomer = accountRepository.save(account);
        return AccountDto.convertFromAccountEntity(createdCustomer);
    }
}
