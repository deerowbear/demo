package com.demo.service.remote.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class BaseRequest {


	@Override
	public String toString() {
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		try {
			String json = ow.writeValueAsString(this);
			return json;
		} catch (JsonProcessingException ex) {
		}
		return "";
	}

}
