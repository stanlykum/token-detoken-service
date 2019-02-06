package com.cts.token.detoken.api.service;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.cts.token.detoken.api.domain.Detokenizer;
import com.cts.token.detoken.api.domain.Tokenizer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DetokenService {
	private static Map<String, Detokenizer> deTokenizerMap = new HashMap<>();

	static {

		deTokenizerMap.put("1234567899111176", new Detokenizer("1234567899111176", "6000445214789650"));
		deTokenizerMap.put("1234567899111177", new Detokenizer("1234567899111177", "6000445214789660"));
		deTokenizerMap.put("1234567899111178", new Detokenizer("1234567899111178", "6000445214789670"));
		deTokenizerMap.put("1234567899111179", new Detokenizer("1234567899111179", "6000445214789680"));
		deTokenizerMap.put("1234567899111180", new Detokenizer("1234567899111180", "6000445214789690"));
	}

	public Detokenizer findCardNoByTokenNo(String tokenNo) {
		// Map -> Stream -> Filter -> String
		String cardNo = "";
		cardNo = deTokenizerMap.entrySet().stream().filter(map -> tokenNo.equals(map.getKey()))
				.map(map -> map.getValue().getCardNo()).collect(Collectors.joining());
		log.info("De-tokenized Value is {}    ",cardNo);
		return new Detokenizer(tokenNo, cardNo);
	}
}