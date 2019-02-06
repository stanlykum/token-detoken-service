package com.cts.token.detoken.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.token.detoken.api.domain.Detokenizer;
import com.cts.token.detoken.api.domain.Tokenizer;
import com.cts.token.detoken.api.service.DetokenService;
import com.cts.token.detoken.api.service.TokenService;

@RestController
@RequestMapping("/api/v1")
public class TokenController {

	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private DetokenService detokenService;

	@GetMapping("/token/{cardNo}")
	public Tokenizer retrieveTokenByCardNo(@PathVariable String cardNo) {
		return tokenService.findTokenByCardNo(cardNo);
	}
	
	@GetMapping("/detoken/{tokenNo}")
	public Detokenizer retrieveCardNoByTokenNo(@PathVariable String tokenNo) {
		return detokenService.findCardNoByTokenNo(tokenNo);
	}

}
