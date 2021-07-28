package net.company.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import net.company.pojos.CatFact;

public class JsonUtilsTest {
	
	/**
	 * Tests the toCatFact method. Compares 2 different parsed {@code CatFact} objects.
	 * Mainly attempts to catch for errors during parsing.
	 * <p>
	 * The first object is created from a json String.
	 * <p>
	 * The second object is created from a hard-coded constructor call.
	 * @throws JsonMappingException parsing failed
	 * @throws JsonProcessingException parsing failed
	 */
	@Test
	public void toCatFactTest() throws JsonMappingException, JsonProcessingException {
		String json = "{\"fact\":\"A cat's nose is as unique as a human's fingerprint.\",\"length\":51}";
		
		CatFact fact1 = new CatFact("A cat's nose is as unique as a human's fingerprint.", 51);
		CatFact fact2 = JsonUtils.toCatFact(json);
		
		assertEquals(fact1, fact2);
	}
}
