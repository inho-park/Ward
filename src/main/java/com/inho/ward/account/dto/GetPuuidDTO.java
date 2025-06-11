package com.inho.ward.account.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetPuuidDTO {
    private long userId;
    private String gameName;
    private String tagLine;
}
