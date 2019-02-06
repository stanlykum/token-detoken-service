package com.cts.token.detoken.api.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Tokenizer {
    private String cardNo;
    private String tokenNo;

}