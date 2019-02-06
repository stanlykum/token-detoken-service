package com.cts.token.detoken.api.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Detokenizer {
    private String tokenNo;
    private String cardNo;
}