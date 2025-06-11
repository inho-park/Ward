package com.inho.ward.account.service;

import com.inho.ward.account.dto.AccountDTO;
import com.inho.ward.account.dto.GetPuuidDTO;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public interface RiotService {
    AccountDTO getPuuid(GetPuuidDTO accountDTO) throws IOException;

    default String encodingUTF(String string) throws IOException {
        try {
            return URLEncoder.encode(string, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedEncodingException(string);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("오류 발생");
        }
    }
}
