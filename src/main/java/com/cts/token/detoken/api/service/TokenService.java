package com.cts.token.detoken.api.service;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.cts.token.detoken.api.domain.Tokenizer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TokenService {

	private static Map<String, Tokenizer> tokenizerMap = new HashMap<>();

	static {
		tokenizerMap.put("6000445214789650", new Tokenizer("6000445214789650", "1234567899111176"));
		tokenizerMap.put("6000445214789660", new Tokenizer("6000445214789660", "1234567899111177"));
		tokenizerMap.put("6000445214789670", new Tokenizer("6000445214789670", "1234567899111178"));
		tokenizerMap.put("6000445214789680", new Tokenizer("6000445214789680", "1234567899111179"));
		tokenizerMap.put("6000445214789690", new Tokenizer("6000445214789690", "1234567899111180"));
	}

	public Tokenizer findTokenByCardNo(String cardNo) {
		// Map -> Stream -> Filter -> String
		String token = "";
		token = tokenizerMap.entrySet().stream().filter(map -> cardNo.equals(map.getKey()))
				.map(map -> map.getValue().getTokenNo()).collect(Collectors.joining());
		log.info("Tokenized Value is {}",token);
		return new Tokenizer(cardNo, token);
	}
}
