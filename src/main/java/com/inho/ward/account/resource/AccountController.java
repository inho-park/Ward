package com.inho.ward.account.resource;

import com.inho.ward.account.dto.AccountDTO;
import com.inho.ward.account.dto.GetPuuidDTO;
import com.inho.ward.account.service.AccountService;
import com.inho.ward.account.service.RiotService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("/accounts")
public class AccountController {
    private final AccountService accountService;
    private final RiotService riotService;

    @PostMapping
    public ResponseEntity<AccountDTO> createAccount(@RequestBody final AccountDTO accountDTO) {
        try {
            return new ResponseEntity<AccountDTO>(accountService.saveAccount(accountDTO), HttpStatus.OK);
        }catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/get-info")
    public ResponseEntity<AccountDTO> getPuuid(GetPuuidDTO getPuuidDTO) {
        try {
            return new ResponseEntity<AccountDTO>(riotService.getPuuid(getPuuidDTO), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
