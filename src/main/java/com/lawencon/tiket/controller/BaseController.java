package com.lawencon.tiket.controller;

import java.io.IOException;

//by Muhammad Nur Ali


import java.util.Base64;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class BaseController<T> {
	
	T model;
	
	public String[] authUser(String authorization) {
		byte[] decodedBytes = Base64.getDecoder().decode(authorization);
		String decodedString = new String(decodedBytes);
		String[] authArr = decodedString.split(":");
		return authArr;
	}
	
	public T readValue(String content, Class<T> kelas) throws JsonParseException, JsonMappingException, IOException{
		return new ObjectMapper().readValue(content, kelas);
	}
}
