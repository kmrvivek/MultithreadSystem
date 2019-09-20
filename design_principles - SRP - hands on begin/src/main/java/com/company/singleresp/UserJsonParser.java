package com.company.singleresp;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class UserJsonParser {
	
	public User parseUserJson(String userJson) {
	 ObjectMapper mapper = new ObjectMapper();
     
     User user = null;;
	try {
		user = mapper.readValue(userJson, User.class);
	} catch (IOException e) {
		e.printStackTrace();
	}
     return user;
	}
}
