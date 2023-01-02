package com.example.LearnSpringProject.Controller;

import com.example.LearnSpringProject.Dto.BankDto;
import com.example.LearnSpringProject.Entity.Banks;
import com.example.LearnSpringProject.Service.Impl.BanksServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Banks")
public class BanksController {
    private final BanksServiceImpl banksService;

    @PostMapping("/createBank")
    public Banks createBanks(@RequestBody BankDto newBank){
        return banksService.createBanks(newBank);
    }
}
