package com.inho.ward.account.repo;

import com.inho.ward.account.domain.Account;
import com.inho.ward.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository  extends JpaRepository<Account, Long> {
    List<Account> findAllByUser(User user);
}
