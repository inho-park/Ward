package com.inho.ward.account.service;

import com.inho.ward.account.dto.AccountDTO;
import com.inho.ward.account.repo.AccountRepository;
import com.inho.ward.user.domain.User;
import com.inho.ward.user.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Log4j2
@Service
@Transactional
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

    @Override
    public AccountDTO saveAccount(AccountDTO accountDTO) {
        Long userId = accountDTO.getUserId();
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            accountRepository.save(dtoToEntity(accountDTO, user.get()));
            return accountDTO;
        } else {
            throw new RuntimeException("puuid를 등록할 계정 조회 오류");
        }
    }


}
