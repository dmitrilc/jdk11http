package net.company.controllers;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import net.company.pojos.CatFact;
import net.company.services.DemoService;

/**
 * A controller that is mainly used for managing the http requests. This
 * class should not perform too much response body handling and parsing.
 * Such tasks should be performed by a dedicated class.
 * @author dmitrilc
 *
 */
public class DemoController {
	
	/**
	 * The URI string that already contains String interpolation symbols.
	 */
	private static final String randomFactURI = "https://catfact.ninja/fact?max_length=%d";
	
	/**
	 * Each controller will have a httpClient attached to it. the instance
	 * must be instantiated manually because the project is not using
	 * dependency injection.
	 */
	private HttpClient httpClient = HttpClient.newHttpClient();
	
	/**
	 * The service class that performs processing/parseing of responses.
	 */
	private DemoService demoService = new DemoService();
	
	public DemoController() {
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
		
		//Parses the response body into a CatFact object using DemoService
		return this.demoService.toCatFact(res.body());
	}

}
