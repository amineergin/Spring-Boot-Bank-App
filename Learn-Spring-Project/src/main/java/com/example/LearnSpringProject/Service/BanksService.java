package com.example.LearnSpringProject.Service;

import com.example.LearnSpringProject.Dto.BankDto;
import com.example.LearnSpringProject.Entity.Banks;
import org.springframework.web.bind.annotation.RequestBody;

public interface BanksService {

    public Banks createBanks(@RequestBody BankDto newBank);
}
