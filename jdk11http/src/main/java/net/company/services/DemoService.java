package net.company.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import net.company.pojos.CatFact;

import static net.company.services.JsonUtils.*;

/**
 * A service class that performs processing for business logic.
 * @author dmitrilc
 *
 */
public class DemoService {
	
	/**
	 * Each controller will have a httpClient attached to it. the instance
	 * must be instantiated manually because the project is not using
	 * dependency injection.
	 */
	private final HttpClient httpClient;
	
	/**
	 * The URI string that already contains String interpolation symbols.
	 */
	private static final String randomFactURI = "https://catfact.ninja/fact?max_length=%d";
	
	public DemoService() {
		this.httpClient = HttpClient.newHttpClient();
	}
	
	/**
	 * Retrives a random cat fact from Postman's free API.
	 * @param maxLength maximum length of the fact string
	 * @return a new @{code CatFact} object after parsing the response body with
	 * {@code Jackson2}
	 * @throws IOException if an error occured when sending the request
	 * @throws InterruptedException if an illegal parameter was passed to the 
	 * internal HttpRequest builder.
	 */
	public CatFact getRandomCatFact(int maxLength) throws IOException, InterruptedException {
		//Creates a new request
		HttpRequest req = HttpRequest.newBuilder()
			      .uri(URI.create(String.format(randomFactURI, maxLength)))
			      .build();
		
		//Gets response with the body as String
		HttpResponse<String> res = this.httpClient.send(req, BodyHandlers.ofString());
		
		//Parses the response body into a CatFact object using JsonUtils
		return toCatFact(res.body());
	}
	

}
