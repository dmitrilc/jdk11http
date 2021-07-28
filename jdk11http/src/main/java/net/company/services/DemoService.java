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
	 * The ObjectMapper instance should be re-used because it is expensive
	 * to create. If a method needs a configuration that requires a specialized
	 * ObjectMapper, the method can use ObjectMapper's copy constructor. 
	 */
	ObjectMapper mapper;
	
	public DemoService() {
		this.mapper = new ObjectMapper();
	}
	
	/**
	 * Turns a json String into a {@code CatFact} object using Jackson2.
	 * @param json the input json {@code String}
	 * @return the parsed CatFact object
	 * @throws JsonMappingException if there is an error with parsing by Jackson2
	 * @throws JsonProcessingException if there is an error with parsing by Jackson2
	 */
	public CatFact toCatFact(String json) throws JsonMappingException, JsonProcessingException{	
		return mapper.readValue(json, CatFact.class);
	}
}
