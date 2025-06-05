package com.inho.ward.account.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountDTO {
    private String puuid;
    private String gameName;
    private String tegLine;
    private Long userId;
}
