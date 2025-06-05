package com.inho.ward.account.service;

import com.inho.ward.account.domain.Account;
import com.inho.ward.account.dto.AccountDTO;
import com.inho.ward.user.domain.User;

public interface AccountService {
    AccountDTO saveAccount(AccountDTO accountDTO);

    default AccountDTO entityToDTO(Account account) {
        return AccountDTO.builder()
                .gameName(account.getGameName())
                .tegLine(account.getTegLine())
                .puuid(account.getPuuid())
                .userId(account.getUser().getId())
                .build();
    }

    default Account dtoToEntity(AccountDTO accountDTO, User user) {
        return Account.builder()
                .gameName(accountDTO.getGameName())
                .tegLine(accountDTO.getTegLine())
                .puuid(accountDTO.getPuuid())
                .user(user)
                .build();
    }
}
