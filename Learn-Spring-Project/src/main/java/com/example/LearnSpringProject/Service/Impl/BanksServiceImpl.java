package com.example.LearnSpringProject.Service.Impl;

import com.example.LearnSpringProject.Dto.BankDto;
import com.example.LearnSpringProject.Entity.Banks;
import com.example.LearnSpringProject.Repository.BanksRepository;
import com.example.LearnSpringProject.Service.BanksService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BanksServiceImpl implements BanksService {

    private final BanksRepository banksRepository;

    @Override
    public Banks createBanks(BankDto newBank) {
        Banks bank = new Banks();
        bank.setBanksName(newBank.getBanksName());
        bank.setBankRate(newBank.getBankRate());
        return banksRepository.save(bank);
    }
}
