package net.company.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.company.pojos.CatFact;

/**
 * A service class that performs processing for business logic.
 * @author dmitrilc
 *
 */
public class DemoService {
	
	/**
	 * Turns a json String into a {@code CatFact} object using Jackson2.
	 * @param json the input json {@code String}
	 * @return the parsed CatFact object
	 * @throws JsonMappingException if there is an error with parsing by Jackson2
	 * @throws JsonProcessingException if there is an error with parsing by Jackson2
	 */
	public CatFact toCatFact(String json) throws JsonMappingException, JsonProcessingException{
		var mapper = new ObjectMapper();
		
		return mapper.readValue(json, CatFact.class);
	}
}
